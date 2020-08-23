package de.codefor.bielefeld.radentscheid.unfallserver.adapter.web;

import de.codefor.bielefeld.radentscheid.unfallserver.adapter.json.AccidentRepo;
import de.codefor.bielefeld.radentscheid.unfallserver.domain.Accident;
import de.codefor.bielefeld.radentscheid.unfallserver.domain.Location;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * author skonair@gmail.com
 * date 19.08.20
 */
@Controller
@RequestMapping("/tiles")
public class HeatmapTileController {

    private final AccidentRepo accidentRepo;

    HeatmapTileController(AccidentRepo accidentRepo) {
        this.accidentRepo = accidentRepo;
    }

    private static final int BYTE_PER_PIXEL = 4;
    private static final int DEFAULT_OPACITY = 60;
    private static final int DEFAULT_TILE_SIZE_X = 256;
    private static final int DEFAULT_TILE_SIZE_Y = 256;


    @GetMapping(value = "/{z}/{x}/{y}.png", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getTile(
            @PathVariable("z") int zoom,
            @PathVariable("x") int xTile,
            @PathVariable("y") int yTile,
            @RequestParam(value = "opacity", required = false) Integer opacityRequest,
            @RequestParam(value = "tileSizeX", required = false) Integer tileSizeXRequest,
            @RequestParam(value = "tileSizeY", required = false) Integer tileSizeYRequest,
            @RequestParam(value = "month", required = false) Integer month,
            @RequestParam(value = "expansion", required = false) Integer expansionRate
    ) throws IOException {

        Location tileLoc = Location.fromTile(xTile, yTile, zoom);

//        System.out.println("getTile(): " + zoom + ", " + xTile + ", " + yTile + " ---> " + tileLoc);
//        System.out.println("http://localhost:8080/tiles/" + zoom + "/" + xTile + "/" + yTile + ".png");
//        System.out.println("https://a.tile.osm.org/" + zoom + "/" + xTile + "/" + yTile + ".png");

        byte opacity = (byte) DEFAULT_OPACITY;
        if (opacityRequest != null) {
            opacity = opacityRequest.byteValue();
        }

        int tileSizeX = DEFAULT_TILE_SIZE_X;
        if (tileSizeXRequest != null) {
            tileSizeX = tileSizeXRequest;
        }

        int tileSizeY = DEFAULT_TILE_SIZE_Y;
        if (tileSizeYRequest != null) {
            tileSizeY = tileSizeYRequest;
        }

        Location tileLoc2 = Location.fromTile(xTile + 1, yTile + 1, zoom);
        double tileWidthInDegree = tileLoc2.lng() - tileLoc.lng();
        double tileHeightInDegree = tileLoc.lat() - tileLoc2.lat();
        int expansion = 100;
        if (expansionRate != null) {
            expansion = expansionRate;
        }
        double factor = Math.pow(2, zoom) / expansion;

        Location center = new Location(
                tileLoc.lat() + (tileWidthInDegree / 2),
                tileLoc.lng() - (tileHeightInDegree / 2)
        );
        final Set<Accident> accidents;
        if (month == null) {
            accidents = accidentRepo.findByDistance(center, tileWidthInDegree * 2);
        } else {
            accidents = accidentRepo.findByDateAndDistance(2019, month, center, tileWidthInDegree * 2);
        }
        Set<Location> relevantLocations = accidents.stream()
                .map(Accident::location)
                .collect(Collectors.toSet());

        byte[] bytes = new byte[tileSizeY * tileSizeX * BYTE_PER_PIXEL];
        for (int y = 0; y < tileSizeY; y++) {
            double yInWgs84 = tileLoc.lat() - (y * tileHeightInDegree / DEFAULT_TILE_SIZE_Y);
            for (int x = 0; x < DEFAULT_TILE_SIZE_X; x++) {
                double xInWgs84 = tileLoc.lng() + (x * tileWidthInDegree / DEFAULT_TILE_SIZE_X);
                Location current = new Location(yInWgs84, xInWgs84);

                double nearestDistance = current.nearest(relevantLocations)
                        .map(n -> n.distance(current))
                        .orElse(Double.MAX_VALUE);

                byte opa = (byte) 0;
                if (nearestDistance < (1d/factor))
                    opa = (byte) (255 - 255 * (nearestDistance * factor));

                int offset = BYTE_PER_PIXEL * (y * tileSizeX + x);
                // rgba
                if (y == 0 || x == 0) {
                  bytes[offset] = (byte) 108;
                  bytes[offset + 1] = (byte) 108;
                  bytes[offset + 2] = (byte) 255;
                  bytes[offset + 3] = (byte) 128;
                } else {
                    bytes[offset] = (byte) 255;
                    bytes[offset + 1] = (byte) 108;
                    bytes[offset + 2] = (byte) 108;
                    bytes[offset + 3] = opa;
                }
            }
        }

        DataBuffer buffer = new DataBufferByte(bytes, bytes.length);

        //4 bytes per pixel: red, green, blue, alpha
        final WritableRaster raster = Raster.createInterleavedRaster(
                buffer,
                tileSizeX,
                tileSizeY,
                BYTE_PER_PIXEL * tileSizeY,
                BYTE_PER_PIXEL,
                new int[] {0, 1, 2, 3},
                (Point)null
        );
        final ColorModel cm = new ComponentColorModel(
                ColorModel.getRGBdefault().getColorSpace(),
                true,
                false,
                Transparency.OPAQUE,
                DataBuffer.TYPE_BYTE
        );
        final BufferedImage image = new BufferedImage(cm, raster, true, null);
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

}

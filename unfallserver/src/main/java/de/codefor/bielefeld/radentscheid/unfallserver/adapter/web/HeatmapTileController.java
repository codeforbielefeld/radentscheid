package de.codefor.bielefeld.radentscheid.unfallserver.adapter.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * author skonair@gmail.com
 * date 19.08.20
 */
@Controller
@RequestMapping("/tiles")
public class HeatmapTileController {

    private static final int TILE_SIZE_X = 256;
    private static final int TILE_SIZE_Y = 256;

    @GetMapping(value = "/{z}/{x}/{y}.png", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getTile(
            @PathVariable("z") int zoom,
            @PathVariable("x") double xPos,
            @PathVariable("y") double yPos,
            @RequestParam("opacity") Integer opacityRequest
    ) throws IOException {
        byte opacity = 0x00;
        if (opacityRequest != null) {
            opacity = opacityRequest.byteValue();
        }
        final int bytePerPixel = 4;
        byte[] bytes = new byte[TILE_SIZE_Y * TILE_SIZE_X * bytePerPixel];
        for (int y = 0; y < TILE_SIZE_Y; y++) {
            int by = 128 - (int) (128 * Math.sin(y * Math.PI / TILE_SIZE_Y ));
            for (int x = 0; x < TILE_SIZE_X; x++) {
                int bx = 128 - (int) (128 * Math.sin(x * Math.PI / TILE_SIZE_X ));
                int offset = bytePerPixel * (y * TILE_SIZE_X + x);
                // rgb
                bytes[offset] = (byte) 255;
                bytes[offset + 1] = (byte) (by + bx);
                bytes[offset + 2] = (byte) (by + bx);
                bytes[offset + 3] = opacity;
            }
        }

        DataBuffer buffer = new DataBufferByte(bytes, bytes.length);

        //3 bytes per pixel: red, green, blue
        WritableRaster raster = Raster.createInterleavedRaster(
                buffer,
                TILE_SIZE_X,
                TILE_SIZE_Y,
                bytePerPixel * TILE_SIZE_Y,
                bytePerPixel,
                new int[] {0, 1, 2, 3},
                (Point)null
        );
        ColorModel cm = new ComponentColorModel(
                ColorModel.getRGBdefault().getColorSpace(),
                true,
                false,
                Transparency.OPAQUE,
                DataBuffer.TYPE_BYTE
        );
        BufferedImage image = new BufferedImage(cm, raster, true, null);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

}

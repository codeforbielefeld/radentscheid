package de.codefor.bielefeld.radentscheid.unfallserver.domain;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
public class Location {

    private final double lat;
    private final double lng;

    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public static Location fromTile(double xTile, double yTile, int zoom) {
        double n = Math.PI - (2.0 * Math.PI * yTile) / Math.pow(2.0, zoom);
        double lat = Math.toDegrees(Math.atan(Math.sinh(n)));
        double lng = xTile / Math.pow(2.0, zoom) * 360.0 - 180;
        return new Location(lat, lng);
    }

    public double lat() {
        return lat;
    }

    public double lng() {
        return lng;
    }

    public double distance(Location o) {
        return Math.sqrt((this.lat - o.lat) * (this.lat - o.lat) + (this.lng - o.lng) * (this.lng - o.lng));
    }

    public Optional<Location> nearest(Set<Location> locations) {
        return locations.parallelStream()
                .min(Comparator.comparingDouble(this::distance));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.lat, lat) == 0 &&
                Double.compare(location.lng, lng) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lng);
    }

    @Override
    public String toString() {
        return "Location{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}

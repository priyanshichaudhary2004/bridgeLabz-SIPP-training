package Utils;
import Models.Location;

public interface GeoUtils {
    static double calculateDistance(Location a, Location b) {
        double dx = a.getLat() - b.getLat();
        double dy = a.getLon() - b.getLon();
        return Math.sqrt(dx * dx + dy * dy);
    }
}

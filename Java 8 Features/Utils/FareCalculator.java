package Utils;
import Models.Location;

@FunctionalInterface
public interface FareCalculator {
    double calculateFare(Location from, Location to, boolean peak);
}

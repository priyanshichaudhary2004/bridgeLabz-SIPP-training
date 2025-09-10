package Services;
import java.util.List;

import Models.Trip;
import Utils.GeoUtils;

public interface TransportService extends GeoUtils {
    String getServiceId();
    String getType();
    List<Trip> getActiveTrips();

    default void printServiceDetails() {
        System.out.println("Service: " + getServiceId() + " Type: " + getType());
        System.out.println("Active trips:");
        getActiveTrips().forEach(System.out::println);
    }

    static long countActiveTrips(TransportService svc) {
        return svc.getActiveTrips().size();
    }
}

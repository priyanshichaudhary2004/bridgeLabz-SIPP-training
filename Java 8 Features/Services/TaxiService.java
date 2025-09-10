package Services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Models.Location;
import Models.Trip;
import Utils.FareCalculator;

public class TaxiService implements TransportService {
    private final String id;
    private final List<Trip> trips;
    private final FareCalculator fareCalculator;

    public TaxiService(String id, List<Trip> trips, FareCalculator fareCalculator) {
        this.id = id;
        this.trips = new ArrayList<>(trips);
        this.fareCalculator = fareCalculator;
    }

    public String getServiceId() { return id; }
    public String getType() { return "TAXI"; }
    public List<Trip> getActiveTrips() { return Collections.unmodifiableList(trips); }

    public double computeFare(Location from, Location to, boolean peak) {
        return fareCalculator.calculateFare(from, to, peak);
    }
}

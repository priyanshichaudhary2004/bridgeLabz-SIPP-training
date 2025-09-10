package Services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Models.Trip;

public class MetroService implements TransportService {
    private final String id;
    private final List<Trip> trips;

    public MetroService(String id, List<Trip> trips) {
        this.id = id;
        this.trips = new ArrayList<>(trips);
    }

    public String getServiceId() { return id; }
    public String getType() { return "METRO"; }
    public List<Trip> getActiveTrips() { return Collections.unmodifiableList(trips); }
}

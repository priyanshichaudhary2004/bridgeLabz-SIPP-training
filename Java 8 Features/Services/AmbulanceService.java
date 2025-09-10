package Services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Emergency.EmergencyService;
import Models.Trip;

public class AmbulanceService implements TransportService, EmergencyService {
    private final String id;
    private final List<Trip> trips;

    public AmbulanceService(String id, List<Trip> trips) {
        this.id = id;
        this.trips = new ArrayList<>(trips);
    }

    public String getServiceId() { return id; }
    public String getType() { return "AMBULANCE"; }
    public List<Trip> getActiveTrips() { return Collections.unmodifiableList(trips); }

    @Override
    public void printServiceDetails() {
        System.out.println("!!! EMERGENCY SERVICE: " + id + " !!!");
        TransportService.super.printServiceDetails();
    }
}

package Models;
import java.time.LocalDateTime;

public class Trip {
    private final String serviceId;
    private final String route;
    private final Location from;
    private final Location to;
    private final LocalDateTime departure;
    private final double fare;
    private final boolean isPeak;
    private final boolean emergency;

    public Trip(String serviceId, String route, Location from, Location to, LocalDateTime departure,
                double fare, boolean isPeak, boolean emergency) {
        this.serviceId = serviceId;
        this.route = route;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.fare = fare;
        this.isPeak = isPeak;
        this.emergency = emergency;
    }

    public String getServiceId() { return serviceId; }
    public String getRoute() { return route; }
    public Location getFrom() { return from; }
    public Location getTo() { return to; }
    public LocalDateTime getDeparture() { return departure; }
    public double getFare() { return fare; }
    public boolean isPeak() { return isPeak; }
    public boolean isEmergency() { return emergency; }

    @Override
    public String toString() {
        return String.format("%s [%s] %s -> %s @%s ₹%.2f%s",
                serviceId, route, from, to, departure.toLocalTime(), fare, emergency ? " (EMER)" : "");
    }
}

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import Emergency.EmergencyService;
import Models.Location;
import Models.Trip;
import Services.AmbulanceService;
import Services.BusService;
import Services.FerryService;
import Services.MetroService;
import Services.TaxiService;
import Services.TransportService;
import Utils.FareCalculator;
import Utils.GeoUtils;

public class SmartCity {

    static Location A = new Location("Terminal A", 12.9716, 77.5946);
    static Location B = new Location("Terminal B", 12.9352, 77.6245);
    static Location C = new Location("Central Park", 12.9580, 77.5919);

    static List<Trip> sampleTrips(String svcId, String route, boolean emergencyFlag) {
        LocalDateTime now = LocalDateTime.now();
        return Arrays.asList(
                new Trip(svcId, route, A, B, now.plusMinutes(5), 30.0, true, emergencyFlag),
                new Trip(svcId, route, B, C, now.plusMinutes(20), 25.0, false, emergencyFlag),
                new Trip(svcId, route, A, C, now.plusMinutes(40), 45.0, false, emergencyFlag)
        );
    }

    static Optional<Trip> bookTrip(List<TransportService> services, Location from, Location to, Comparator<Trip> preference) {
        return services.stream()
                .flatMap(svc -> svc.getActiveTrips().stream())
                .filter(t -> t.getFrom().getName().equals(from.getName()) && t.getTo().getName().equals(to.getName()))
                .sorted(preference)
                .findFirst();
    }

    static void displayDashboard(List<TransportService> services) {
        System.out.println("\n--- DASHBOARD: Active Services ---");
        services.forEach(svc -> {
            System.out.println("Service Header -> " + svc.getServiceId() + " (" + svc.getType() + ")");
            svc.getActiveTrips().forEach(System.out::println);
        });
    }

    static void generateReports(List<Trip> allTrips) {
        System.out.println("\n--- REVENUE & ANALYTICS ---");
        Map<String, Double> revenueByRoute = allTrips.stream()
                .collect(Collectors.groupingBy(
                        Trip::getRoute,
                        Collectors.summingDouble(Trip::getFare)
                ));
        System.out.println("Revenue by route: " + revenueByRoute);

        Map<Boolean, List<Trip>> partitionPeak = allTrips.stream()
                .collect(Collectors.partitioningBy(Trip::isPeak));
        System.out.println("Peak trips count: " + partitionPeak.get(true).size()
                + ", Non-peak count: " + partitionPeak.get(false).size());

        DoubleSummaryStatistics stats = allTrips.stream()
                .collect(Collectors.summarizingDouble(Trip::getFare));
        System.out.println("Fare stats -> count: " + stats.getCount()
                + ", sum: " + stats.getSum()
                + ", avg: " + stats.getAverage()
                + ", min: " + stats.getMin()
                + ", max: " + stats.getMax());

        Map<String, Long> topRoutes = allTrips.stream()
                .collect(Collectors.groupingBy(Trip::getRoute, Collectors.counting()));
        topRoutes.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEach(e -> System.out.println("Top route: " + e.getKey() + " -> " + e.getValue() + " trips"));
    }

    static void prioritizeEmergencies(List<TransportService> services) {
        System.out.println("\n--- EMERGENCY PRIORITIZATION ---");
        services.stream()
                .filter(svc -> svc instanceof EmergencyService)
                .forEach(svc -> System.out.println("PRIORITIZE: " + svc.getServiceId() + " (" + svc.getType() + ")"));
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        BusService bus1 = new BusService("BUS-101", sampleTrips("BUS-101", "A->B", false));
        MetroService metro1 = new MetroService("METRO-RED", sampleTrips("METRO-RED", "B->C", false));

        FareCalculator taxiFare = (from, to, peak) -> {
            double base = 50.0;
            double dist = GeoUtils.calculateDistance(from, to);
            double perKm = 10.0;
            double peakMultiplier = peak ? 1.5 : 1.0;
            return base + perKm * dist * peakMultiplier;
        };
        TaxiService taxi1 = new TaxiService("TAXI-500", sampleTrips("TAXI-500", "A->C", false), taxiFare);
        AmbulanceService amb1 = new AmbulanceService("AMB-1", sampleTrips("AMB-1", "A->B", true));
        FerryService ferry1 = new FerryService("FERRY-7", sampleTrips("FERRY-7", "C->A", false));

        List<TransportService> allServices = Arrays.asList(bus1, metro1, taxi1, amb1, ferry1);

        System.out.println("--- BOOKING FLOW ---");
        Comparator<Trip> earliestDeparture = Comparator.comparing(Trip::getDeparture);
        Comparator<Trip> lowestFare = Comparator.comparingDouble(Trip::getFare);

        Optional<Trip> booked = bookTrip(allServices, A, B, earliestDeparture.thenComparing(lowestFare));
        booked.ifPresentOrElse(
                t -> System.out.println("Booked trip: " + t),
                () -> System.out.println("No available trip found for requested route/time.")
        );

        displayDashboard(allServices);

        List<Trip> flattenedTrips = allServices.stream()
                .flatMap(svc -> svc.getActiveTrips().stream())
                .collect(Collectors.toList());
        generateReports(flattenedTrips);

        System.out.println("\n--- NEW SERVICE ADDED: " + ferry1.getServiceId() + " (" + ferry1.getType() + ") ---");
        prioritizeEmergencies(allServices);

        System.out.println("\n--- QUICK LOG OF SERVICE IDS ---");
        allServices.stream().map(TransportService::getServiceId).forEach(System.out::println);

        Trip sampleTaxiTrip = taxi1.getActiveTrips().get(0);
        double computedFare = taxi1.computeFare(sampleTaxiTrip.getFrom(), sampleTaxiTrip.getTo(), sampleTaxiTrip.isPeak());
        System.out.printf("\nTaxi dynamic fare computed for %s: ₹%.2f%n", sampleTaxiTrip, computedFare);
    }
}

public class SpringSeason {

    public static boolean isSpring(int month, int day) {
        boolean isMarchSpring = (month == 3 && day >= 20);
        boolean isAprilOrMaySpring = (month == 4 || month == 5);
        boolean isJuneSpring = (month == 6 && day <= 20);

        return (isMarchSpring || isAprilOrMaySpring || isJuneSpring);
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        if (args.length != 2) {
            System.out.println("Usage: java SpringSeason <month> <day>");
            System.out.println("Example: java SpringSeason 3 25 (for March 25)");
            return;
        }

        int month;
        int day;

        try {
            month = Integer.parseInt(args[0]);
            day = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Month and Day must be valid integer numbers.");
            System.out.println("Usage: java SpringSeason <month> <day>");
            return;
        }

        if (month < 1 || month > 12 || day < 1 || day > 31) {
            System.out.println("Error: Invalid month or day. Please provide values like month (1-12) and day (1-31).");
            return;
        }

        if (isSpring(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
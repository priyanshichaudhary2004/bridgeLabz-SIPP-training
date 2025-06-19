import java.util.Random;

public class StudentGrades {

    static final int STUDENT_COUNT = 10;
    static final int SUBJECT_COUNT = 3;
    static final String[] SUBJECTS = {"Physics", "Chemistry", "Math"};

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        int[][] scores = generateRandomScores(STUDENT_COUNT, SUBJECT_COUNT);
        double[][] results = calculateTotalAndPercentage(scores);
        char[] grades = assignGrades(results);
        printScorecard(scores, results, grades);
    }

    public static int[][] generateRandomScores(int students, int subjects) {
        Random rand = new Random();
        int[][] scores = new int[students][subjects];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < subjects; j++) {
                scores[i][j] = rand.nextInt(41) + 60; 
            }
        }
        return scores;
    }

    public static double[][] calculateTotalAndPercentage(int[][] scores) {
        double[][] result = new double[scores.length][3]; 

        for (int i = 0; i < scores.length; i++) {
            int total = 0;
            for (int j = 0; j < scores[i].length; j++) {
                total += scores[i][j];
            }
            double average = (double) total / scores[i].length;
            double percentage = Math.round((total / 3.0) * 100.0 / 100.0 * 100) / 100.0; 
            result[i][0] = total;
            result[i][1] = Math.round(average * 100) / 100.0;
            result[i][2] = percentage;
        }
        return result;
    }

    public static char[] assignGrades(double[][] results) {
        char[] grades = new char[results.length];
        for (int i = 0; i < results.length; i++) {
            double percent = results[i][2];
            if (percent >= 80) grades[i] = 'A';
            else if (percent >= 70) grades[i] = 'B';
            else if (percent >= 60) grades[i] = 'C';
            else if (percent >= 50) grades[i] = 'D';
            else if (percent >= 40) grades[i] = 'E';
            else grades[i] = 'R';
        }
        return grades;
    }

    public static void printScorecard(int[][] scores, double[][] results, char[] grades) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-12s %-12s %-8s%n",
                "Student", "Physics", "Chemistry", "Math", "Total", "Average", "Percentage", "Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10s %-10d %-10d %-10d %-10.0f %-12.2f %-12.2f %-8c%n",
                    "Student" + (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    results[i][0], results[i][1], results[i][2], grades[i]);
        }
    }
}

import java.util.Scanner;

public class RockPaperScissors {
    public static String getComputerChoice() {
        int random = (int)(Math.random() * 3); 
        if (random == 0) return "rock";
        else if (random == 1) return "paper";
        else return "scissors";
    }

    public static String findWinner(String player, String computer) {
        if (player.equals(computer)) return "Draw";
        if ((player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"))) {
            return "Player";
        } else {
            return "Computer";
        }
    }

    public static String[][] calculateStats(int playerWins, int computerWins, int totalGames) {
        double playerPercent = ((double)playerWins / totalGames) * 100;
        double computerPercent = ((double)computerWins / totalGames) * 100;

        String[][] stats = new String[2][3];
        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.format("%.2f", playerPercent) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", computerPercent) + "%";

        return stats;
    }

    public static void displayResults(String[][] rounds, String[][] stats) {
        System.out.println("\nGame\tPlayer\tComputer\tWinner");
        for (int i = 0; i < rounds.length; i++) {
            System.out.println((i+1) + "\t" + rounds[i][0] + "\t" + rounds[i][1] + "\t\t" + rounds[i][2]);
        }

        System.out.println("\nStatistics : ");
        System.out.println("Player\tWins\tPercentage");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of games to play : ");
        int totalGames = sc.nextInt();

        String[][] gameResults = new String[totalGames][3];
        int playerWins = 0, computerWins = 0;

        for (int i = 0; i < totalGames; i++) {
            System.out.print("\nEnter your choice (rock/paper/scissors) : ");
            String playerChoice = sc.next().toLowerCase();
            String computerChoice = getComputerChoice();
            String winner = findWinner(playerChoice, computerChoice);

            gameResults[i][0] = playerChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;

            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;
        }

        String[][] stats = calculateStats(playerWins, computerWins, totalGames);
        displayResults(gameResults, stats);
    }
}

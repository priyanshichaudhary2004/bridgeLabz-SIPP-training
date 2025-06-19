public class ZaraBonus {
    public static double[][] generateEmployeeData(int size) {
        double[][] data = new double[size][2];
        for (int i = 0; i < size; i++) {
            data[i][0] = Math.random() * 90000 + 10000;
            data[i][1] = Math.random() * 10;
        }
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] result = new double[employeeData.length][2];
        for (int i = 0; i < employeeData.length; i++) {
            double salary = employeeData[i][0];
            double years = employeeData[i][1];
            double bonus = years > 5 ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;
            result[i][0] = newSalary;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void displayResults(double[][] originalData, double[][] updatedData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.printf("%-10s %-15s %-20s %-15s %-15s\n", "Emp ID", "Old Salary", "Years of Service", "Bonus", "New Salary");

        for (int i = 0; i < originalData.length; i++) {
            double oldSalary = originalData[i][0];
            double years = originalData[i][1];
            double bonus = updatedData[i][1];
            double newSalary = updatedData[i][0];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%-10d %-15.2f %-20.2f %-15.2f %-15.2f\n", (i + 1), oldSalary, years, bonus, newSalary);
        }

        System.out.println("\nTotal Old Salary : " + totalOldSalary);
        System.out.println("Total New Salary : " + totalNewSalary);
        System.out.println("Total Bonus Amount : " + totalBonus);
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        double[][] employeeData = generateEmployeeData(10);
        double[][] updatedData = calculateNewSalaryAndBonus(employeeData);
        displayResults(employeeData, updatedData);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManager manager = new GradeManager(5); //  We allow only 5 grades

        int attempts = 0;
        int maxAttempts = 7; //  User can try entering grades 7 times (even if some are invalid)

        //  welcome message
        System.out.println(" Welcome to the Grade Entry Portal!");
        System.out.println(" You can enter up to 5 grades (from 0 to 100).");
        System.out.println(" But be careful... you only have 7 total attempts!");
        System.out.println(" Let's see how well you can do! Ready? Let's go!\n");

        while (attempts < maxAttempts) {
            System.out.print("Enter grade Nbr" + (attempts + 1) + ": ");
            try {
                double grade = scanner.nextDouble();
                manager.addGrade(grade);
            } catch (Exception e) {
                System.out.println("⚠️ Invalid input! Please enter a valid number.");
                scanner.next(); // clear the wrong input
            }

            attempts++;

            if (attempts == maxAttempts - 1) {
                System.out.println("⚠️ Be careful! You have only 1 attempt remaining.");
            }

            if (attempts == maxAttempts) {
                System.out.println(" Your attempts have ended.");
            }
        }

        // Show summary
        System.out.println("\n Grade Entry Complete!");
        manager.printGrades();
        manager.sortGrades();
        manager.printGrades();

        System.out.println("\n Average grade: " + manager.calculateAverage());
        System.out.println(" Highest grade: " + manager.getHighestGrade());
        System.out.println(" Lowest grade: " + manager.getLowestGrade());

        // Optional: search
        System.out.print("\n Enter a grade to search: ");
        try {
            double searchGrade = scanner.nextDouble();
            int index = manager.searchGrade(searchGrade);
            if (index != -1) {
                System.out.println(" Grade " + searchGrade + " found at index: " + index);
            } else {
                System.out.println(" Grade " + searchGrade + " not found.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Invalid input for search.");
        }

        scanner.close();
    }
}

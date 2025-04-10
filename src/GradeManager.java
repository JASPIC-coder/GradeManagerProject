import java.util.Arrays;

public class GradeManager {
    private double[] grades;
    private int count;

    public GradeManager(int size) {
        grades = new double[size];
        count = 0;
    }

    public void addGrade(double grade) {
        try {
            if (grade < 0 || grade > 100) {
                throw new IllegalArgumentException("Grade must be between 0 and 100.");
            }
            if (count >= grades.length) {
                throw new ArrayIndexOutOfBoundsException("No more space to add new grades.");
            }
            grades[count++] = grade;
            System.out.println("Added grade: " + grade);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Attempted to add grade: " + grade);
        }
    }

    public void sortGrades() {
        Arrays.sort(grades, 0, count);
        System.out.println("Grades sorted successfully.");
    }

    public int searchGrade(double grade) {
        for (int i = 0; i < count; i++) {
            if (grades[i] == grade) {
                return i;
            }
        }
        return -1;
    }

    public double calculateAverage() {
        if (count == 0) return 0;
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += grades[i];
        }
        return total / count;
    }

    public double getHighestGrade() {
        if (count == 0) return 0;
        double max = grades[0];
        for (int i = 1; i < count; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    public double getLowestGrade() {
        if (count == 0) return 0;
        double min = grades[0];
        for (int i = 1; i < count; i++) {
            if (grades[i] < min) {
                min = grades[i];
            }
        }
        return min;
    }

    public void printGrades() {
        System.out.print("Current grades: ");
        for (int i = 0; i < count; i++) {
            System.out.print(grades[i] + " ");
        }
        System.out.println();
    }
}


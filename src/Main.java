import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.workerInput(new Scanner(System.in));
        employee.workerInfo();
    }
}

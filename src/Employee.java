import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee {
    String id;
    String fullname;
    String gender;
    String position;
    String hours;
    String rate;
    float tax;

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.workerInput(new Scanner(System.in));
        employee.workerInfo();
    }

    private float salary() {
        return Float.parseFloat(hours) * Float.parseFloat(rate);
    }

    private float TotalSalary() {
        return salary() - tax;
    }

    public void workerInput(Scanner input) {
        System.out.println("Enter id: ");
        id = input.nextLine();
        //only number allow
        Pattern validateId = Pattern.compile("[0-9]+");
        while (!validateId.matcher(String.valueOf(id)).matches() || Integer.parseInt(id) < 0) {
            System.out.println("Invalid input, please enter again");
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("Enter id: ");
            id = input.nextLine();
        }
        System.out.println("Enter fullname: ");
        fullname = input.nextLine();
        System.out.println("Enter gender:");
        gender = input.nextLine().toLowerCase();
        Pattern validateGender = Pattern.compile("^(m|male|f|female)$");
        //check if gender is not equal to Male or M or Female or F let user input again
        while (!validateGender.matcher(gender).matches()) {
            System.out.println("Input gender again: ");
            gender = input.nextLine().toLowerCase();
        }

        System.out.println("Enter position: ");
        position = input.nextLine();
        System.out.println("Enter hours: ");
        hours = input.nextLine();
        Pattern validateDecimal = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        while (!validateDecimal.matcher(String.valueOf(hours)).matches() || Float.parseFloat(hours) < 0) {
            System.out.println("Invalid input, please enter again");
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("Enter hours: ");
            hours = input.nextLine();
        }
        System.out.println("Enter rate: ");
        rate = input.nextLine();
        while (!validateDecimal.matcher(String.valueOf(rate)).matches() || Float.parseFloat(rate) < 0) {
            System.out.println("Invalid input, please enter again");
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("Enter rate: ");
            rate = input.nextLine();
        }
        if (salary() >= 1000) {
            tax = (float) ((gender.equals("male") || gender.equals("m")) ? salary() * 0.5 : salary() * 0.3);
        } else {
            tax = 0;
        }
    }

    public void workerInfo() {
        System.out.println("id: " + id);
        System.out.println("fullname: " + fullname);
        System.out.println("gender:" + gender);
        System.out.println("position: " + position);
        System.out.println("hours: " + hours);
        System.out.println("rate: " + rate);
        System.out.println("Tax:" + tax + " %");
        System.out.println("Salary:" + salary());
        System.out.println("TotalSalary:" + TotalSalary());
    }

}

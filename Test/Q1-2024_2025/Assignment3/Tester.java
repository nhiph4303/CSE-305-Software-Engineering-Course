public class Tester extends Employee {

    public Tester(String firstName, String lastName,
                  String email, String department, double salary) {
        super(firstName, lastName, email, department, salary);
    }

    @Override
    public void addEmployee() {
        System.out.println("Adding Tester: " + firstName + " " + lastName
                           + " to department: " + department);
        System.out.println("Sending welcome email to " + email);
        System.out.println("Salary set to: " + salary);
    }

    @Override
    public void promoteEmployee(double newSalary) {
        System.out.println("Promoting " + firstName + " " + lastName + " to Tester");
        System.out.println("New salary: " + newSalary);
        this.salary = newSalary;
    }
}

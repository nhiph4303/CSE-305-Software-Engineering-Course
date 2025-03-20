public abstract class Employee implements EmployeeAction {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String department;
    protected double salary;

    public Employee(String firstName, String lastName,
                    String email, String department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    // Các getter, setter chung nếu cần

    // Mặc định (có thể override ở lớp con)
    @Override
    public void removeEmployee() {
        System.out.println("Removing " + this.getClass().getSimpleName()
                           + ": " + firstName + " " + lastName);
    }
}

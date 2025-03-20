public class EmployeeFactory {
    public static Employee createEmployee(String role,
                                          String firstName, String lastName,
                                          String email, String department,
                                          double salary) {
        switch (role.toLowerCase()) {
            case "manager":
                return new Manager(firstName, lastName, email, department, salary);
            case "developer":
                return new Developer(firstName, lastName, email, department, salary);
            case "tester":
                return new Tester(firstName, lastName, email, department, salary);
            default:
                throw new IllegalArgumentException("Role không hợp lệ: " + role);
        }
    }
}

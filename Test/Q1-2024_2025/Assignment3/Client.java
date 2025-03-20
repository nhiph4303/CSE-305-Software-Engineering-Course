public class Client {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        manager.addEmployee("John", "Doe", "john@example.com",
                            "IT", 5000, "Manager");

        manager.addEmployee("Jane", "Smith", "jane@example.com",
                            "IT", 3000, "Developer");

        manager.addEmployee("Tom", "Brown", "tom@example.com",
                            "QA", 2800, "Tester");

        // Thăng chức Jane từ Developer -> Manager
        manager.promoteEmployee("Jane", "Smith", "jane@example.com",
                                "IT", 3000,
                                "Manager", 4500);

        // Xoá Tom (Tester)
        manager.removeEmployee("Tom", "Brown", "tom@example.com",
                               "QA", 2800, "Tester");
    }
}

public class EmployeeManager {

    // Thêm nhân viên
    public void addEmployee(String firstName, String lastName,
                            String email, String department,
                            double salary, String role) {

        Employee emp = EmployeeFactory.createEmployee(role, 
                                    firstName, lastName,
                                    email, department, salary);
        emp.addEmployee(); // Gọi đúng logic theo từng loại
    }

    // Thăng chức
    public void promoteEmployee(String firstName, String lastName,
                                String email, String department,
                                double currentSalary,
                                String newRole, double newSalary) {

        // Giả sử ta tạo "nhân viên cũ" (role cũ) => promote => newRole
        // Hoặc ta có thể quản lý Employee trong DS, v.v.
        Employee oldEmp = EmployeeFactory.createEmployee(newRole,
                                    firstName, lastName,
                                    email, department, currentSalary);

        oldEmp.promoteEmployee(newSalary);
    }

    // Xoá nhân viên
    public void removeEmployee(String firstName, String lastName,
                               String email, String department,
                               double salary, String role) {

        Employee emp = EmployeeFactory.createEmployee(role, 
                                    firstName, lastName,
                                    email, department, salary);
        emp.removeEmployee();
    }
}

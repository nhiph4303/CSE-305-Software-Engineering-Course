public class ReportGenerator {
    public void generateReport(String reportType) {
        try {
            // Gọi factory để lấy đối tượng report phù hợp
            IReport report = ReportFactory.createReport(reportType);
            // Gọi hàm generate() (polymorphism)
            report.generate();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

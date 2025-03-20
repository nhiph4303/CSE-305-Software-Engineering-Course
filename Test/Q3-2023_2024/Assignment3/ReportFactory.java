public class ReportFactory {
    public static IReport createReport(String reportType) {
        switch (reportType.toLowerCase()) {
            case "sales":
                return new SalesReport();
            case "inventory":
                return new InventoryReport();
            default:
                throw new IllegalArgumentException("Invalid report type: " + reportType);
        }
    }
}

public class Client {
    public static void main(String[] args) {
        ReportGenerator generator = new ReportGenerator();

        generator.generateReport("Sales");
        generator.generateReport("Inventory");
        generator.generateReport("UnknownType"); // sẽ báo lỗi
    }
}

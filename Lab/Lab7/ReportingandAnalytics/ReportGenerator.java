import java.util.*;

public class ReportGenerator {
    public static void main(String[] args) {
        OwnerInfo owner1 = new OwnerInfo("John Doe", "City Center");
        OwnerInfo owner2 = new OwnerInfo("Jane Smith", "Suburb");
        OwnerInfo owner3 = new OwnerInfo("Bob Johnson", "Downtown");

        List<Property> properties = List.of(
                new Property("Apartment A", 1500.0, owner1),
                new Property("House B", 2000.0, owner2),
                new Property("Condo C", 1800.0, owner3));

        FinancialReport financialReport = new FinancialReport("Monthly Rent Summary", properties, 2000.0);
        financialReport.generateReport();
    }
}
import java.util.List;
import java.util.ArrayList;

class Property {
    private String name;
    private double rentAmount;
    private String ownerName; 
    private String location;

    public Property(String name, double rentAmount, String ownerName, String location) { // Constructor with a data clump
        this.name = name;
        this.rentAmount = rentAmount;
        this.ownerName = ownerName;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getLocation() {
        return location;
    }

    public void printPropertyDetails() {
        System.out.println("Property: " + name);
        System.out.println("Rent Amount: $" + rentAmount);
        System.out.println("Owner: " + ownerName);
        System.out.println("Location: " + location);
    }
}

class FinancialReport {
    private String reportTitle;
    private List<Property> properties;
    private double totalRent;

    public FinancialReport(String reportTitle, List<Property> properties) {
        this.reportTitle = reportTitle;
        this.properties = properties;
    }

    public void generateReport() {
        totalRent = 0; 
        System.out.println("Financial Report: " + reportTitle);
        System.out.println("----------------------------");
        for (Property property : properties) {
            property.printPropertyDetails();
            totalRent += property.getRentAmount();

            
            if (property.getRentAmount() > 2000) {
                System.out.println("This is a premium property.");
            } else {
                System.out.println("This is a standard property.");
            }
            double yearlyRent = property.getRentAmount() * 12; 
            System.out.println("Yearly Rent: $" + yearlyRent);
            System.out.println("--------------------");
        }

        System.out.println("Total Rent Amount: $" + totalRent);
    }
}

public class ReportGenerator {
    public static void main(String[] args) {
        Property property1 = new Property("Apartment A", 1500.0, "John Doe", "City Center");
        Property property2 = new Property("House B", 2000.0, "Jane Smith", "Suburb");
        Property property3 = new Property("Condo C", 1800.0, "Bob Johnson", "Downtown");

        FinancialReport financialReport = new FinancialReport("Monthly Rent Summary", List.of(property1, property2, property3));
        financialReport.generateReport();

    }
}

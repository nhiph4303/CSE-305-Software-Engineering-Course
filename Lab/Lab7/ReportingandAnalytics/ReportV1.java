import java.util.ArrayList;
import java.util.List;

class OwnerInfo {
    private final String ownerName;
    private final String location;

    public OwnerInfo(String ownerName, String location) {
        this.ownerName = ownerName;
        this.location = location;
    }

    public String getOwnerName() { return ownerName; }
    public String getLocation() { return location; }
}

class Property {
    private final String name;
    private final double rentAmount;
    private final OwnerInfo ownerInfo;

    public Property(String name, double rentAmount, OwnerInfo ownerInfo) {
        this.name = name;
        this.rentAmount = rentAmount;
        this.ownerInfo = ownerInfo;
    }

    public String getName() { return name; }
    public double getRentAmount() { return rentAmount; }
    public OwnerInfo getOwnerInfo() { return ownerInfo; }
}

class FinancialCalculator {
    public static double calculateYearlyRent(Property property) {
        return property.getRentAmount() * 12;
    }
}

class FinancialReport {
    private final String reportTitle;
    private final List<Property> properties;
    private final double premiumThreshold;

    public FinancialReport(String reportTitle, List<Property> properties, double premiumThreshold) {
        this.reportTitle = reportTitle;
        this.properties = new ArrayList<>(properties);
        this.premiumThreshold = premiumThreshold;
    }

    public void printPropertyDetails(Property property) {
        System.out.printf("Property: %s%n", property.getName());
        System.out.printf("Rent Amount: $%.2f%n", property.getRentAmount());
        System.out.printf("Owner: %s%n", property.getOwnerInfo().getOwnerName());
        System.out.printf("Location: %s%n", property.getOwnerInfo().getLocation());
    }

    public void generateReport() {
        double totalRent = 0; 
        System.out.printf("=== Financial Report: %s ===%n", reportTitle);
        System.out.println("----------------------------");
        
        for (Property property : properties) {
            printPropertyDetails(property);
            totalRent += property.getRentAmount();

            if (property.getRentAmount() > premiumThreshold) {
                System.out.println("Category: Premium Property");
            } else {
                System.out.println("Category: Standard Property");
            }

            double yearlyRent = FinancialCalculator.calculateYearlyRent(property);
            System.out.printf("Yearly Rent: $%.2f%n", yearlyRent);
            System.out.println("--------------------");
        }
        
        System.out.printf("Total Rent Amount: $%.2f%n", totalRent);
    }
}

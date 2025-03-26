package Q3;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("John Doe", "john.doe@example.com", "123 Main St", 150.0);

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder(order);

        OrderConfirmationService orderConfirmationService = new OrderConfirmationService();
        orderConfirmationService.sendOrderConfirmation(order);

        InvoiceService invoiceService = new InvoiceService();
        invoiceService.generateInvoice(order);
    }
}

class Order {
    private String customerName;
    private String customerEmail;
    private String shippingAddress;
    private double orderTotal;

    public Order(String customerName, String customerEmail, String shippingAddress, double orderTotal) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.shippingAddress = shippingAddress;
        this.orderTotal = orderTotal;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public double getOrderTotal() {
        return orderTotal;
    }
}

class OrderProcessor {
    public void processOrder(Order order) {
        System.out.println("Order processed successfully for " + order.getCustomerName());
    }
}

class OrderConfirmationService {
    public void sendOrderConfirmation(Order order) {
        System.out.println("Order confirmation email sent to " + order.getCustomerEmail());
    }
}

class InvoiceService {
    public void generateInvoice(Order order) {
        System.out.println("Invoice generated for " + order.getCustomerName() +
                           " with total amount $" + order.getOrderTotal());
    }
}
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessagingService messagingService = new MessagingService();

        messagingService.sendMessage("Hello, tenant!", "Property Manager", "Tenant A");
        messagingService.sendMessage("Important notice: Rent due next week.", "Property Owner", "Tenant A");
        messagingService.sendMessage("Maintenance request received.", "Tenant A", "Property Manager");

        List<Message> tenantAMessages = messagingService.getMessagesForRecipient("Tenant A");
        if (tenantAMessages != null) {
            for (Message message : tenantAMessages) {
                System.out.println(message);
            }
        }

        messagingService.sendMessage("", "Sender", "Recipient");

        messagingService.printAllMessages();
    }
}

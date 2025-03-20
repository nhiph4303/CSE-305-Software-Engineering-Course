import java.util.*;

class Message {
    private final String content;
    private final String sender;
    private final String recipient;

    public Message(String content, String sender, String recipient) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void display() {
        System.out.println("From: " + sender);
        System.out.println("To: " + recipient);
        System.out.println("Message: " + content);
    }

    @Override
    public String toString() {
        return "From: " + sender + " -> To: " + recipient + "\nMessage: " + content;
    }
}

class MessagingService {
    private final Map<String, List<Message>> inbox;
    private static final String ERROR_EMPTY_MESSAGE = "Invalid message! Content cannot be empty.";
    private static final String ERROR_EMPTY_SENDER = "Invalid message! Sender cannot be empty.";
    private static final String ERROR_EMPTY_RECIPIENT = "Invalid message! Recipient cannot be empty.";
    private static final String INFO_INBOX_EMPTY = "Inbox is empty.";
    private static final String INFO_NO_MESSAGES = "No messages found for: ";

    public MessagingService() {
        this.inbox = new HashMap<>();
    }

    private boolean isValidMessage(String content, String sender, String recipient) {
        if (content == null || content.trim().isEmpty()) {
            System.out.println(ERROR_EMPTY_MESSAGE);
            return false;
        }
        if (sender == null || sender.trim().isEmpty()) {
            System.out.println(ERROR_EMPTY_SENDER);
            return false;
        }
        if (recipient == null || recipient.trim().isEmpty()) {
            System.out.println(ERROR_EMPTY_RECIPIENT);
            return false;
        }
        return true;
    }

    public void sendMessage(String content, String sender, String recipient) {
        if (!isValidMessage(content, sender, recipient)) {
            return;
        }
        Message message = new Message(content, sender, recipient);
        inbox.computeIfAbsent(recipient, k -> new ArrayList<>()).add(message);
    }

    public List<Message> getMessagesForRecipient(String recipient) {
        List<Message> messages = inbox.getOrDefault(recipient, Collections.emptyList());
        if (messages.isEmpty()) {
            System.out.println(INFO_NO_MESSAGES + recipient);
        }
        return messages;
    }

    public void printAllMessages() {
        if (inbox.isEmpty()) {
            System.out.println(INFO_INBOX_EMPTY);
            return;
        }
        for (String recipient : inbox.keySet()) {
            System.out.println("\nMessages for: " + recipient);
            System.out.println("------------------------");
            for (Message message : inbox.get(recipient)) {
                message.display();
            }
            System.out.println("------------------------");
        }
    }
}


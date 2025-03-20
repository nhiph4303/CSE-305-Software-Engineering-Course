public class Main {
    public static void main(String[] args) {
        System.out.println("Processing Low Priority Request...");
        RequestCreator lowPriority = new LowPriorityConcreteCreator();
        lowPriority.processRequest();

        System.out.println("\nProcessing Mid Priority Request...");
        RequestCreator midPriority = new MidPriorityConcreteCreator();
        midPriority.processRequest();

        System.out.println("\nProcessing High Priority Request...");
        RequestCreator highPriority = new HighPriorityConcreteCreator();
        highPriority.processRequest();
    }
}

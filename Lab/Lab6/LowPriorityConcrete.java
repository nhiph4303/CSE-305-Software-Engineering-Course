import java.time.LocalDate;

public class LowPriorityConcrete implements RequestProduct {
    private String priority;
    private String status;
    private String expireDay;

    @Override
    public void setPriority() {
        this.priority = "Ignore";
    }

    @Override
    public void setStatus() {
        this.status = "Done";
    }

    @Override
    public void setExpire() {
        this.expireDay = LocalDate.now().toString();
    }

    @Override
    public void processRequest() {
        System.out.println("Request denied");
    }
}

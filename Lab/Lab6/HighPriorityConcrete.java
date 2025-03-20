import java.time.LocalDate;

public class HighPriorityConcrete implements RequestProduct {
    private String priority;
    private String status;
    private String expireDay;

    @Override
    public void setPriority() {
        this.priority = "Emergency";
    }

    @Override
    public void setStatus() {
        this.status = "Accepted";
    }

    @Override
    public void setExpire() {
        this.expireDay = LocalDate.now().toString();
    }

    @Override
    public void processRequest() {
        System.out.println("Emergency request, our Administrator will contact you immediately!");
    }
}

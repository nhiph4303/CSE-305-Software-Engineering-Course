public class AdminBuilder implements CardBuilder {
    private User user;

    public AdminBuilder() {
        user = new User();
    }

    @Override
    public void setId(String id) {
        user.setId(id);
    }

    @Override
    public void setType() {
        user.setType("Administrator");
    }

    @Override
    public void setLibrary() {
        // Admin có quyền không giới hạn
        user.setLibraryService("Unlimited");
    }

    @Override
    public void setPrinter() {
        // Admin in ấn miễn phí
        user.setPrinterService("Free");
    }

    @Override
    public void setClassService() {
        // Admin vào tất cả phòng học
        user.setClassService("Unlimited");
    }

    @Override
    public User createCard() {
        return user;
    }
}

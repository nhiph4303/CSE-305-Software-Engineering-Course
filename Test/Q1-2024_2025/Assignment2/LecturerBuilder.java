public class LecturerBuilder implements CardBuilder {
    private User user;

    public LecturerBuilder() {
        user = new User();
    }

    @Override
    public void setId(String id) {
        user.setId(id);
    }

    @Override
    public void setType() {
        user.setType("Lecturer");
    }

    @Override
    public void setLibrary() {
        // Giảng viên được quyền Unlimited
        user.setLibraryService("Unlimited");
    }

    @Override
    public void setPrinter() {
        // Giảng viên in miễn phí (Free)
        user.setPrinterService("Free");
    }

    @Override
    public void setClassService() {
        // Giảng viên vào mọi phòng học (Unlimited)
        user.setClassService("Unlimited");
    }

    @Override
    public User createCard() {
        return user;
    }
}

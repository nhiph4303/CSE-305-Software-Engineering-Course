public class StudentBuilder implements CardBuilder {
    private User user;

    public StudentBuilder() {
        user = new User();
    }

    @Override
    public void setId(String id) {
        user.setId(id);
    }

    @Override
    public void setType() {
        user.setType("Student");
    }

    @Override
    public void setLibrary() {
        // Ví dụ: Sinh viên bị giới hạn (Limited)
        user.setLibraryService("Limited");
    }

    @Override
    public void setPrinter() {
        // Sinh viên thường trả phí in ấn (Standard)
        user.setPrinterService("Standard");
    }

    @Override
    public void setClassService() {
        // Sinh viên có thể bị giới hạn truy cập phòng học
        user.setClassService("Limited");
    }

    @Override
    public User createCard() {
        return user;
    }
}

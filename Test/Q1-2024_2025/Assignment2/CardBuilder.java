public interface CardBuilder {
    void setId(String id);
    void setType();            // Đặt type: Student, Lecturer, Administrator
    void setLibrary();         // Quyền thư viện
    void setPrinter();         // Quyền in ấn
    void setClassService();    // Quyền vào phòng học
    User createCard();         // Trả về đối tượng User sau khi thiết lập
}

public class CardDirector {

    public User constructStudentCard(String id) {
        CardBuilder builder = new StudentBuilder();
        builder.setId(id);
        builder.setType();
        builder.setLibrary();
        builder.setPrinter();
        builder.setClassService();
        return builder.createCard();
    }

    public User constructLecturerCard(String id) {
        CardBuilder builder = new LecturerBuilder();
        builder.setId(id);
        builder.setType();
        builder.setLibrary();
        builder.setPrinter();
        builder.setClassService();
        return builder.createCard();
    }

    public User constructAdminCard(String id) {
        CardBuilder builder = new AdminBuilder();
        builder.setId(id);
        builder.setType();
        builder.setLibrary();
        builder.setPrinter();
        builder.setClassService();
        return builder.createCard();
    }
}

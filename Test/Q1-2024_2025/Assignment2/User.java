public class User {
    private String id;
    private String type;           // Student, Lecturer, Administrator
    private String libraryService; // Unlimited, Limited, Prohibited
    private String printerService; // Free, Standard
    private String classService;   // Unlimited, Limited

    //----- GETTERS & SETTERS -----

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLibraryService(String libraryService) {
        this.libraryService = libraryService;
    }

    public void setPrinterService(String printerService) {
        this.printerService = printerService;
    }

    public void setClassService(String classService) {
        this.classService = classService;
    }

    //----- HIỂN THỊ THÔNG TIN (tuỳ chọn) -----

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Type: " + type);
        System.out.println("Library Service: " + libraryService);
        System.out.println("Printer Service: " + printerService);
        System.out.println("Class Service: " + classService);
        System.out.println("--------------------");
    }

    @Override
    public String toString() {
        return "User{" +
               "id='" + id + '\'' +
               ", type='" + type + '\'' +
               ", libraryService='" + libraryService + '\'' +
               ", printerService='" + printerService + '\'' +
               ", classService='" + classService + '\'' +
               '}';
    }
}

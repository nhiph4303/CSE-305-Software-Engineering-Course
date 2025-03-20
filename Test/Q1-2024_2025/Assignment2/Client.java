// public class Client {
//     public static void main(String[] args) {
//         // Tạo đối tượng Director
//         CardDirector director = new CardDirector();

//         // 1) Tạo thẻ ID cho Student
//         User studentCard = director.constructStudentCard("S12345");
//         studentCard.printInfo();

//         // 2) Tạo thẻ ID cho Lecturer
//         User lecturerCard = director.constructLecturerCard("L98765");
//         lecturerCard.printInfo();

//         // 3) Tạo thẻ ID cho Admin
//         User adminCard = director.constructAdminCard("A00001");
//         adminCard.printInfo();
//     }
// }


import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardDirector director = new CardDirector();

        System.out.println("Nhập loại thẻ cần tạo (Student, Lecturer, Administrator):");
        String cardType = scanner.nextLine().trim();

        System.out.println("Nhập ID:");
        String id = scanner.nextLine().trim();

        User userCard = null;
        // Sử dụng switch-case hoặc if-else để chọn loại thẻ dựa trên input
        switch(cardType.toLowerCase()) {
            case "student":
                userCard = director.constructStudentCard(id);
                break;
            case "lecturer":
                userCard = director.constructLecturerCard(id);
                break;
            case "administrator":
                userCard = director.constructAdminCard(id);
                break;
            default:
                System.out.println("Loại thẻ không hợp lệ!");
                System.exit(0);
        }
        
        System.out.println("Thẻ được tạo:");
        userCard.printInfo();
        
        scanner.close();
    }
}

package Q2;
import java.util.*;
// public class Client {
//     public static void main(String[] args) {
//         ConcreteBicycleBuilder b = new ConcreteBicycleBuilder();
//         Bicycle d = b.addFrameSize("Large")
//                 .addWheelType("Mountain Wheels")
//                 .addGearSystem("Shimano 21-Speed")
//                 .addAccessory("Water Bottle Holder")
//                 .addAccessory("LED Lights")
//                 .build();

//         d.showSpecifications();
//     }
// }

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập thông tin xe đạp từ người dùng
        System.out.print("Enter Frame Size (e.g., Small, Medium, Large): ");
        String frameSize = sc.nextLine();

        System.out.print("Enter Wheel Type (e.g., Mountain Wheels, Road Wheels): ");
        String wheelType = sc.nextLine();

        System.out.print("Enter Gear System (e.g., Shimano 21-Speed, Shimano 18-Speed): ");
        String gearSystem = sc.nextLine();

        ConcreteBicycleBuilder b = new ConcreteBicycleBuilder();
        b.addFrameSize(frameSize)
         .addWheelType(wheelType)
         .addGearSystem(gearSystem);

        // Nhập phụ kiện
        System.out.print("How many accessories would you like to add? ");
        int numAccessories = sc.nextInt();
        sc.nextLine(); // consume the newline character left by nextInt()

        for (int i = 0; i < numAccessories; i++) {
            System.out.print("Enter accessory " + (i + 1) + ": ");
            String accessory = sc.nextLine();
            b.addAccessory(accessory);
        }

        // Xây dựng xe đạp
        Bicycle d = b.build();

        // Hiển thị thông tin xe đạp
        d.showSpecifications();
    }
}
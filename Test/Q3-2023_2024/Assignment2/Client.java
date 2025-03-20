// public class Client {
//     public static void main(String[] args) {
//         // Tạo Creator cho Normal
//         Creator normalCreator = new ConcreteCreatorNormal();
//         // Lấy về Calculator normal
//         Calculator normalCalc = normalCreator.createCalculator();

//         // Đặt toán hạng và thử các phép
//         normalCalc.setOperand(10, 5);
//         normalCalc.addition();
//         System.out.println("Normal (10 + 5) = " + normalCalc.getResult());

//         normalCalc.multiplication();
//         System.out.println("Normal (10 * 5) = " + normalCalc.getResult()); // Operation not support

//         // Tạo Creator cho Professional
//         Creator proCreator = new ConcreteCreatorProfessional();
//         Calculator proCalc = proCreator.createCalculator();

//         proCalc.setOperand(10, 5);
//         proCalc.multiplication();
//         System.out.println("Professional (10 * 5) = " + proCalc.getResult()); // 50

//         proCalc.setOperand(10, 0);
//         proCalc.division();
//         System.out.println("Professional (10 / 0) = " + proCalc.getResult()); // Error: Division by zero!
//     }
// }

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1) Hỏi người dùng muốn dùng chế độ nào
        System.out.print("Enter calculator mode (normal/professional): ");
        String mode = scanner.nextLine().trim().toLowerCase();

        Creator creator;
        if (mode.equals("normal")) {
            creator = new ConcreteCreatorNormal();
        } else if (mode.equals("professional")) {
            creator = new ConcreteCreatorProfessional();
        } else {
            System.out.println("Invalid mode!");
            scanner.close();
            return;
        }

        // 2) Tạo đối tượng Calculator thông qua Creator
        Calculator calc = creator.createCalculator();

        // 3) Nhập 2 toán hạng
        System.out.print("Enter operand1: ");
        int op1 = scanner.nextInt();
        System.out.print("Enter operand2: ");
        int op2 = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ ký tự xuống dòng còn sót

        // Gán toán hạng vào Calculator
        calc.setOperand(op1, op2);

        // 4) Hỏi người dùng muốn thực hiện phép tính gì
        System.out.print("Enter operation (add, sub, mul, div): ");
        String operation = scanner.nextLine().trim().toLowerCase();

        // 5) Gọi phương thức tương ứng
        switch (operation) {
            case "add":
                calc.addition();
                break;
            case "sub":
                calc.subtraction();
                break;
            case "mul":
                calc.multiplication();
                break;
            case "div":
                calc.division();
                break;
            default:
                System.out.println("Invalid operation!");
                scanner.close();
                return;
        }

        // 6) In kết quả
        System.out.println("Result: " + calc.getResult());

        scanner.close();
    }
}

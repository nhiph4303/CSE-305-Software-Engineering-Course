public interface Calculator {
    // Đặt toán hạng
    void setOperand(int op1, int op2);

    // Các phép tính
    void addition();
    void subtraction();
    void multiplication();
    void division();

    // Lấy kết quả
    String getResult();
}

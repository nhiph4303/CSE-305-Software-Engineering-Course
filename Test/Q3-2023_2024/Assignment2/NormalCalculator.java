public class NormalCalculator implements Calculator {
    private int operand1;
    private int operand2;
    private String result;  // kết quả cuối dưới dạng chuỗi

    @Override
    public void setOperand(int op1, int op2) {
        this.operand1 = op1;
        this.operand2 = op2;
    }

    @Override
    public void addition() {
        int sum = operand1 + operand2;
        result = String.valueOf(sum);
    }

    @Override
    public void subtraction() {
        int diff = operand1 - operand2;
        result = String.valueOf(diff);
    }

    @Override
    public void multiplication() {
        // NormalCalculator không hỗ trợ nhân
        result = "Operation not support";
    }

    @Override
    public void division() {
        // NormalCalculator không hỗ trợ chia
        result = "Operation not support";
    }

    @Override
    public String getResult() {
        return result;
    }
}

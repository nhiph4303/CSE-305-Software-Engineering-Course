public class ProfessionalCalculator implements Calculator {
    private int operand1;
    private int operand2;
    private String result;

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
        int product = operand1 * operand2;
        result = String.valueOf(product);
    }

    @Override
    public void division() {
        if (operand2 == 0) {
            result = "Error: Division by zero!";
        } else {
            double div = (double) operand1 / operand2;
            result = String.valueOf(div);
        }
    }

    @Override
    public String getResult() {
        return result;
    }
}

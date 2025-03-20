public class ConcreteCreatorNormal extends Creator {
    @Override
    public Calculator createCalculator() {
        return new NormalCalculator();
    }
}
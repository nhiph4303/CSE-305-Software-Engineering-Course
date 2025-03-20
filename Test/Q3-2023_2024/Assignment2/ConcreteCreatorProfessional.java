public class ConcreteCreatorProfessional extends Creator {
    @Override
    public Calculator createCalculator() {
        return new ProfessionalCalculator();
    }
}
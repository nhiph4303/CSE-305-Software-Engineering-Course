public class HighPriorityConcreteCreator extends RequestCreator {
    @Override
    public RequestProduct createRequest() {
        return new HighPriorityConcrete();
    }
}

public class LowPriorityConcreteCreator extends RequestCreator {
    @Override
    public RequestProduct createRequest() {
        return new LowPriorityConcrete();
    }
}

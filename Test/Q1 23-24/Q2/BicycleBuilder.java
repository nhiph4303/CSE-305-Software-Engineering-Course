package Q2;

public interface BicycleBuilder {
    BicycleBuilder addFrameSize(String frameSize);
    BicycleBuilder addWheelType(String wheelType);
    BicycleBuilder addGearSystem(String gearSystem);
    BicycleBuilder addAccessory(String accessory);
    Bicycle build();
}

package Q2;

import java.util.*;

public class ConcreteBicycleBuilder implements BicycleBuilder {
    private String frameSize;
    private String wheelType;
    private String gearSystem;
    private List<String> accessories = new ArrayList<>();
    private Bicycle result;  

    @Override
    public BicycleBuilder addFrameSize(String frameSize) {
        this.frameSize = frameSize;
        return this;
    }

    @Override
    public BicycleBuilder addWheelType(String wheelType) {
        this.wheelType = wheelType;
        return this;
    }

    @Override
    public BicycleBuilder addGearSystem(String gearSystem) {
        this.gearSystem = gearSystem;
        return this;
    }

    @Override
    public BicycleBuilder addAccessory(String accessory) {
        this.accessories.add(accessory);
        return this;
    }

    @Override
    public Bicycle build() {
        result = new Bicycle(frameSize, wheelType, gearSystem, accessories);
        return result;
    }
}

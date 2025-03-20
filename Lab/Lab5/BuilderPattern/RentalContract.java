class RentalContract {
    private String contractID;
    private String propertyID;
    private String tenantID;
    private double rentAmount;
    private String contractType; 

    public RentalContract(String contractID, String propertyID, String tenantID, double rentAmount, String contractType) {
        this.contractID = contractID;
        this.propertyID = propertyID;
        this.tenantID = tenantID;
        this.rentAmount = rentAmount;
        this.contractType = contractType;
    }

    public String getContractType() {
        return contractType;
    }

    public String getContractID() {
        return contractID;
    }

    @Override
    public String toString() {
        return "RentalContract{" +
                "contractType='" + contractType + '\'' +
                ", contractID='" + contractID + '\'' +
                ", propertyID='" + propertyID + '\'' +
                ", tenantID='" + tenantID + '\'' +
                ", rentAmount=" + rentAmount +
                '}';
    }
}

class Permanent implements Contract {
    private String contractID;
    private String propertyID;
    private String tenantID;
    private double rentAmount;

    @Override
    public void BuildContractID(String contractID) {
        this.contractID = contractID;
    }

    @Override
    public void BuildPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    @Override
    public void BuildTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    @Override
    public void BuildRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    @Override
    public RentalContract SignContract(String contractType) { // ✅ Truyền contractType vào RentalContract
        return new RentalContract(contractID, propertyID, tenantID, rentAmount, contractType);
    }
}

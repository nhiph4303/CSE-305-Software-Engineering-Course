interface Contract {
    void BuildContractID(String contractID);
    void BuildPropertyID(String propertyID);
    void BuildTenantID(String tenantID);
    void BuildRentAmount(double rentAmount);
    RentalContract SignContract(String contractType);
}

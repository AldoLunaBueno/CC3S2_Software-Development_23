package Contract;

public class TaxCalculator1 {
    // TaxCalculator con pre- y post-conditions implementado via asserts
    public double calculateTaxes(double value) {
        assert value >= 0; // Pre-condition
        double taxValue = 0;
        assert taxValue >= 0; // Post-condition
        return taxValue;
    }
}

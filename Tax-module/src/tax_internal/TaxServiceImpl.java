package tax_internal;

import tax_api.TaxService;

public class TaxServiceImpl implements TaxService {
    public double calculateTax(double income) {
        return income * 0.15;
    }
}

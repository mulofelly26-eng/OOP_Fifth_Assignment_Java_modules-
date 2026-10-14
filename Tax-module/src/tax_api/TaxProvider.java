package tax_api;

import tax_internal.TaxServiceImpl;

public class TaxProvider {
    public static TaxService get() {
        return new TaxServiceImpl();
    }
}

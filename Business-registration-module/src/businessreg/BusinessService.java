package businessreg;

import api.NationalIdProvider;

public class BusinessService {
    public String register(String company, String ownerNin) {
        if (!NationalIdProvider.get().verify(ownerNin))
            return "Business DENIED: owner not verified";
        return "Business registered";
    }
}

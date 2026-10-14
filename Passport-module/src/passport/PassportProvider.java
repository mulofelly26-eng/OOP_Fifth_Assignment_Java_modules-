package passport;

import api.NationalIDService;
import api.NationalIdProvider;

public class PassportProvider {
    public String apply(String nin) {
        NationalIDService ids = NationalIdProvider.get();
        if (!ids.verify(nin)) return "Passport DENIED: Invalid NationalID provided";
        return "Passport application accepted " + ids.getFullName(nin);
    }

}

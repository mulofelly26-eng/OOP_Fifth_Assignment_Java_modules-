package api;
import internal.NationalIDServiceImpl;

public class NationalIdProvider {
    private static final NationalIDService INSTANCE = new NationalIDServiceImpl();

    public static NationalIDService get() {
        return INSTANCE;
    }
}

package internal;

import api.NationalIDService;
import java.util.HashMap;
import java.util.Map;


public class NationalIDServiceImpl implements NationalIDService {
    private final Map<String, String> database = new HashMap<>(Map.of(
            "CM18749", "Nahato Sarah",
            "CM17623", "Okello David"
    ));

    @Override
    public void SetNewcitycen(String nin, String name) {
        database.put(nin, name);
    }

    @Override
    public String GetCitycenNumber() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : database.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" => ");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean verify(String nin) {
        return database.containsKey(nin);
    }

    @Override
    public String getFullName(String nin) {
        return database.get(nin);
    }

}

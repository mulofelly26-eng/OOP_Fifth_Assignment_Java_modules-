package api;

public interface NationalIDService {
    boolean verify(String nin);
    String getFullName(String nin);
    void SetNewcitycen(String nin, String name);
    String GetCitycenNumber();
}

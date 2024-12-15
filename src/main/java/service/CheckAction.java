package service;

public interface CheckAction {

    String formatPhoneNumber(String number);

    void regexName(String name);

    void regexSurname(String surname);

    void regexAddress(String address);

    void regexPhoneNumber(String number);

    void checkNumberForSave(String number);


}

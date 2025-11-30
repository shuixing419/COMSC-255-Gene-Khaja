package as15;

public static void validateName(String name)
        throws NotSpecifiedException,
        NotAlphabeticException {
    
    if (name.equals("")) {
        throw new NotSpecifiedException();
    } else if (!name.matches("[a-zA-Z]+")) {
        throw new NotAlphabeticException();
    }
}
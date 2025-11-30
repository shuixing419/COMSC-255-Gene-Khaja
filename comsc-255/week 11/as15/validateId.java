package as15;

public static void validateId(String sId)
        throws IdNotWholeNumberException,
        IdOutOfRangeException {
    int idInt;
    try {
        idInt = Integer.parseInt(sId);
    } catch (NumberFormatException ex) {
        throw new IdNotWholeNumberException();
    }

    if (idInt < 1 || idInt > 999) {
        throw new IdOutOfRangeException();
    }
}
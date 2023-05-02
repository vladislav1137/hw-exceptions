public class Auth {
    public static final String REGEX = "^[a-zA-Z0-9_]*$";

    public static void main(String[] args) {
        try {
            checkAuth("Admin_123","123_admiN","123_admiN");
            System.out.println("Успешный вход");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка входа");
        }
    }

    private static void checkAuth(String login, String pass, String confirmPass) throws WrongLoginException,WrongPasswordException {
        if (!login.matches(REGEX) || login.length()>20) {
            throw new WrongLoginException();
        }
        if (!pass.matches(REGEX) || pass.length()>20 || !pass.equals(confirmPass)) {
            throw new WrongPasswordException();
        }
    }
}


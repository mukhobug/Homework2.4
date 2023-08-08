public class Main {
    public static void main(String[] args) {
        String login = "admin";
        String password = "admin";
        String confirmPassword = "admin";
        System.out.println(signIn(login, password, confirmPassword));
    }

    public static boolean signIn(String login, String password, String confirmPassword) {
        try {
            return checkLogin(login) && checkPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean checkLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("максимальная длина логина 20");
        } else if (login.matches(".*\\W.*")) {
            throw new WrongLoginException("Логин не удовлетворяет требованиям");
        }
        return true;
    }

    private static boolean checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.length() >= 20) {
            throw new WrongPasswordException("Максимальная длина пароля 19");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        } else if (password.matches(".*\\W.*")) {
            throw new WrongPasswordException("Пароль не удовлетворяет требованиям");
        }
        return true;
    }
}
package utils;

public class StringChecker
{
    public static void checkLogin(String login) throws LoginException
    {
        if (login.length() > 12)
        {
            throw new LoginException("Login deve ter, no máximo, 12 caracteres.");
        }
        if (login.isEmpty() || login.length() == 0)
        {
            throw new LoginException("Login não pode ser vazio.");
        }
        if (login.matches(".*\\d.*"))
        {
            throw new LoginException("Login não pode conter números.");
        }
    }

    public static void checkPassword(String password) throws PasswordException
    {
        if (password.length() > 20)
        {
            throw new PasswordException("Senha deve ter no máximo 20 caracteres.");
        }
        if (password.length() < 8)
        {
            throw new PasswordException("Senha deve ter no mínimo 8 caracteres.");
        }
        if (!(password.matches(".*[a-zA-Z]+.*") &&
                password.matches(".*\\d.*") &&
                countDigits(password) >= 2))
        {
            throw new PasswordException("Senha deve possuir letras e pelo menos dois números.");
        }
    }

    private static int countDigits(String s)
    {
        int count = 0;
        for (int i = 0, len = s.length(); i < len; i++)
        {
            if (Character.isDigit(s.charAt(i)))
            {
                count++;
            }
        }
        return count;
    }
}

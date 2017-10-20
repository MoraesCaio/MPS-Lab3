package business.model;

/**
 * Created by caiomoraes on 19/10/17.
 */
public class User
{
    private String login;
    private String password;

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "Login: " + login +
                "\nPassword: " + password + "\n";
    }
}

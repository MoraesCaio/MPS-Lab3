package business.model;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.io.Serializable;

/**
 * Created by caiomoraes on 19/10/17.
 */
public class User implements Serializable
{
    private String login;
    private String password;

    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public User()
    {
        this("Nome", "Senha");
    }

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

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof User)
        {
            User otherUser = (User) obj;
            if (login.equals(otherUser.getLogin()) &&
                    password.equals((otherUser.getPassword())))
            {
                return true;
            }
        }
        return false;
    }
}

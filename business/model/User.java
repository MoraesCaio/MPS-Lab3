package business.model;
import java.io.Serializable;

/**
 * A token is will always have: its own text, its classification and its line number (in case of some exception).
 * <p>
 * Created on 06/08/17 by
 * <p>
 * Caio Moraes
 * GitHub: MoraesCaio
 * Email: caiomoraes
 * <p>
 * Janyelson Oliveira
 * GitHub: janyelson
 * Email: janyelsonvictor@gmail.com
 * <p>
 * Tiago Henrique
 * Github: tiagohn
 * Email: tiagohn.cc.ufpb@gmail.com
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

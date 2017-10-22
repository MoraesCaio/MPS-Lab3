package business.control;

import Utils.LoginException;
import Utils.PassException;
import business.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caiomoraes on 19/10/17.
 */
public class UserManager
{
    private List<User> users;

    public UserManager(List users)
    {
        this.users = users;
    }

    public UserManager()
    {
        this(new ArrayList());
    }

    public void add(User user) throws LoginException, PassException
    {
        if (user.getLogin().length() > 12)
            throw new LoginException("Login deve ter, no máximo, 12 caracteres.");
        if (user.getLogin().isEmpty() || user.getLogin().length() == 0)
            throw new LoginException("Login não pode ser vazio.");
        if (user.getLogin().matches(".*\\d.*"))
            throw new LoginException("Login não pode conter números.");

        if (user.getPassword().length() > 20)
            throw new PassException("Senha deve ter no máximo 20 caracteres.");
        if (user.getPassword().length() < 8)
            throw new PassException("Senha deve ter no mínimo 8 caracteres.");
        if (!(user.getPassword().matches(".*[a-zA-Z]+.*") &&
                user.getPassword().matches(".*\\d.*") &&
                countDigits(user.getPassword()) >= 2))
            throw new PassException("Senha deve possuir letras e pelo menos dois números.");
        users.add(user);
    }

    public void del(User user)
    {
        users.remove(user);
    }

    public void listAll()
    {
        for (User user : users)
        {
            System.out.println(user);
        }
    }

    public List<User> getUsers()
    {
        return users;
    }

    public int countDigits(String s)
    {
        int count = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}

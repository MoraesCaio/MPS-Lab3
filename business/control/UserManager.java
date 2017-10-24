package business.control;

import business.model.User;
import infra.Persistent;
import infra.RegisterManager;
import utils.StringChecker;
import utils.InfraException;
import utils.LoginException;
import utils.PasswordException;
import java.util.ArrayList;
import java.util.List;

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

public class UserManager
{
    private List<User> users;
    private Persistent registers;

    public UserManager(Persistent registers) throws InfraException
    {
        this.registers = registers;
        try
        {
            users = registers.load();
        }
        catch (InfraException iEx)
        {
            registers.save(new ArrayList<User>());
            users = registers.load();
        }
    }

    public UserManager() throws InfraException
    {
        this(new RegisterManager());
    }

    public void add(User user) throws InfraException, LoginException, PasswordException
    {
     	StringChecker.checkLogin(user.getLogin());
    	StringChecker.checkPassword(user.getPassword());
        users.add(user);
        registers.save(users);
    }


    /**
     * Deletes user whose login has been informed
     * @param login String login of the user.
     * @return
     * @throws InfraException
     */
    public boolean del(String login) throws InfraException
    {
        boolean hasDeletedUser = false;
        for (User user : users)
        {
            if (user.getLogin().equals(login))
            {
                users.remove(user);
                registers.save(users);
                hasDeletedUser = true;
                break;
            }
        }
        return hasDeletedUser;
    }

    /**
     * Lists all users.
     * @return String containing all users.
     */
    public String listAll()
    {
        StringBuilder list = new StringBuilder();

        for (User user : users)
        {
            list.append(user).append("\n");
        }

        return list.toString();
    }

    public List<User> getUsers()
    {
        return users;
    }
}

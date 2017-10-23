package business.control;

import business.model.User;
import infra.Persistent;
import infra.RegisterManager;
import utils.InfraException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caiomoraes on 19/10/17.
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

    public void add(User user) throws InfraException
    {
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

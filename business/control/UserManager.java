package business.control;

import utils.InfraException;
import utils.LoginException;
import utils.PassException;
import business.model.User;
import infra.Binario;

import java.util.Iterator;
import java.util.List;

/**
 * Created by caiomoraes on 19/10/17.
 */
public class UserManager
{
    private List<User> users;
    Persistent registros;

    public UserManager(Persistent regType) throws InfraException {
    	registros = regType;
        users = registros.load();
    }

    public void add(User user) throws LoginException, PassException, InfraException {

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
        registros.save(users);
    }

    public boolean del(String login) throws InfraException {

        boolean isDelete = false;
        Iterator<User> iter = users.iterator();

        while (iter.hasNext()) {
            User user = iter.next();

            if (user.getLogin().equals(login)) {
                iter.remove();
                isDelete = true;
            }
        }

        if(isDelete)registros.save(users);

        return isDelete;
    }

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

package infra;

import utils.InfraException;
import business.model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterManager implements Persistent
{
    public void save(List<User> users) throws InfraException
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("infra/Register.bin");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(users);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new InfraException("Erro ao salvar lista de usuários.");
        }
    }

    public List<User> load() throws InfraException{
        List<User> users;
        try
        {
            FileInputStream fis = new FileInputStream("infra/Register.bin");
            ObjectInputStream in = new ObjectInputStream(fis);
            users = (ArrayList<User>) in.readObject();
            return users;
        }
        catch(EOFException eofEx) {
            return new ArrayList<User>();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            throw new InfraException("Erro ao carregar lista de usuários.");
        }
    }

}


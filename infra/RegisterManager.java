package infra;

import utils.InfraException;
import business.model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterManager implements Persistent
{
    private String registerFile;
    private static final String defaultRegisterFile = "Register.bin";

    public RegisterManager(String registerFile)
    {
        this.registerFile = registerFile;
    }

    public RegisterManager()
    {
        this(defaultRegisterFile);
    }

    public void save(List<User> users) throws InfraException
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(registerFile);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(users);
        }
        catch (IOException e)
        {
            throw new InfraException("Erro ao salvar lista de usuários.");
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> load() throws InfraException
    {
        List<User> users = new ArrayList<>();
        try
        {
            FileInputStream fis = new FileInputStream(registerFile);
            ObjectInputStream in = new ObjectInputStream(fis);

            if (in.readObject() instanceof ArrayList)
            {
                users = (ArrayList<User>) in.readObject();
            }
            return users;
        }
        //Empty file
        catch (EOFException eofEx)
        {
            return new ArrayList<User>();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            throw new InfraException("Erro ao carregar lista de usuários.");
        }

    }

}


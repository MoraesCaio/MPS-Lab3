package infra;

import utils.InfraException;
import business.model.User;

import java.util.List;

public interface Persistent
{
    void save(List<User> users) throws InfraException;

    List<User> load() throws InfraException;
}
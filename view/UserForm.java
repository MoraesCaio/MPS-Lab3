package view;

import infra.RegisterManager;
import utils.InfraException;
import utils.LoginException;
import utils.PasswordException;
import business.control.UserManager;
import business.model.User;
import utils.StringChecker;
import javax.swing.*;

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
public class UserForm
{
    private UserManager userManager;

    public UserForm()
    {
        try
        {
            this.userManager = new UserManager(new RegisterManager());
        }
        catch (InfraException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void menu()
    {

        String result;
        String message = "<html>Escolha uma opção:<br><br>" +
                "1 - Adicionar Usuário<br>" +
                "2 - Remover Usuário<br>" +
                "3 - Listar Usuários<html>";

        while (true)
        {
            result = JOptionPane.showInputDialog(message);
            if (result == null)
            {
                break;
            }

            switch (result)
            {
                case "1":
                    try
                    {
                        addForm();
                    }
                    catch (LoginException | PasswordException e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case "2":
                    removeForm();
                    break;
                case "3":
                    listForm();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Erro, digite novamente!");
            }
        }
    }

    private void addForm() throws LoginException, PasswordException
    {
        String login = JOptionPane.showInputDialog("Usuário:");
        //User pressed cancel button
        if (login == null)
        {
            return;
        }
        StringChecker.checkLogin(login);

        String password = JOptionPane.showInputDialog("Senha:");
        //User pressed cancel button
        if (password == null)
        {
            return;
        }
        StringChecker.checkPassword(password);

        try
        {
            userManager.add(new User(login, password));
            JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
        }
        catch (InfraException iEx)
        {
            JOptionPane.showMessageDialog(null, iEx.getMessage());
        }
    }

    private void removeForm()
    {

        String login = JOptionPane.showInputDialog("Usuário:");
        //User pressed cancel button
        if (login == null)
        {
            return;
        }

        try
        {
            if (userManager.del(login))
            {
                JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            }
        }
        catch (InfraException iEx)
        {
            JOptionPane.showMessageDialog(null, iEx.getMessage());
        }
    }

    private void listForm()
    {
        JOptionPane.showMessageDialog(null, userManager.listAll());
    }
}

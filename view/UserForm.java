package view;

import utils.InfraException;
import utils.LoginException;
import utils.PassException;
import business.control.UserManager;
import business.model.User;
import javax.swing.*;

/**
 * Created by caiomoraes on 19/10/17.
 */
public class UserForm
{

    public void menu()
    {

        String result;
        String message = "<html>Escolha uma opção:<br><br>" +
                         "1 - Adicionar Usuário<br>" +
                         "2 - Remover Usuário<br>" +
                         "3 - Listar Usuários<html>";

        while(true) {
            result = JOptionPane.showInputDialog(message);
            if (result == null) {
                break;
            }

            switch (result) {
                case "1":
                    addForm();
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

    private void addForm() {
        String login = JOptionPane.showInputDialog("Usuário:");

        if (login == null) return;

        String senha = JOptionPane.showInputDialog("Senha:");

        if (senha == null) return;

        try {
            new UserManager().add(new User(login, senha));
            JOptionPane.showMessageDialog(null, "Sucesso!");
        } catch (LoginException | PassException | InfraException lpiEx) {
            JOptionPane.showMessageDialog(null, lpiEx.getMessage());
        }
    }

    private void removeForm() {

        String login = JOptionPane.showInputDialog("Usuário:");

        if (login == null) return;

        try {

            if(new UserManager().del(login)) JOptionPane.showMessageDialog(null, "Sucesso!");
            else JOptionPane.showMessageDialog(null, "Usuário não encontrado");

        } catch (InfraException iEx) {
            JOptionPane.showMessageDialog(null, iEx.getMessage());
        }
    }

    private void listForm() {
        try {
            JOptionPane.showMessageDialog(null, new UserManager().listAll());
        } catch (InfraException iEx) {
            JOptionPane.showMessageDialog(null, iEx.getMessage());
        }
    }
}

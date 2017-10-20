package view;

import javax.swing.*;

/**
 * Created by caiomoraes on 19/10/17.
 */
public class UserForm
{
    public void menu()
    {
        Object[] options = {"Adicionar usuário",
                "Remover usuário",
                "Listar usuário"};
        while(true)
        {
            int n = JOptionPane.showOptionDialog(null, "Opções", "Sistema", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
            switch (n){
                case 0:
                    addForm();
                    break;
                case 1:
                    removeForm();
                    break;
                case 2:
                    listForm();
                    break;
            }
        }
    }

    public void addForm()
    {

    }
}

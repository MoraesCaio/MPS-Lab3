package view;

import business.control.UserManager;
import infra.RegisterManager;

/**
 * Created by caiomoraes on 19/10/17.
 */
public class Main
{
    public static void main(String[] args)
    {
        UserForm userForm = new UserForm();
        UserManager userManager = new UserManager();
        RegisterManager registerManager = new RegisterManager();

        userForm.menu();
    }
}

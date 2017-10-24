package test;

import business.control.UserManager;
import business.model.User;
import infra.RegisterManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.InfraException;
import utils.LoginException;
import utils.PasswordException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest
{
    private UserManager userManager;

    @BeforeEach
    void setUp() throws Exception
    {
        userManager = new UserManager(new RegisterManager());

    }

    @Test
    void testAdd()
    {
        User expected;

        String login = "abcd";
        String password = "abcdef12";

        expected = new User(login, password);

        try
        {
            userManager.add(new User(login, password));
        }
        catch (InfraException | LoginException | PasswordException e)
        {
            fail("O teste falhou, está lançando uma exceção!");
        }
    }


    @Test
    void testAddLoginMax12()
    {
        String login = "abcdefghijklm";
        String password = "abcdef12";

        try
        {
            userManager.add(new User(login, password));
            fail("O teste falhou, deveria lançar uma exceção!");
        }
        catch (LoginException | InfraException | PasswordException e)
        {
            if (e instanceof LoginException)
            {
                // successful test !
                assertTrue(true);
            }
            else
            {
                fail("O teste falhou, está lançando a exceção errada !");
            }
        }
    }

    @Test
    void testAddLoginEmpty()
    {
        String login = "";
        String password = "abcdef12";

        try
        {
            userManager.add(new User(login, password));
            fail("O teste falhou, deveria lançar uma exceção!");
        }
        catch (LoginException | InfraException | PasswordException e)
        {
            if (e instanceof LoginException)
            {
                // successful test !
                assertTrue(true);
            }
            else
            {
                fail("O teste falhou, está lançando a exceção errada !");
            }
        }

    }

    @Test
    void testAddLoginNumber()
    {
        String login = "abcd1";
        String password = "abcdef12";

        try
        {
            userManager.add(new User(login, password));
            fail("O teste falhou, deveria lançar uma exceção!");
        }
        catch (LoginException | InfraException | PasswordException e)
        {
            if (e instanceof LoginException)
            {
                // successful test !
                assertTrue(true);
            }
            else
            {
                fail("O teste falhou, está lançando a exceção errada !");
            }
        }

    }


    //password
    @Test
    void testAddPasswordMax20()
    {
        String login = "abcde";
        String password = "abcdefghijklmnopq1234567890";

        try
        {
            userManager.add(new User(login, password));
            fail("O teste falhou, deveria lançar uma exceção!");
        }
        catch (LoginException | InfraException | PasswordException e)
        {
            if (e instanceof PasswordException)
            {
                // successful test !
                assertTrue(true);
            }
            else
            {
                fail("O teste falhou, está lançando a exceção errada !");
            }
        }
    }

    @Test
    void testAddPasswordMin8()
    {
        String login = "abcde";
        String password = "abcd12";

        try
        {
            userManager.add(new User(login, password));
            fail("O teste falhou, deveria lançar uma exceção!");
        }
        catch (LoginException | InfraException | PasswordException e)
        {
            if (e instanceof PasswordException)
            {
                // successful test !
                assertTrue(true);
            }
            else
            {
                fail("O teste falhou, está lançando a exceção errada !");
            }
        }

    }


    @Test
    void testAddPasswordLetters()
    {
        String login = "abcde";
        String password = "1234567890";

        try
        {
            userManager.add(new User(login, password));
            fail("O teste falhou, deveria lançar uma exceção!");
        }
        catch (LoginException | InfraException | PasswordException e)
        {
            if (e instanceof PasswordException)
            {
                // successful test !
                assertTrue(true);
            }
            else
            {
                fail("O teste falhou, está lançando a exceção errada !");
            }
        }
    }

    @Test
    void testAddPasswordNoNumbers()
    {
        String login = "abcde";
        String password = "abcdefghijklmnopq";

        try
        {
            userManager.add(new User(login, password));
            fail("O teste falhou, deveria lançar uma exceção!");
        }
        catch (LoginException | InfraException | PasswordException e)
        {
            if (e instanceof PasswordException)
            {
                // successful test !
                assertTrue(true);
            }
            else
            {
                fail("O teste falhou, está lançando a exceção errada !");
            }
        }

    }

    @Test
    void testAddTwoDigits()
    {
        String login = "abcde";
        String password = "abcdefg1";

        try
        {
            userManager.add(new User(login, password));
            fail("O teste falhou, deveria lançar uma exceção!");
        }
        catch (LoginException | InfraException | PasswordException e)
        {
            if (e instanceof PasswordException)
            {
                // successful test !
                assertTrue(true);
            }
            else
            {
                fail("O teste falhou, está lançando a exceção errada !");
            }
        }

    }

    @Test
    void testDel()
    {
        try
        {
            userManager.add(new User("aaaaaaaa", "aaa11aaa"));
            userManager.add(new User("bbbbbbbb", "bbb22bbb"));
            if (!userManager.del("bbbbbbbb"))
            {
                fail("O teste falhou ao remover usuário");
            }
        }
        catch (InfraException | LoginException | PasswordException e)
        {
            fail("O teste falhou, está lançando a exceção errada !");
        }

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("aaaaaaaa", "aaa11aaa"));

        assertEquals(users, userManager.getUsers());
    }

    @Test
    void testDelNonExistentUser()
    {
        try
        {
            userManager.add(new User("aaaaaaaa", "aaa11aaa"));
            assertEquals(false, userManager.del("bbbbbbbb"));
        }
        catch (InfraException | LoginException | PasswordException e)
        {
            fail("O teste falhou, está lançando a exceção errada !");
        }
    }

    @Test
    void testListAll()
    {
        try
        {
            userManager.add(new User("aaaaaaaa", "aaa11aaa"));
            userManager.add(new User("bbbbbbbb", "bbb22bbb"));
            assertEquals("Login: aaaaaaaa\nPassword: aaa11aaa\n" +
                    "\nLogin: bbbbbbbb\nPassword: bbb22bbb\n\n", userManager.listAll());
        }
        catch (PasswordException | LoginException | InfraException e)
        {
            fail("O teste falhou, está lançando a exceção errada !");
        }
    }

    @Test
    void testGetUsers()
    {
        try
        {
            userManager.add(new User("aaaaaaaa", "aaa11aaa"));
            userManager.add(new User("bbbbbbbb", "bbb22bbb"));
            userManager.add(new User("cccccccc", "ccc33ccc"));

            ArrayList<User> users = new ArrayList<User>();
            users.add(new User("aaaaaaaa", "aaa11aaa"));
            users.add(new User("bbbbbbbb", "bbb22bbb"));
            users.add(new User("cccccccc", "ccc33ccc"));

            assertEquals(users, userManager.getUsers());
        }
        catch (InfraException | LoginException | PasswordException e)
        {
            fail("O teste falhou, está lançando uma exceção!");
        }

    }
}
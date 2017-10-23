package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.control.UserManager;
import business.model.User;
import infra.RegisterManager;
import utils.InfraException;
import utils.LoginException;
import utils.PasswordException;

class UserManagerTest {
	private UserManager userManager;

	@BeforeEach
	void setUp() throws Exception {
		userManager = new UserManager(new RegisterManager());
		
	}

	//Login user
	
	@Test
	void testAdd()
	{
		// as expected
		User expected;
		
		String login = "abcd";
		String password = "abcdef12";
		
		expected = new User(login,password);
		
		try {
			userManager.add(new User(login, password));
			assertTrue(isSaved(expected));
		
		} catch (InfraException | LoginException | PasswordException e) {
			fail("O teste falhou, está lançando uma exceção!");
			e.printStackTrace();
		}
		
		
	}

	@Test
	void testAddMax12Login(){ 
		//max 12
		
		String login = "abcdefghijklm";
		String password = "abcdef12";
		
		try{
			userManager.add(new User(login, password));
			fail("O teste falhou, devria lançar uma exceção!");
		
		} catch(LoginException | InfraException | PasswordException e) {
			
			if(e instanceof LoginException)
			{
				// successful test !
				assertTrue(true);
			}else {fail("O teste falhou, está lançando a axcessão errada !");}
			
		}
	}
	
	@Test
	void testAddEmpty() { 
		//empty login
		
		String login = "";
		String password = "abcdef12";

		try{
			userManager.add(new User(login, password));
			fail("O teste falhou, devria lançar uma exceção!");
		
		} catch(LoginException | InfraException | PasswordException e) {
			
			if(e instanceof LoginException)
			{
				// successful test !
				assertTrue(true);
			}else {fail("O teste falhou, está lançando a axcessão errada !");}
			
		}

	}
	
	@Test
	void testAddNumber() {
		//login number

		String login = "abcd1";
		String password = "abcdef12";

		try{
			userManager.add(new User(login, password));
			fail("O teste falhou, devria lançar uma exceção!");
		
		} catch(LoginException | InfraException | PasswordException e) {
			
			if(e instanceof LoginException)
			{
				// successful test !
				assertTrue(true);
			}else {fail("O teste falhou, está lançando a axcessão errada !");}
			
		}
		
	}
	

	//login password
	
	
	@Test
	void testAddMax20Pw() {
		// max 20
		
		String login = "abcde";
		String password = "abcdefghijklmnopq1234567890";

		try{
			userManager.add(new User(login, password));
			fail("O teste falhou, devria lançar uma exceção!");
		
		} catch(LoginException | InfraException | PasswordException e) {
			
			if(e instanceof PasswordException)
			{
				// successful test !
				assertTrue(true);
			}else {fail("O teste falhou, está lançando a axcessão errada !");}
			
		}
	}
	
	@Test
	void testAddMin8() {
		// min 8

		String login = "abcde";
		String password = "abcd12";

		try{
			userManager.add(new User(login, password));
			fail("O teste falhou, devria lançar uma exceção!");
		
		} catch(LoginException | InfraException | PasswordException e) {
			
			if(e instanceof PasswordException)
			{
				// successful test !
				assertTrue(true);
			}else {fail("O teste falhou, está lançando a axcessão errada !");}
			
		}
		
	}
	
	
	@Test
	void testAddLettersPw() {
		// no letters
		
		String login = "abcde";
		String password = "1234567890";

		try{
			userManager.add(new User(login, password));
			fail("O teste falhou, devria lançar uma exceção!");
		
		} catch(LoginException | InfraException | PasswordException e) {
			
			if(e instanceof PasswordException)
			{
				// successful test !
				assertTrue(true);
			}else {fail("O teste falhou, está lançando a axcessão errada !");}
			
		}
	}
	
	@Test
	void testAddNoNumber() {
		// no numbers

		String login = "abcde";
		String password = "abcdefghijklmnopq";

		try{
			userManager.add(new User(login, password));
			fail("O teste falhou, devria lançar uma exceção!");
		
		} catch(LoginException | InfraException | PasswordException e) {
			
			if(e instanceof PasswordException)
			{
				// successful test !
				assertTrue(true);
			}else {fail("O teste falhou, está lançando a axcessão errada !");}
			
		}
		
	}
	
	@Test
	void testAddTwoDigits() {
		// does not have 2 digits

		String login = "abcde";
		String password = "abcdefg1";

		try{
			userManager.add(new User(login, password));
			fail("O teste falhou, devria lançar uma exceção!");
		
		} catch(LoginException | InfraException | PasswordException e) {
			
			if(e instanceof PasswordException)
			{
				// successful test !
				assertTrue(true);
			}else {fail("O teste falhou, está lançando a axcessão errada !");}
			
		}
		
	}
	
	@Test
	void testDel() {
		fail("Not yet implemented");
	}

	@Test
	void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUsers() {
		fail("Not yet implemented");
	}

	// helpers
	
	private boolean isSaved(User usr) throws InfraException
	{
		
		List<User> users = userManager.getUsers();
		

		Iterator<User> usersAsIterator = users.iterator();
	    
		
		while (usersAsIterator.hasNext())
	    {
	           User it = usersAsIterator.next();
	           
	           if(it.getLogin().equals(usr.getLogin()) && it.getPassword().equals(usr.getPassword()))return true;
	           
	    }
	    return false;
	    
	}

}


/*
 * @BeforeEach
void setUp()
{
ArrayList<User> testUsers = new ArrayList<User>();
testUsers.add(new User("abcdefgh", "abcdef12")); //OK
//login
testUsers.add(new User("abcdefghabcde", "abcdef12")); //max 12 chars
testUsers.add(new User("", "abcdef12")); //empty login
testUsers.add(new User("abcdefgh1", "abcdef12")); //login number
//password
testUsers.add(new User("abcdefgh", "abcdef12abcdef12abcdef12")); //max 20 chars
testUsers.add(new User("abcdefgh", "abcd12")); //min 8 chars
testUsers.add(new User("abcdefgh", "12345678")); //no letters
testUsers.add(new User("abcdefgh", "abcdefgh")); //no numbers
testUsers.add(new User("abcdefgh", "abcdefg1")); //does not have 2 digits
 */
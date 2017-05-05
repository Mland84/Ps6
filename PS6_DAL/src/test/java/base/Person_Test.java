package base;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
private static PersonDomainModel per1 = new PersonDomainModel();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		per1.setLastName("Land");
		per1.setFirstName("Mitch");
		per1.setCity("Middletown");
		per1.setPostalCode(19709);
		per1.setStreet("140 Westside Lane");
		PersonDAL.addPerson(per1);
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertNotNull(per2);
		
	}
	
	@Test
	public static void testUpdateDeletePerson() throws Exception{
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertEquals(per1.getPersonID(),per2.getPersonID());
		per2.setLastName("Smith");
		PersonDAL.updatePerson(per2);
		PersonDomainModel per3 = PersonDAL.getPerson(per1.getPersonID());
		assertEquals(per2.getLastName(), per3.getPersonID());
		assertNotEquals(per1.getLastName(),per2.getLastName());
		PersonDAL.deletePerson(per1.getPersonID());
		PersonDomainModel per4 = PersonDAL.getPerson(per1.getPersonID());
		assertNull(per4);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(per1.getPersonID());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

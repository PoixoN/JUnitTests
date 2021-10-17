import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import org.testng.annotations.DataProvider;

@RunWith(Parameterized.class)
public class PersonTest {
    @Parameterized.Parameters
    public static Collection<Object[]> getParameters()
    {
        return Arrays.asList(new Object[][] {{"Artem","Kasprukov",27, "ArtemKasprukov"},{"Lubomyr","Maevskiy",44, "LubomyrMaevskiy"}});
    }

    private int age;
    private String name;
    private String surname;
    private String ns;

    public PersonTest(String name, String surname, int age, String ns)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.ns = ns;
    }

    public static Person person;

    @Test
    public void test1() {
        assertNotNull(person);
        System.out.println("=======================Test 1=======================");
    }
    @Test
    public void test2() {
        assertNull(person.surname);
        System.out.println("=======================Test 2=======================");
    }
    @Test
    public void test3() {
        person.newAge();
        assertEquals(person.age,22);
        System.out.println("=======================Test 3=======================");
    }
    @Test
    public void test4() {
        assertFalse(person.Name("Dina"));
        System.out.println("=======================Test 4=======================");
    }

    @Test // параметризированный
    public void test5()
    {
        assertThat(person.NameSurname(name,surname), is(ns));
        System.out.println("=======================Test 5=======================");
    }

    @Test //hamcrest
    public void test6(){
        assertThat(person.surname, equalTo(null));
        System.out.println("=======================Test 6=======================");
    }

    @Test // hamcrest
    public void test7(){
        assertThat(person.NewName(), endsWith("bin"));
        System.out.println("=======================Test 7=======================");
    }

    @BeforeClass
    public static void setUpClass() {
        person = new Person();
        person.name="Maevskiy";
        person.displayInfo();
        System.out.println("=======================@BeforeClass=======================");
    }

    @Before
    public void setUp() {
        person.setAge(38);
        person.displayInfo();
        System.out.println("=======================@Before=======================");
    }
}
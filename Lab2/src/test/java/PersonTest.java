import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;


public class PersonTest {

    public static Person pers = new Person();

    @DataProvider(name = "test")
    public static Object[][] getParameters(){
        return new Object[][] {{"Artem","Kasprukov",27, "ArtemKasprukov"},{"Lubomyr","Maevskiy",44, "LubomyrMaevskiy"}};
    }

    @Test (groups = {"group1"})
    public void test1() {
        assertNotNull(pers);
        System.out.println("=======================Test 1=======================");
    }
    @Test (groups = {"group2"})
    public void test2() {
        assertNull(pers.surname);
        System.out.println("=======================Test 2=======================");
    }
    @Test (groups = {"group1", "group2"})
    public void test3() {
        pers.newAge();
        assertEquals(pers.age,22);
        System.out.println("=======================Test 3=======================");
    }
    @Test (groups = {"group2"})
    public void test4() {
        assertFalse(pers.Name("Dina"));
        System.out.println("=======================Test 4=======================");
    }

    @Test(dataProvider = "test", groups = {"group1"})
    public void test5(String name, String surname, Integer age, String ns)
    {
        Assert.assertEquals(pers.NameSurname(name,surname), (ns));
        System.out.println("=======================Test 5=======================");
    }

    @Test (groups = {"group1", "group2"})
    @BeforeClass
    public static void setUpClass() {
        pers.name="Maevskiy";
        pers.displayInfo();
        System.out.println("=======================@Before=======================");
    }
}
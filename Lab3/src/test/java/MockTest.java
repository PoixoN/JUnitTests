import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

public class MockTest {
    private static Person person;
    private static final int OkId = 5;
    private static final int NotOkId = 10;
    @Mock
    private Provider provider;

    @BeforeClass
    public static void NewPeron() {
        person = new Person("Artem", "Maevskiy", 32);
    }

    @Before
    public void MockitoProvider() {
        person = new Person();
        MockitoAnnotations.initMocks(this);
        person.setArgumentProvider(provider);
    }

    @Test
    public void Test1Name() {
        Mockito.when(provider.nextArgS()).thenReturn("Artem");
        assertTrue("Artem".equals(person.NewName()));
        verify(provider, Mockito.atLeastOnce()).nextArgS();
    }

    @Test
    public void Test2Concat() throws IdNotFoundException {
        Mockito.when(provider.getArgS(3)).thenReturn("Artem");
        Mockito.when(provider.getArgS(4)).thenReturn("Kasprukov");
        Mockito.when(provider.getArgD(5)).thenReturn(29.0);
        assertEquals("ArtemKasprukov29.0", person.NameSurnameAge(3, 4, 5));
        verify(provider, Mockito.atLeastOnce()).getArgS(3);
    }

    @Test
    public void Test3Age() {
        Mockito.when(provider.nextArgD()).thenReturn(22.0);
        assertTrue(22 == person.newAge());
        verify(provider, Mockito.atLeastOnce()).nextArgD();
    }



    @Test(expected = RuntimeException.class)
    public void kk() throws IdNotFoundException {
        Mockito.when(provider.getArgS(NotOkId)).thenThrow(new RuntimeException("Fatal data access exception"));
        String val = person.GetName(3);
        System.out.println(val);
    }
}

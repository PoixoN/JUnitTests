import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;

public class SpyTest {
    @Spy
    private Person pers;

    @Before
    public void setPers() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void Test() {
        IProvider spyprovider = Mockito.spy(IProvider.class);
        Mockito.when(spyprovider.getArgS(5)).thenReturn("Sanya");
        assertEquals(false, pers.Name("Sasha"));
    }

}

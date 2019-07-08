/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.jenkinstest.Cal;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author kuadlk
 */
public class CalTest {
    
    public CalTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void passTest() {
        Cal calulator = new Cal();
        int result = calulator.add(1, 2);
        assertEquals(result, 3);
        result = calulator.sub(1, 5);
        assertEquals(result, 4);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

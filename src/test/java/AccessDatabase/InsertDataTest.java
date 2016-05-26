/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDatabase;

import com.mycompany.mavenproject1.DataModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author THaskioglu
 */
public class InsertDataTest {
    DataModel datamodel;
    String chosenpath;
    public InsertDataTest() {
    }

    @Test
    public void testSomeMethod() {
        InsertData ins=new InsertData(datamodel,chosenpath);
    }
    
}

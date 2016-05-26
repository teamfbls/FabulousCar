/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDatabase;

import java.sql.Connection;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author THaskioglu
 */
public class DBconTest {
    DBcon dbcon;
    Connection b;
    Statement a;
    public DBconTest() {
    }

    @Before
    public void initi(){
    dbcon=new DBcon();
    b=dbcon.connectDB();
    
    }
    @Test
    public void testSomeMethod() {
        assertNotNull(b);
    }
    
}

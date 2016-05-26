/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AccessDatabase.AccessData;
import AccessDatabase.DBcon;
import com.mycompany.mavenproject1.DataFetch;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author THaskioglu
 */
public class AccessJUnitTest {
     DBcon dbcon;
    Connection b;
     AccessData ac;
     ResultSet res;
     DataFetch df;
     int a;
    public AccessJUnitTest() {
    }
    
    @Before
    public void initi(){
    
    }
    
    
    @Test
    public void testAccess(){
      df=new DataFetch();
        ac=new AccessData();
     try {
           ac.liste();
           ac.listeBaujahr();
           ac.listeFarbe();
           ac.listeHersteller();
           ac.listeKraftstoff();
           ac.listeLeistung();
           ac.listeModell();
           ac.listeTop5();
           ac.listeTueren();
           ac.listeZustand();
        
           assertTrue(ac.getRe_baujahr()!= null);
           assertTrue(ac.getRe_farbe()!= null);
           assertTrue(ac.getRe_hersteller()!= null);
           assertTrue(ac.getRe_kraftstoff()!= null);
           assertTrue(ac.getRe_leistung()!= null);
           assertTrue(ac.getRe_modell()!= null);
           assertTrue(ac.getRe_top()!= null);
           assertTrue(ac.getRe_tueren()!= null);
           assertTrue(ac.getRe_zustand()!= null);
         assertTrue(ac.getResult()!= null);
         
         df.setColumnList();
         df.setDataBaujahr();
         df.setDataFarbe();
         df.setDataHersteller();
         df.setDataKraftstoff();
         df.setDataLeistung();
         df.setDataModell();
         df.setDataTueren();
         df.setDataZustand();
         df.setTop();
         
            assertTrue(df.getRe_baujahr()!= null);
           assertTrue(df.getRe_farbe()!= null);
           assertTrue(df.getRe_hersteller()!= null);
           assertTrue(df.getRe_kraftstoff()!= null);
           assertTrue(df.getRe_leistung()!= null);
           assertTrue(df.getRe_modell()!= null);
           
           assertTrue(df.getRe_tueren()!= null);
           assertTrue(df.getRe_zustand()!= null);
     
         
        } catch (Exception e) {
        }
        
    }
    
   
}

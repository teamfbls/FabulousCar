/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import AccessDatabase.DeleteData;
import AccessDatabase.InsertData;

/**
 *
 * @author THaskioglu
 */
public class FacadeClass {
    String[][] dataarray1;
    String[] dataarray10;
    DataFetch df= new DataFetch();
    
       public String[] setColumnListTop5() throws Exception{

        
 dataarray10= df.setColumnListTop5();
 
 return dataarray10;  
    }

    public String[] setColumnList()throws Exception {

    dataarray10=   df.setColumnList();
    return dataarray10;  
    }

    public String [][] setShowList()throws Exception{
     
           
    dataarray1=df.setShowList();
    return dataarray1;  
    
    }
    
    public String[][] setList()throws Exception {
        
    dataarray1=df.setList();
    return dataarray1;
        
 
    }

    public String[][] setDataBaujahr()throws Exception {

     dataarray1=   df.setDataBaujahr();
     return dataarray1;
         
    }

    public String[][] setDataFarbe() throws Exception{

      dataarray1= df.setDataFarbe();
      return dataarray1;
 
    }

    public String[][] setDataHersteller()throws Exception {

     dataarray1 = df.setDataHersteller();
     return dataarray1;

  
    }

    public String[][] setDataKraftstoff()throws Exception {

     dataarray1= df.setDataKraftstoff();
return dataarray1;
          

    }

    public String[][] setDataLeistung()throws Exception {


       dataarray1=    df.setDataLeistung();
       return dataarray1;

    }

    public String[][] setDataModell()throws Exception {

     dataarray1= df.setDataModell();
     return dataarray1;

    }

    public String[][] setDataTueren()throws Exception {

      dataarray1= df.setDataTueren();
      return dataarray1;
     

    }

    public String[][] setDataZustand()throws Exception {

     dataarray1=  df.setDataZustand();
     return dataarray1;
     

    }
    
    public String[][] setTop()throws Exception{
    
dataarray1=df.setTop();
return dataarray1;
    }
    
    public String[][] getSearch(String suchwort,String column)throws Exception{
    
  dataarray1= df.getSearch(suchwort, column);
  return dataarray1;
    }
    
    public void doInsert( DataModel bau,String chosenpath)throws Exception{
     InsertData ins = new InsertData(bau,chosenpath);
     ins.doInsertData();
    }
    
    public void doDeleteData(String abc)throws Exception{
    
    DeleteData del = new DeleteData((abc));
    del.doDeleteData();
    
    
    }
     public void doVerkaufData(String abc)throws Exception{
    
    DeleteData del = new DeleteData((abc));
    del.doVerkaufData();
    
    }
}

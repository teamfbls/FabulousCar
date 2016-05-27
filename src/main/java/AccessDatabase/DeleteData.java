/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDatabase;

/**
 *
 * @author THaskioglu
 */
public class DeleteData implements DeleteDataInterface{
    
    
    String id,deleteStatement;
    DBcon dbconnection=DBcon.getInstance();
    
    public DeleteData( String id){
    
    this.id=id;
     dbconnection.connectDB();
    
    }
    
    @Override
    public void doDeleteData()throws Exception{
    
         if(id.isEmpty()){
         throw new Exception();
         }

            deleteStatement = "Delete from auto where auto.id="+id+"";
            dbconnection.getStmt();
            dbconnection.stmt.executeUpdate( deleteStatement);
  

            if (dbconnection.stmt != null) {

                dbconnection.disConnectDB();

            }

    
    }
     public void doVerkaufData()throws Exception{
    
         if(id.isEmpty()){
         throw new Exception();
         }

            deleteStatement = "Update auto set verkauft=1 where auto.id="+id+"";
            dbconnection.getStmt();
            dbconnection.stmt.executeUpdate( deleteStatement);
  

            if (dbconnection.stmt != null) {

                dbconnection.disConnectDB();

            }

    
    }
    
}

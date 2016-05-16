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
public class DeleteData extends DBcon implements DeleteDataInterface{
    
    String id,deleteStatement;
    
    
    public DeleteData( String id){
    
    this.id=id;
     connectDB();
    
    }
    
    @Override
    public void doDeleteData()throws Exception{
    
         if(id.isEmpty()){
         throw new Exception();
         }

            deleteStatement = "Delete from auto where auto.id="+id+"";
            getStmt();
            stmt.executeUpdate( deleteStatement);
  

            if (stmt != null) {

                disConnectDB();

            }

    
    }
    
}

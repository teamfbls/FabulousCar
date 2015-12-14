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
public class DeleteData extends DBcon{
    
    String id,deleteStatement;
    
    
    public DeleteData( String id){
    
    this.id=id;
     connectDB();
    
    }
    
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

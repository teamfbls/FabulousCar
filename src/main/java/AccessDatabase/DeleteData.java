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
    
    public void doDeleteData(){
    
         try {

            deleteStatement = "Delete from auto where auto.id="+id+"";
            getStmt();
            stmt.executeUpdate( deleteStatement);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {

            if (stmt != null) {

                disConnectDB();

            }

        }
    
    }
    
}

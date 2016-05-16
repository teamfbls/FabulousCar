/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDatabase;
import java.sql.ResultSet;
/**
 *
 * @author THaskioglu
 */
public interface AccessDataInterface {
    public ResultSet liste()throws Exception;
    public ResultSet listeBaujahr()throws Exception;
    public ResultSet listeFarbe()throws Exception;
    public ResultSet listeHersteller()throws Exception;
    public ResultSet listeKraftstoff()throws Exception;
    public ResultSet listeLeistung()throws Exception;
    public ResultSet listeModell()throws Exception;
    public ResultSet listeTueren()throws Exception;
    public ResultSet listeZustand()throws Exception;
    
}

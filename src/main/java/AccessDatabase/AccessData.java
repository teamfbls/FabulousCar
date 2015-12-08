package AccessDatabase;
import java.sql.*;
public class AccessData extends DBcon {
 
    private ResultSet re_hersteller, re_farbe, re_baujahr, re_kraftstoff, re_leistung, re_modell, re_tueren, re_zustand,result,re_top,re_suche;  
    public AccessData(){
    connectDB();
    
    
    } 
    
    public ResultSet liste()throws Exception{
  
        try{
        
        getStmt();
        result=stmt.executeQuery("Select auto.id as ID , auto.Verkaufspreis as Verkaufspreis,\n" +
"auto.Kilometerzahl as Kilometeranzahl,\n" +
"Baujahr.Baujahr as Baujahr,\n" +
"Farbe.Farbe as Farbe,\n" +
"hersteller.Hersteller_Name as Hersteller,\n" +
"kraftstoff.Kraftstofftyp as Kraftstofftyp,\n" +
"leistung.Leistung_in_ps as Leistung_in_Ps,\n" +
"modell.Modell as Modell,\n" +
"tueren.Tuerenanzahl as Tuerenanzahl,\n" +
"zustand.Zustand as Zustand,\n" +
"auto.Beschreibung as Beschreibung,\n"+
"auto.Erstellungsdatum as Erstellungsdatum\n" +
"from auto \n" +
"inner join baujahr on baujahr.Baujahrid=auto.Baujahrid \n" +
"inner join Farbe on Farbe.Farbeid=auto.Farbeid\n" +
"inner join kraftstoff on kraftstoff.Kraftstoffid=auto.Kraftstoffid\n" +
"inner join leistung on leistung.Leistungid=auto.Leistungid\n" +
"inner join modell on modell.HerstellerModellid=auto.HerstellerModellid\n" +
"inner join tueren on tueren.Tuerenid=auto.Tuerenid\n" +
"inner join zustand on zustand.Zustandid=auto.Zustandid\n" +
"inner join hersteller on hersteller.Herstellerid=modell.Herstellerid;");
        return result;
        
        }catch(Exception ex){
  
        return null;}
  }
    public ResultSet listeBaujahr()throws Exception{
  
        try{
        
        getStmt();
        re_baujahr=stmt.executeQuery("Select baujahr.baujahrid,baujahr.Baujahr FROM Baujahr");
        
        return re_baujahr;
        
        }catch(Exception ex){
  
        return null;}
  }
    public ResultSet listeFarbe()throws Exception{
  
        try{
        
        getStmt();
        re_farbe=stmt.executeQuery("Select farbe.Farbeid,farbe.Farbe FROM farbe");
        
        
        return re_farbe;
        
        }catch(Exception ex){
  
        return null;}
  }
    public ResultSet listeHersteller()throws Exception{
  
        try{
        
        getStmt();
        re_hersteller=stmt.executeQuery("Select hersteller.Herstellerid,hersteller.Hersteller_Name FROM hersteller");
        
        return re_hersteller;
        
        }catch(Exception ex){
  
        return null;
        }
  }
    public ResultSet listeKraftstoff()throws Exception{
  
        try{
        
        getStmt();
        re_kraftstoff=stmt.executeQuery("Select kraftstoff.Kraftstoffid,kraftstoff.kraftstofftyp FROM kraftstoff");
        return re_kraftstoff;
        
        }catch(Exception ex){
  
        return null;
        }
  }
    public ResultSet listeLeistung()throws Exception{
  
        try{
        
        getStmt();
        re_leistung=stmt.executeQuery("Select leistung.Leistungid,leistung.Leistung_in_ps FROM leistung");
        return re_leistung;
        
        }catch(Exception ex){
  
        return null;
        }
  }
    public ResultSet listeModell()throws Exception{
  
        try{
        
        getStmt();
        re_modell=stmt.executeQuery("Select HerstellerModellid,modell FROM modell");
        return re_modell;
        
        }catch(Exception ex){
  
        return null;}
  }
    public ResultSet listeTueren()throws Exception{
  
        try{
        
        getStmt();
        re_tueren=stmt.executeQuery("Select tueren.Tuerenid,tueren.Tuerenanzahl FROM tueren");
        return re_tueren;
        
        }catch(Exception ex){
  
        return null;
        }
  }
    public ResultSet listeZustand()throws Exception{
  
        try{
        
        getStmt();
        re_zustand=stmt.executeQuery("Select zustand.Zustandid,zustand.Zustand FROM zustand");
        return re_zustand;
        
        }catch(Exception ex){
  
        return null;
        }
  }
    public ResultSet listeTop5()throws Exception{
 try{
        
        getStmt();
        re_top=stmt.executeQuery("Select auto.Erstellungsdatum as Erstellungsdatum , auto.Verkaufspreis as Verkaufspreis,\n" +
"auto.Kilometerzahl as Kilometeranzahl,\n" +
"Baujahr.Baujahr as Baujahr,\n" +
"Farbe.Farbe as Farbe,\n" +
"hersteller.Hersteller_Name as Hersteller,\n" +
"kraftstoff.Kraftstofftyp as Kraftstofftyp,\n" +
"leistung.Leistung_in_ps as Leistung_in_Ps,\n" +
"modell.Modell as Modell,\n" +
"tueren.Tuerenanzahl as Tuerenanzahl,\n" +
"zustand.Zustand as Zustand,\n" +
"auto.Beschreibung as Beschreibung\n"+
"from auto \n" +
"inner join baujahr on baujahr.Baujahrid=auto.Baujahrid \n" +
"inner join Farbe on Farbe.Farbeid=auto.Farbeid\n" +
"inner join kraftstoff on kraftstoff.Kraftstoffid=auto.Kraftstoffid\n" +
"inner join leistung on leistung.Leistungid=auto.Leistungid\n" +
"inner join modell on modell.HerstellerModellid=auto.HerstellerModellid\n" +
"inner join tueren on tueren.Tuerenid=auto.Tuerenid\n" +
"inner join zustand on zustand.Zustandid=auto.Zustandid\n" +
"inner join hersteller on hersteller.Herstellerid=modell.Herstellerid ORDER BY Erstellungsdatum DESC LIMIT 3 ");
        return re_top;
        
        }catch(Exception ex){
  
        return null;
        }

}
    public ResultSet listeSuche(String suchwort,String column)throws Exception
   {
    try{
       getStmt();
        re_suche=stmt.executeQuery("Select auto.id as ID , auto.Verkaufspreis as Verkaufspreis,\n" +
"auto.Kilometerzahl as Kilometeranzahl,\n" +
"Baujahr.Baujahr as Baujahr,\n" +
"Farbe.Farbe as Farbe,\n" +
"hersteller.Hersteller_Name as Hersteller,\n" +
"kraftstoff.Kraftstofftyp as Kraftstofftyp,\n" +
"leistung.Leistung_in_ps as Leistung_in_Ps,\n" +
"modell.Modell as Modell,\n" +
"tueren.Tuerenanzahl as Tuerenanzahl,\n" +
"zustand.Zustand as Zustand,\n" +
"auto.Beschreibung as Beschreibung,\n"+
"auto.Erstellungsdatum as Erstellungsdatum\n" +
"from auto \n" +
"inner join baujahr on baujahr.Baujahrid=auto.Baujahrid \n" +
"inner join Farbe on Farbe.Farbeid=auto.Farbeid\n" +
"inner join kraftstoff on kraftstoff.Kraftstoffid=auto.Kraftstoffid\n" +
"inner join leistung on leistung.Leistungid=auto.Leistungid\n" +
"inner join modell on modell.HerstellerModellid=auto.HerstellerModellid\n" +
"inner join tueren on tueren.Tuerenid=auto.Tuerenid\n" +
"inner join zustand on zustand.Zustandid=auto.Zustandid\n" +
"inner join hersteller on hersteller.Herstellerid=modell.Herstellerid where "+column+" like '%"+suchwort+"%'");
        return re_suche;
        
        }catch(Exception ex){
  
        return null;
        }

    
    
    }
}

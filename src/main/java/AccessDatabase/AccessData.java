package AccessDatabase;
import java.sql.*;
public class AccessData implements AccessDataInterface{
 
    
    
    DBcon dbconnection=DBcon.getInstance();
    private ResultSet re_hersteller, re_farbe, re_baujahr, re_kraftstoff, re_leistung, re_modell, re_tueren, re_zustand,result,re_top,re_suche;  

    public void setRe_hersteller(ResultSet re_hersteller) {
        this.re_hersteller = re_hersteller;
    }

    public void setRe_farbe(ResultSet re_farbe) {
        this.re_farbe = re_farbe;
    }

    public void setRe_baujahr(ResultSet re_baujahr) {
        this.re_baujahr = re_baujahr;
    }

    public void setRe_kraftstoff(ResultSet re_kraftstoff) {
        this.re_kraftstoff = re_kraftstoff;
    }

    public void setRe_leistung(ResultSet re_leistung) {
        this.re_leistung = re_leistung;
    }

    public void setRe_modell(ResultSet re_modell) {
        this.re_modell = re_modell;
    }

    public void setRe_tueren(ResultSet re_tueren) {
        this.re_tueren = re_tueren;
    }

    public void setRe_zustand(ResultSet re_zustand) {
        this.re_zustand = re_zustand;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    public void setRe_top(ResultSet re_top) {
        this.re_top = re_top;
    }

    public void setRe_suche(ResultSet re_suche) {
        this.re_suche = re_suche;
    }

    public ResultSet getRe_hersteller() {
        return re_hersteller;
    }

    public ResultSet getRe_farbe() {
        return re_farbe;
    }

    public ResultSet getRe_baujahr() {
        return re_baujahr;
    }

    public ResultSet getRe_kraftstoff() {
        return re_kraftstoff;
    }

    public ResultSet getRe_leistung() {
        return re_leistung;
    }

    public ResultSet getRe_modell() {
        return re_modell;
    }

    public ResultSet getRe_tueren() {
        return re_tueren;
    }

    public ResultSet getRe_zustand() {
        return re_zustand;
    }

    public ResultSet getResult() {
        return result;
    }

    public ResultSet getRe_top() {
        return re_top;
    }

    public ResultSet getRe_suche() {
        return re_suche;
    }
    public AccessData(){
  
        dbconnection.connectDB();
    
    
    } 
    
    @Override
    public ResultSet liste()throws Exception{
  
        try{
        
          dbconnection.getStmt();
        result=  dbconnection.stmt.executeQuery("Select auto.id as ID , auto.Verkaufspreis as Verkaufspreis,\n" +
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
"auto.Erstellungsdatum as Erstellungsdatum,\n" +
"auto.pic_path as Picturepfad,\n"+
"auto.verkauft as Verfuegbar\n"+
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
    @Override
    public ResultSet listeBaujahr()throws Exception{
  
        try{
        
          dbconnection.getStmt();
        re_baujahr=  dbconnection.stmt.executeQuery("Select baujahr.baujahrid,baujahr.Baujahr FROM Baujahr");
        
        return re_baujahr;
        
        }catch(Exception ex){
  
        return null;}
  }
    @Override
    public ResultSet listeFarbe()throws Exception{
  
        try{
        
          dbconnection.getStmt();
        re_farbe=  dbconnection.stmt.executeQuery("Select farbe.Farbeid,farbe.Farbe FROM farbe");
        
        
        return re_farbe;
        
        }catch(Exception ex){
  
        return null;}
  }
    @Override
    public ResultSet listeHersteller()throws Exception{
  
        try{
        
          dbconnection.getStmt();
        re_hersteller=  dbconnection.stmt.executeQuery("Select hersteller.Herstellerid,hersteller.Hersteller_Name FROM hersteller");
        
        return re_hersteller;
        
        }catch(Exception ex){
  
        return null;
        }
  }
    @Override
    public ResultSet listeKraftstoff()throws Exception{
  
        try{
        
          dbconnection.getStmt();
        re_kraftstoff=  dbconnection.stmt.executeQuery("Select kraftstoff.Kraftstoffid,kraftstoff.kraftstofftyp FROM kraftstoff");
        return re_kraftstoff;
        
        }catch(Exception ex){
  
        return null;
        }
  }
    @Override
    public ResultSet listeLeistung()throws Exception{
  
        try{
        
          dbconnection.getStmt();
        re_leistung=  dbconnection.stmt.executeQuery("Select leistung.Leistungid,leistung.Leistung_in_ps FROM leistung");
        return re_leistung;
        
        }catch(Exception ex){
  
        return null;
        }
  }
    @Override
    public ResultSet listeModell()throws Exception{
  
        try{
        
          dbconnection.getStmt();
        re_modell=  dbconnection.stmt.executeQuery("Select HerstellerModellid,modell FROM modell");
        return re_modell;
        
        }catch(Exception ex){
  
        return null;}
  }
    @Override
    public ResultSet listeTueren()throws Exception{
  
        try{
        
          dbconnection.getStmt();
        re_tueren=  dbconnection.stmt.executeQuery("Select tueren.Tuerenid,tueren.Tuerenanzahl FROM tueren");
        return re_tueren;
        
        }catch(Exception ex){
  
        return null;
        }
  }
    @Override
    public ResultSet listeZustand()throws Exception{
  
        try{
        
          dbconnection.getStmt();
        re_zustand=  dbconnection.stmt.executeQuery("Select zustand.Zustandid,zustand.Zustand FROM zustand");
        return re_zustand;
        
        }catch(Exception ex){
  
        return null;
        }
  }
    public ResultSet listeTop5()throws Exception{
 try{
        
          dbconnection.getStmt();
        re_top=  dbconnection.stmt.executeQuery("Select auto.Erstellungsdatum as Erstellungsdatum , auto.Verkaufspreis as Verkaufspreis,\n" +
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
         dbconnection.getStmt();
        re_suche=  dbconnection.stmt.executeQuery("Select auto.id as ID , auto.Verkaufspreis as Verkaufspreis,\n" +
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

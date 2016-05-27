/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDatabase;

import com.mycompany.mavenproject1.DataModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author THaskioglu
 */
public class InsertData implements InsertDataInterface{

    
    DBcon dbconnection=DBcon.getInstance();
    DataModel datamodel;
    String insertStatement,
            baujahr,
            hersteller,
            farbe,
            kraftstoff,
            leistung,
            modell,
            tueren,
            zustand,
            beschreibung,
            kilometeranzahl,
            verkaufspreis,
            erstelldatum,
            chosenpath;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();

    public InsertData(DataModel datamodel,String chosenpath) {
        this.chosenpath=chosenpath;
        this.datamodel = datamodel;
        dbconnection.connectDB();

    }

    @Override
    public void doInsertData() throws Exception{

        
        beschreibung = datamodel.getdataFetchBeschreibung();
        kraftstoff = datamodel.getdataFetchKraftstoff();
        leistung = datamodel.getdataFetchLeistung();
        modell = datamodel.getdataFetchModell();
        tueren = datamodel.getdataFetchTueren();
        zustand = datamodel.getdataFetchZustand();
        farbe = datamodel.getdatafetchFarbe();
        hersteller = datamodel.getdatafetchHersteller();
        kilometeranzahl = datamodel.getdatafetchkilometeranzahl();
        verkaufspreis = datamodel.getdatafetchverkaufspreis();
        baujahr = datamodel.getdatafetchBaujahr();
        erstelldatum = dateFormat.format(date);
        
        
        Integer.parseInt(verkaufspreis);
        Integer.parseInt(kilometeranzahl);
        if(zustand.isEmpty()
                ||kraftstoff.isEmpty()
                ||leistung.isEmpty()
                ||modell.isEmpty()
                ||tueren.isEmpty()
                ||zustand.isEmpty()
                ||farbe.isEmpty()
                ||hersteller.isEmpty()
                ||baujahr.isEmpty()
                ||erstelldatum.isEmpty()){
        
        throw new Exception();
        }
        
      
            insertStatement = "INSERT INTO Auto(Verkaufspreis,HerstellerModellid,Baujahrid,Farbeid,Tuerenid,Leistungid,Kilometerzahl,Kraftstoffid,Zustandid,Beschreibung,Erstellungsdatum,pic_path,verkauft)"
                    + "values('" + verkaufspreis + "','" + modell + "','" + baujahr + "','" + farbe + "','" + tueren + "','" + leistung + "','" + kilometeranzahl + "','" + kraftstoff + "','" + zustand + "','" + beschreibung + "','" + erstelldatum + "','"+chosenpath+"',0)";
            dbconnection.getStmt();
            dbconnection.stmt.executeUpdate(insertStatement);
   
            if (dbconnection.stmt != null) {

                dbconnection.disConnectDB();

            }

        

    }

}

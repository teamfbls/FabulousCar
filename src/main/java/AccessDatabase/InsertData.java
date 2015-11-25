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
public class InsertData extends DBcon {

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
            erstelldatum;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();

    public InsertData(DataModel datamodel) {

        this.datamodel = datamodel;
        connectDB();

    }

    public void doInsertData() {

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
        

        try {

            insertStatement = "INSERT INTO Auto(Verkaufspreis,HerstellerModellid,Baujahrid,Farbeid,Tuerenid,Leistungid,Kilometerzahl,Kraftstoffid,Zustandid,Beschreibung,Erstellungsdatum)"
                    + "values('" + verkaufspreis + "','" + modell + "','" + baujahr + "','" + farbe + "','" + tueren + "','" + leistung + "','" + kilometeranzahl + "','" + kraftstoff + "','" + zustand + "','" + beschreibung + "','" + erstelldatum + "')";
            getStmt();
            stmt.executeUpdate(insertStatement);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {

            if (stmt != null) {

                disConnectDB();

            }

        }

    }

}

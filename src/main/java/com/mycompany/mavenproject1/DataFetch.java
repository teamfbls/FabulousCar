/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import AccessDatabase.AccessData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

/**
 *
 * @author THaskioglu
 */
public class DataFetch {

    AccessData ac = new AccessData();
    ResultSet re_hersteller, re_farbe, re_baujahr, re_kraftstoff, re_leistung, re_modell, re_tueren, re_zustand, re_list, re_columnlist,re_columnlisttop,re_showlist,re_search;

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

    public void setRe_list(ResultSet re_list) {
        this.re_list = re_list;
    }

    public void setRe_columnlist(ResultSet re_columnlist) {
        this.re_columnlist = re_columnlist;
    }

    public void setRe_columnlisttop(ResultSet re_columnlisttop) {
        this.re_columnlisttop = re_columnlisttop;
    }

    public void setRe_showlist(ResultSet re_showlist) {
        this.re_showlist = re_showlist;
    }

    public void setRe_search(ResultSet re_search) {
        this.re_search = re_search;
    }

    public void setRsmd(ResultSetMetaData rsmd) {
        this.rsmd = rsmd;
    }

    public void setDataarray(String[][] dataarray) {
        this.dataarray = dataarray;
    }

    public void setColumnarray(String[] columnarray) {
        this.columnarray = columnarray;
    }

    public void setRowCounter(int rowCounter) {
        this.rowCounter = rowCounter;
    }

    public void setColumnCounter(int columnCounter) {
        this.columnCounter = columnCounter;
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

    public ResultSet getRe_list() {
        return re_list;
    }

    public ResultSet getRe_columnlist() {
        return re_columnlist;
    }

    public ResultSet getRe_columnlisttop() {
        return re_columnlisttop;
    }

    public ResultSet getRe_showlist() {
        return re_showlist;
    }

    public ResultSet getRe_search() {
        return re_search;
    }

    public ResultSetMetaData getRsmd() {
        return rsmd;
    }

    public String[][] getDataarray() {
        return dataarray;
    }

    public String[] getColumnarray() {
        return columnarray;
    }

    public int getRowCounter() {
        return rowCounter;
    }

    public int getColumnCounter() {
        return columnCounter;
    }
    ResultSetMetaData rsmd;
    String dataarray[][];
    String columnarray[];
    int rowCounter = 0, columnCounter = 0;
    
  
    public String[] setColumnListTop5() throws Exception{

        

            re_columnlisttop = ac.listeTop5();
            rsmd = re_columnlisttop.getMetaData();
            columnCounter = rsmd.getColumnCount();
            columnarray= new String [columnCounter];
            for (int i = 0; i < columnCounter; i++) {

                columnarray[i] = rsmd.getColumnName(i + 1);

            }
            return columnarray;
  

    }

    public String[] setColumnList()throws Exception {

       
            re_columnlist = ac.liste();
            rsmd = re_columnlist.getMetaData();
            columnCounter = rsmd.getColumnCount();
            columnarray= new String [columnCounter];
            for (int i = 0; i < columnCounter; i++) {

                columnarray[i] = rsmd.getColumnName(i + 1);

            }
            return columnarray;


    }

    public String [][] setShowList()throws Exception{
     
            re_showlist = ac.liste();
            while (re_showlist.next()) {

                rowCounter++;
            }
            re_showlist.first();

            rsmd = re_showlist.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[columnCounter][rowCounter]; // Achtung:Hier ist der Rowcounter vorne wegen der anzeige in html
            rowCounter = 0;
            for (int i = 0; i < columnCounter; i++) {
                dataarray[i][rowCounter] = re_showlist.getString(i + 1);
                rowCounter++;
                while (re_showlist.next()) {

                    dataarray[i][rowCounter] = re_showlist.getString(i + 1);
                    rowCounter++;
                }
                re_showlist.first();
                rowCounter = 0;
            }

            return dataarray;
      
    
    
    }
    
    public String[][] setList()throws Exception {
        

            re_list = ac.liste();
            while (re_list.next()) {

                rowCounter++;
            }
            re_list.first();

            rsmd = re_list.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[rowCounter][columnCounter]; // Achtung:Hier ist der Rowcounter vorne wegen der anzeige in html
            rowCounter = 0;
            for (int i = 0; i < columnCounter; i++) {
                dataarray[rowCounter][i] = re_list.getString(i + 1);
                rowCounter++;
                while (re_list.next()) {

                    dataarray[rowCounter][i] = re_list.getString(i + 1);
                    rowCounter++;
                }
                re_list.first();
                rowCounter = 0;
            }

            return dataarray;
 
    }

    public String[][] setDataBaujahr()throws Exception {

        
            re_baujahr = ac.listeBaujahr();
            while (re_baujahr.next()) {

                rowCounter++;
            }
            re_baujahr.first();

            rsmd = re_baujahr.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[columnCounter][rowCounter];
            rowCounter = 0;
            for (int i = 0; i < columnCounter; i++) {
                dataarray[i][rowCounter] = re_baujahr.getString(i + 1);
                rowCounter++;
                while (re_baujahr.next()) {

                    dataarray[i][rowCounter] = re_baujahr.getString(i + 1);
                    rowCounter++;
                }
                re_baujahr.first();
                rowCounter = 0;
            }

            return dataarray;
  

    }

    public String[][] setDataFarbe() throws Exception{

       

            re_farbe = ac.listeFarbe();
            while (re_farbe.next()) {

                rowCounter++;
            }

            rsmd = re_farbe.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[columnCounter][rowCounter];
            rowCounter = 0;

            re_farbe.first();
            for (int i = 0; i < columnCounter; i++) {
                dataarray[i][rowCounter] = re_farbe.getString(i + 1);
                rowCounter++;

                while (re_farbe.next()) {

                    dataarray[i][rowCounter] = re_farbe.getString((i + 1));
                    rowCounter++;
                }
                re_farbe.first();
                rowCounter = 0;
            }

            return dataarray;
 
    }

    public String[][] setDataHersteller()throws Exception {

       

            re_hersteller = ac.listeHersteller();
            while (re_hersteller.next()) {

                rowCounter++;
            }
            re_hersteller.first();

            rsmd = re_hersteller.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[columnCounter][rowCounter];
            rowCounter = 0;
            for (int i = 0; i < columnCounter; i++) {
                dataarray[i][rowCounter] = re_hersteller.getString(i + 1);
                rowCounter++;
                while (re_hersteller.next()) {

                    dataarray[i][rowCounter] = re_hersteller.getString(i + 1);
                    rowCounter++;
                }
                re_hersteller.first();
                rowCounter = 0;

            }
            return dataarray;
  
    }

    public String[][] setDataKraftstoff()throws Exception {

      

            re_kraftstoff = ac.listeKraftstoff();
            while (re_kraftstoff.next()) {

                rowCounter++;
            }
            re_kraftstoff.first();

            rsmd = re_kraftstoff.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[columnCounter][rowCounter];
            rowCounter = 0;
            for (int i = 0; i < columnCounter; i++) {
                dataarray[i][rowCounter] = re_kraftstoff.getString(i + 1);
                rowCounter++;
                while (re_kraftstoff.next()) {

                    dataarray[i][rowCounter] = re_kraftstoff.getString(i + 1);
                    rowCounter++;
                }
                re_kraftstoff.first();
                rowCounter = 0;

            }
            return dataarray;
  

    }

    public String[][] setDataLeistung()throws Exception {


            re_leistung = ac.listeLeistung();
            while (re_leistung.next()) {

                rowCounter++;
            }
            re_leistung.first();

            rsmd = re_leistung.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[columnCounter][rowCounter];
            rowCounter = 0;
            for (int i = 0; i < columnCounter; i++) {
                dataarray[i][rowCounter] = re_leistung.getString(i + 1);
                rowCounter++;
                while (re_leistung.next()) {

                    dataarray[i][rowCounter] = re_leistung.getString(i + 1);
                    rowCounter++;
                }
                re_leistung.first();
                rowCounter = 0;

            }
            return dataarray;
 

    }

    public String[][] setDataModell()throws Exception {

      

            re_modell = ac.listeModell();
            while (re_modell.next()) {

                rowCounter++;
            }
            re_modell.first();

            rsmd = re_modell.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[columnCounter][rowCounter];
            rowCounter = 0;
            for (int i = 0; i < columnCounter; i++) {
                dataarray[i][rowCounter] = re_modell.getString(i + 1);
                rowCounter++;

                while (re_modell.next()) {

                    dataarray[i][rowCounter] = re_modell.getString(i + 1);
                    rowCounter++;
                }
                re_modell.first();
                rowCounter = 0;

            }
            return dataarray;
   

    }

    public String[][] setDataTueren()throws Exception {

       
            re_tueren = ac.listeTueren();
            while (re_tueren.next()) {

                rowCounter++;
            }
            re_tueren.first();

            rsmd = re_tueren.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[columnCounter][rowCounter];
            rowCounter = 0;
            for (int i = 0; i < columnCounter; i++) {
                dataarray[i][rowCounter] = re_tueren.getString(i + 1);
                rowCounter++;
                while (re_tueren.next()) {

                    dataarray[i][rowCounter] = re_tueren.getString(i + 1);
                    rowCounter++;
                }
                re_tueren.first();
                rowCounter = 0;

            }
            return dataarray;
     

    }

    public String[][] setDataZustand()throws Exception {

        

            re_zustand = ac.listeZustand();
            while (re_zustand.next()) {

                rowCounter++;
            }
            re_zustand.first();

            rsmd = re_zustand.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[columnCounter][rowCounter];
            rowCounter = 0;

            for (int i = 0; i < columnCounter; i++) {

                dataarray[i][rowCounter] = re_zustand.getString(i + 1);
                rowCounter++;
                while (re_zustand.next()) {

                    dataarray[i][rowCounter] = re_zustand.getString(i + 1);
                    rowCounter++;

                }
                re_zustand.first();
                rowCounter = 0;
            }

            return dataarray;
     

    }
    
    public String[][] setTop()throws Exception{
    

         re_showlist = ac.listeTop5();
            while (re_showlist.next()) {

                rowCounter++;
            }
            re_showlist.first();

            rsmd = re_showlist.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[columnCounter][ rowCounter]; // Achtung:Hier ist der Rowcounter vorne wegen der anzeige in html
            rowCounter = 0;
            for (int i = 0; i < columnCounter; i++) {
                dataarray[i][rowCounter] = re_showlist.getString(i + 1);
                rowCounter++;
                while (re_showlist.next()) {

                    dataarray[i][rowCounter] = re_showlist.getString(i + 1);
                    rowCounter++;
                }
                re_showlist.first();
                rowCounter = 0;
            }

            return dataarray;
    
    
    }
    
    public String[][] getSearch(String suchwort,String column)throws Exception{
    
    re_search = ac.listeSuche(suchwort, column);
    while (re_search.next()) {

                rowCounter++;
            }
            re_search.first();

            rsmd = re_search.getMetaData();
            columnCounter = rsmd.getColumnCount();
            dataarray = new String[rowCounter][columnCounter]; // Achtung:Hier ist der Rowcounter vorne wegen der anzeige in html
            rowCounter = 0;
            for (int i = 0; i < columnCounter; i++) {
                dataarray[rowCounter][i] = re_search.getString(i + 1);
                rowCounter++;
                while (re_search.next()) {

                    dataarray[rowCounter][i] = re_search.getString(i + 1);
                    rowCounter++;
                }
                re_search.first();
                rowCounter = 0;
            }

            return dataarray;
  
    }
}

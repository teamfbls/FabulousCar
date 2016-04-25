/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import AccessDatabase.DeleteData;
import AccessDatabase.InsertData;
import com.mycompany.mavenproject1.DataModel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mycompany.mavenproject1.DataFetch;
import com.mycompany.mavenproject1.DataSearch;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.junit.runner.Request;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author THaskioglu
 */
@Controller
public class IndexController {

    String[][] dataarray1, dataarray2, dataarray3, dataarray4, dataarray5, dataarray6, dataarray7, dataarray8, dataarray9, dataarray11, dataarray12, datafilearray;
    String[] dataarray10;
    int db;
    DataModel datamodel = new DataModel();
    DataSearch ds = new DataSearch();
    List<String> list = new ArrayList<String>();

    String contenttype;
    File file, file2;
    File[] filelist;
    String dataname;
    String path2;

    @RequestMapping("/index")
    public String index() {
        return "/WEB-INF/index.jsp";

    }

    @RequestMapping(value = "/newjsp", method = RequestMethod.GET)
    public ModelAndView getAdmissionForm(ModelAndView model, HttpServletRequest request) {
        try {
            DataFetch df = new DataFetch();

            Map<String, String> mapFile = new HashMap<String, String>();
            datafilearray = picupload(request);
            mapFile = rechnedropdown(mapFile, datafilearray);

            Map< String, String> mapBaujahr = new HashMap<String, String>();
            dataarray1 = df.setDataBaujahr();
            mapBaujahr = rechnedropdown(mapBaujahr, dataarray1);

            Map< String, String> mapHersteller = new HashMap<String, String>();
            dataarray2 = df.setDataHersteller();
            mapHersteller = rechnedropdown(mapHersteller, dataarray2);

            Map< String, String> mapFarbe = new HashMap<String, String>();
            dataarray3 = df.setDataFarbe();
            mapFarbe = rechnedropdown(mapFarbe, dataarray3);

            Map< String, String> mapKraftstoff = new HashMap<String, String>();
            dataarray4 = df.setDataKraftstoff();
            mapKraftstoff = rechnedropdown(mapKraftstoff, dataarray4);

            Map< String, String> mapLeistung = new HashMap<String, String>();
            dataarray5 = df.setDataLeistung();
            mapLeistung = rechnedropdown(mapLeistung, dataarray5);

            Map< String, String> mapModell = new HashMap<String, String>();
            dataarray6 = df.setDataModell();
            mapModell = rechnedropdown(mapModell, dataarray6);

            Map<String, String> mapTueren = new HashMap<String, String>();
            dataarray7 = df.setDataTueren();
            mapTueren = rechnedropdown(mapTueren, dataarray7);

            Map<String, String> mapZustand = new HashMap<String, String>();
            dataarray8 = df.setDataZustand();
            mapZustand = rechnedropdown(mapZustand, dataarray8);

            model.addObject("mapBaujahr", mapBaujahr);
            model.addObject("datafetchBaujahr", datamodel);
            model.addObject("mapHersteller", mapHersteller);
            model.addObject("datafetchHersteller", datamodel);
            model.addObject("mapFarbe", mapFarbe);
            model.addObject("datafetchFarbe", datamodel);
            model.addObject("mapKraftstoff", mapKraftstoff);
            model.addObject("dataFetchKraftstoff", datamodel);
            model.addObject("mapLeistung", mapLeistung);
            model.addObject("dataFetchLeistung", datamodel);
            model.addObject("mapModell", mapModell);
            model.addObject("dataFetchModell", datamodel);
            model.addObject("mapTueren", mapTueren);
            model.addObject("dataFetchTueren", datamodel);
            model.addObject("mapZustand", mapZustand);
            model.addObject("dataFetchZustand", datamodel);
            model.addObject("dataFetchBeschreibung", datamodel);
            model.addObject("datafetchverkaufspreis", datamodel);
            model.addObject("datafetchkilometeranzahl", datamodel);
            model.addObject("mapFile", mapFile);
            model.addObject("datafetchfile", datamodel);
            return model;
        } catch (Exception ex) {
            model.addObject("errorcode", ex.toString());
            model.setViewName("nosuccessform");
            return model;
        }

    }

    @ModelAttribute("baujahr")
    public DataModel construct() {

        return new DataModel();
    }

    @ModelAttribute("datasearch")
    public DataSearch constructs() {

        return new DataSearch();
    }

    @RequestMapping(value = "/writedata", method = RequestMethod.POST)
    public ModelAndView writeDataForm(@ModelAttribute("baujahr") DataModel bau, HttpServletRequest request) {
        ModelAndView model = new ModelAndView("writedata");

        try {
            String chosenpath=searchpic(request, bau);
            InsertData ins = new InsertData(bau,chosenpath);
            ins.doInsertData();
            return model;
        } catch (Exception ex) {
            model.addObject("errorcode", ex.toString());
            model.setViewName("nosuccessform");
            return model;
        }

    }

    @RequestMapping(value = "/listall", method = RequestMethod.GET)
    public ModelAndView ff(ModelAndView m) {

        try {
            if (list.isEmpty()) {

            } else {

                list.clear();
            }
            DataFetch df = new DataFetch();
            dataarray10 = df.setColumnList();

            getColumnArralist();
            dataarray9 = df.setList();
            m.addObject("listrowlength", dataarray9.length - (1));
            m.addObject("listhead", list);
            m.addObject("listrow", dataarray9);
            return m;
        } catch (Exception ex) {
            m.addObject("errorcode", ex.toString());
            m.setViewName("nosuccessform");
            return m;
        }
    }

    @RequestMapping(value = "/showcars", method = RequestMethod.GET)
    public ModelAndView ff2(ModelAndView m) {
        try {
            if (list.isEmpty()) {

            } else {

                list.clear();
            }
            DataFetch df = new DataFetch();
            dataarray10 = df.setColumnList();

            getColumnArralist();
            dataarray11 = df.setShowList();
            m.addObject("listrowlength", dataarray10.length - (1));
            m.addObject("listhead", list);
            m.addObject("listrow", dataarray11);
           
            return m;
        } catch (Exception ex) {
            m.addObject("errorcode", ex.toString());
            m.setViewName("nosuccessform");
            return m;
        }
    }

    @RequestMapping(value = "/latestentry", method = RequestMethod.GET)
    public ModelAndView listtop5(ModelAndView m) {
        try {
            if (list.isEmpty()) {

            } else {

                list.clear();
            }
            DataFetch df = new DataFetch();
            dataarray10 = df.setColumnListTop5();

            getColumnArralist();
            dataarray9 = df.setTop();
            m.addObject("listrowlength", dataarray10.length - (1));
            m.addObject("listhead", list);
            m.addObject("listrow", dataarray9);
            return m;
        } catch (Exception ex) {
            m.addObject("errorcode", ex.toString());
            m.setViewName("nosuccessform");
            return m;
        }
    }

    @RequestMapping(value = "/listallsuc", method = RequestMethod.POST)
    public ModelAndView fddd(ModelAndView m, @RequestParam(value = "abc") String abc) {
        try {
            if (abc.isEmpty()) {
                m.setViewName("nosuccessform");
                return m;
            } else {
                DeleteData del = new DeleteData((abc));
                del.doDeleteData();
                m.setViewName("listallsuc");
                return m;
            }
        } catch (Exception ex) {
            m.addObject("errorcode", ex.toString());
            m.setViewName("nosuccessform");
            return m;
        }

    }

    @RequestMapping(value = "/submitSearch", method = RequestMethod.POST)
    public ModelAndView sreach(ModelAndView m, @ModelAttribute("datasearch") DataSearch ds) {
        try {
            DataFetch df = new DataFetch();
            dataarray10 = df.setColumnList();
            if (dataarray10 == null) {

            }
            if (list.isEmpty()) {

            } else {

                list.clear();
            }

            dataarray10 = df.setColumnList();

            getColumnArralist();
            dataarray9 = df.getSearch(ds.getDatasuchwort(), ds.getDatacolumn());
            m.addObject("listrowlength", dataarray9.length - (1));
            m.addObject("listhead", list);
            m.addObject("listrow", dataarray9);
            return m;
        } catch (ArrayIndexOutOfBoundsException arx) {
            m.setViewName("searchfail");
            return m;
        } catch (Exception ex) {

            m.addObject("errorcode", ex.toString());
            m.setViewName("nosuccessform");
            return m;
        }

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView sreachpage(ModelAndView m, @ModelAttribute("datasearch") DataSearch ds) {
        try {
            DataFetch df = new DataFetch();
            dataarray10 = df.setColumnList();
            m.addObject("mapcolumn", dataarray10);
            m.addObject("datacolumn", ds);
            return m;
        } catch (Exception ex) {
            m.addObject("errorcode", ex.toString());
            m.setViewName("nosuccessform");
            return m;
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView uploadpic(HttpServletRequest request, ModelAndView model) {

        String path = request.getRealPath("/upload_images");
        path = path.substring(0, path.indexOf("\\mavenproject1"));
        path = path + "\\mavenproject1\\mavenproject1\\src\\main\\webapp\\upload_images";
        DiskFileItemFactory dfif = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(dfif);

        try {

            List<FileItem> fit = uploader.parseRequest(request);
            for (FileItem fileItem : fit) {
                try {
                    contenttype = fileItem.getContentType();
                    contenttype = contenttype.substring(6, contenttype.length());
                    if (fileItem.isFormField() == false && contenttype.equals("jpeg") || contenttype.equals("png")) {
                        file = new File(path + "/" + fileItem.getName());
                        fileItem.write(file);

                    }
                } catch (Exception ey) {

                }

            }
            return model;
        } catch (Exception ex) {

            if (file.exists()) {

                file.delete();
            }

            model.addObject("errorcode", ex.toString());
            model.setViewName("nosuccessform");
            return model;
        }

    }

    @RequestMapping(value = "/uploadform", method = RequestMethod.GET)
    public ModelAndView showupload(ModelAndView m) {

        return m;

    }

    public Map< String, String> rechnedropdown(Map< String, String> d, String[][] dataarray) {

        for (int i = 0; i <= dataarray.length - (1); i++) {
            for (int j = 0; j <= dataarray[0].length - (1); j++) {

                if (i == dataarray.length - 1) {

                } else {

                    d.put(dataarray[i][j], dataarray[i + 1][j]);
                }
            }
        }

        return d;

    }

    public List<String> getColumnArralist() {

        for (int i = 0; i < dataarray10.length; i++) {

            list.add(dataarray10[i]);
        }
        return list;
    }

    public String[][] picupload(HttpServletRequest request) {
        String path = request.getRealPath("/upload_images");
        path = path.substring(0, path.indexOf("\\mavenproject1"));
        path = path + "\\mavenproject1\\mavenproject1\\src\\main\\webapp\\upload_images";
        file2 = new File(path);
        filelist = file2.listFiles();
        String[][] filear = new String[filelist.length][filelist.length];
        for (int i = 0; i < filelist.length; i++) {
            path2 = filelist[i].getName();
            dataname = path2;
            for (int j = 0; j < filelist.length; j++) {

                filear[j][i] = dataname;

            }

        }

        return filear;

    }

    public String searchpic(HttpServletRequest request, DataModel bau) {
        String path = request.getRealPath("/upload_images");
        path = path.substring(0, path.indexOf("\\mavenproject1"));
        path = path + "\\mavenproject1\\mavenproject1\\src\\main\\webapp\\upload_images";
        file2 = new File(path);
        filelist = file2.listFiles();

        for (int i = 0; i < filelist.length; i++) {
            path2 = filelist[i].getName();
            if (path2.equals(bau.getDatafetchfile())) {

                path = path + "\\"+path2;
                path = path.replace("\\", "\\\\");
                
                return path;
            } 
        }
       return "";
    }

}

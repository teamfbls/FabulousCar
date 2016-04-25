/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mycompany.mavenproject1.DataModel;
import controllers.IndexController;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 *
 * @author THaskioglu
 */
public class IndexControllerTest {
     
    private IndexController indexController;
 
    private MockMvc mockMvc;
    private DataModel model;
    
    Map<String, String> mapFile = new HashMap<String, String>();
           

            Map< String, String> mapBaujahr = new HashMap<String, String>();
           

            Map< String, String> mapHersteller = new HashMap<String, String>();
            

            Map< String, String> mapFarbe = new HashMap<String, String>();
           

            Map< String, String> mapKraftstoff = new HashMap<String, String>();
           

            Map< String, String> mapLeistung = new HashMap<String, String>();
           

            Map< String, String> mapModell = new HashMap<String, String>();
        

            Map<String, String> mapTueren = new HashMap<String, String>();
            

            Map<String, String> mapZustand = new HashMap<String, String>();
         
 
    @Before
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
 
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
 
    }
  @Test
  public void testnewjsp() throws Exception{
  
  mockMvc.perform(get("/newjsp"))
          .andExpect(status().isOk())
          .andExpect(view().name("/newjsp"))
          .andExpect(model().attribute("mapFile", mapFile))
          .andExpect(model().attribute("mapBaujahr", mapBaujahr))
          .andExpect(model().attribute("mapHersteller", mapHersteller))
          .andExpect(model().attribute("mapFarbe", mapFarbe))
          .andExpect(model().attribute("mapKraftstoff", mapKraftstoff))
          .andExpect(model().attribute("mapLeistung", mapLeistung))
          .andExpect(model().attribute("mapModell", mapModell))          
          .andExpect(model().attribute("mapTueren", mapTueren));
  
  
  }
@Test
  public void testwritedata() throws Exception{
  
  mockMvc.perform(get("/writedata"))
          .andExpect(status().isOk())
          .andExpect(view().name("writedata"))
          .andExpect(model().attribute("baujahr", model));

  
  }
 
  @Test
  public void testlistall() throws Exception{
  
  mockMvc.perform(get("/listall"))
          .andExpect(status().isOk())
          .andExpect(view().name("nosuccessform"));

  
  }
 
  
  
}

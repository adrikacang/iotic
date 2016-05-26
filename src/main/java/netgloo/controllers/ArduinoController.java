package netgloo.controllers;

import netgloo.models.Arduino;
import netgloo.models.ArduinoDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class UserController
 */
@Controller
public class ArduinoController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  @RequestMapping(value = "get")
  @ResponseBody
  public Arduino getRecent() {
    //String userid = payload.get("userid");
    Arduino result;
    try{
      List<Arduino> results = arduinoDao.getAll();
      result = results.get(results.size()-1);
    } catch (Exception ex) {
      System.out.println("error " +  ex.toString());
      result = new Arduino();
      result.setHumidity(0.5);
      result.setTemperature(25.5);
      result.setWaterLvl(10.0);
    }
    return result;
  }

/*  @RequestMapping(value = "update")
  @ResponseBody
  public Arduino update(String hum, String temp) {
    //String userid = payload.get("userid");
    double humidity = Double.parseDouble(hum);
    double temperature = Double.parseDouble(temp);
    Arduino result = new Arduino();
    result.setHumidity(humidity);
    result.setTemperature(temperature);
    try{
      arduinoDao.create(result);
    } catch (Exception ex) {
     System.out.println("Error inserting arduino " + result.getHumidity() + " " + result.getTemperature());
    }
    return result;
  }*/

   @RequestMapping(value = "update")
  @ResponseBody
  public Arduino update(String hum, String temp, String  water) {
    //String userid = payload.get("userid");
    double humidity = Double.parseDouble(hum);
    double temperature = Double.parseDouble(temp);
    double waterLvl = Double.parseDouble(water);
    Arduino result = new Arduino();
    result.setHumidity(humidity);
    result.setTemperature(temperature);
    result.setWaterLvl(waterLvl);
    try{
      arduinoDao.create(result);
    } catch (Exception ex) {
     System.out.println("Error inserting arduino " + result.getHumidity() + " " + result.getTemperature() + " " + result.getWaterLvl());
    }
    return result;
  }


  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // Wire the UArduinoDao used inside this controller.
  @Autowired
  private ArduinoDao arduinoDao;
  
} // class ArduinoController

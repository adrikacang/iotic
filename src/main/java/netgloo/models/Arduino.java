package netgloo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "arduinos")
public class Arduino {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private double temperature;

  private double humidity;

  private double waterLvl;

  //private Set<Order> orders;
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  public Arduino() { }

  public Arduino(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  public double getHumidity() {
    return humidity;
  }

  public void setHumidity(double humidity) {
    this.humidity = humidity;
  }

  public double getWaterLvl() {
    return waterLvl;
  }

  public void setWaterLvl(double waterLvl) {
    this.waterLvl = waterLvl;
  }
} // class Arduino

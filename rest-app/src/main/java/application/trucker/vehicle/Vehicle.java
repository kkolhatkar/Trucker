package application.trucker.vehicle;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Kunal
 *
 */
@Entity(name = "Vehicle")
@Table(name = "Vehicle")
public class Vehicle {
	@Id
	private String vin;
	private  String make;
	private  String model;
	private  Integer year;
	private Integer redlineRpm;
	private  Double maxFuelVolume;
    @Temporal(TemporalType.TIMESTAMP)
	private Date lastServiceDate;
	
	public Integer getRedlineRpm() {
		return redlineRpm;
	}
	public void setRedlineRpm(Integer redlineRpm) {
		this.redlineRpm = redlineRpm;
	}
	public Date getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getMaxFuelVolume() {
		return maxFuelVolume;
	}
	public void setMaxFuelVolume(Double maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}
	
}

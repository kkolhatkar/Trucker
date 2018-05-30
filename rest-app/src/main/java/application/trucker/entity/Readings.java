package application.trucker.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Kunal
 *
 */
@Entity
@Table(name = "Readings")
public class Readings {
	
	@Id
    @Column(columnDefinition = "VARCHAR(36)")
	private String id;
	private String vin;
	private Double latitude;
	private Double longitude;
	private Timestamp timestamp;
	private Float fuelVolume;
	private Float speed;
	private Float engineHp;
	private Boolean checkEngineLightOn;
	private Boolean engineCoolantLow;
	private Boolean cruiseControlOn;
	private Integer engineRpm;
	@Embedded
	private Tires tires;
	
	public Readings() {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Float getFuelVolume() {
		return fuelVolume;
	}
	public void setFuelVolume(Float fuelVolume) {
		this.fuelVolume = fuelVolume;
	}
	public Float getSpeed() {
		return speed;
	}
	public void setSpeed(Float speed) {
		this.speed = speed;
	}
	public Float getEngineHp() {
		return engineHp;
	}
	public void setEngineHp(Float engineHp) {
		this.engineHp = engineHp;
	}
	public Boolean getCheckEngineLightOn() {
		return checkEngineLightOn;
	}
	public void setCheckEngineLightOn(Boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}
	public Boolean getEngineCoolantLow() {
		return engineCoolantLow;
	}
	public void setEngineCoolantLow(Boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}
	public Boolean getCruiseControlOn() {
		return cruiseControlOn;
	}
	public void setCruiseControlOn(Boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}
	public Integer getEngineRpm() {
		return engineRpm;
	}
	public void setEngineRpm(Integer engineRpm) {
		this.engineRpm = engineRpm;
	}
	public Tires getTires() {
		return tires;
	}
	public void setTires(Tires tires) {
		this.tires = tires;
	}
	
}

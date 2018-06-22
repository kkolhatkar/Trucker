package application.trucker.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Kunal
 *
 */
@Entity
@Table(name="Alerts")
public class Alerts {
	
	@Id
    @Column(columnDefinition = "VARCHAR(36)")
	private String alertId;
	private String vin;
	private Timestamp alertOccured;
	private String reason;
	private String severity;
	
	public Alerts() {
		this.alertId = UUID.randomUUID().toString();
	}

	public String getAlertId() {
		return alertId;
	}
	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}

	public Timestamp getAlertOccured() {
		return alertOccured;
	}

	public void setAlertOccured(Timestamp alertOccured) {
		this.alertOccured = alertOccured;
	}

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
}

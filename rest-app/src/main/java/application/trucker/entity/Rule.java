package application.trucker.entity;

/**
 * @author Kunal
 *
 */
public enum Rule {
	RULE1("ENGINE RPM IS ABOVE LIMIT","HIGH"), 
	RULE2("FUEL IS LESS","MEDIUM"), 
	RULE3("LOW TIRE PRESSURE","LOW"), 
	RULE4("ENGINE ISSUE","LOW");
	
	private final String reason;
	private final String severity;
	
	/**
	 * @param reason
	 * @param severity
	 */
	private Rule(String reason, String severity) {
		this.reason = reason;
		this.severity = severity;
	}

	public String getReason() {
		return reason;
	}

	public String getSeverity() {
		return severity;
	}
}

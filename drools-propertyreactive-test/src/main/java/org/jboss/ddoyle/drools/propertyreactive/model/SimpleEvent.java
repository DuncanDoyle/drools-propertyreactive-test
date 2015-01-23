package org.jboss.ddoyle.drools.propertyreactive.model;

import java.util.Date;
import java.util.UUID;

import org.kie.api.definition.type.PropertyReactive;

@PropertyReactive
public class SimpleEvent {
	
	private final String eventId;

	private final Date timestamp;
	
	private String status;
	
	public SimpleEvent() {
		this(new Date());
	}
	
	public SimpleEvent(String eventId) {
		this(eventId, new Date());
	}
	
	public SimpleEvent(Date date) {
		this(UUID.randomUUID().toString(), date);
	}
	
	public SimpleEvent(String eventId, Date date) {
		this.eventId = eventId;
		this.timestamp = date;
	}
	
	
	public String getEventId() {
		return eventId;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}

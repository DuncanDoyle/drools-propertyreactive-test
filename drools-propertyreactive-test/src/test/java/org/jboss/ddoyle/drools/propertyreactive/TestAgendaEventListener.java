package org.jboss.ddoyle.drools.propertyreactive;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;

public class TestAgendaEventListener extends DefaultAgendaEventListener {

	private long ruleFirings = 0;

	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		ruleFirings++;
	}

	public long getRuleFirings() {
		return ruleFirings;
	}
		

}

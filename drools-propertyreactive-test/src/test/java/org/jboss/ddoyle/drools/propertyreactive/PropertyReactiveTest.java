package org.jboss.ddoyle.drools.propertyreactive;

import static org.junit.Assert.*;

import org.jboss.ddoyle.drools.propertyreactive.model.SimpleEvent;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyReactiveTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyReactiveTest.class);
	
	private static KieContainer kieContainer;
	
	@BeforeClass
	public static void initTest() {
		KieServices kieServices = KieServices.Factory.get();
		kieContainer = kieServices.getKieClasspathContainer();
	}
	
	@Test
	public void test() {
		KieSession kieSession = kieContainer.newKieSession();
		
		TestAgendaEventListener listener = new TestAgendaEventListener();
		
		kieSession.addEventListener(listener);
		
		SimpleEvent event = new SimpleEvent("1");
		kieSession.insert(event);
		
		LOGGER.debug("Firing rules.");
		kieSession.fireAllRules();

		SimpleEvent event2 = new SimpleEvent("2");
		kieSession.insert(event2);

		LOGGER.debug("Firing rules.");
		kieSession.fireAllRules();
		
		kieSession.dispose();

		//Yeah, not a proper test, I know ..... Should test if the rules have actually fired.
		assertEquals("Expected 4 rules to fire.", 4, listener.getRuleFirings());
		
	}
	
}

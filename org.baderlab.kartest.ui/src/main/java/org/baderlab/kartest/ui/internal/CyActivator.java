package org.baderlab.kartest.ui.internal;

import java.util.Properties;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {

	@Override
	public void start(BundleContext context) {
		System.out.println("org.baderlab.kartest.ui CyActivator.start()");
		
		CyServiceRegistrar serviceRegistrar = getService(context, CyServiceRegistrar.class);
		
		MenuAction action = new MenuAction(serviceRegistrar);
		registerAllServices(context, action, new Properties());
	}
 
}

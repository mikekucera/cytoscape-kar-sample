package org.baderlab.kartest.command.internal;

import java.util.Properties;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.work.ServiceProperties;
import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {

	@Override
	public void start(BundleContext context) {
		System.out.println("org.baderlab.kartest.command CyActivator.start()");
		
		CyServiceRegistrar serviceRegistrar = getService(context, CyServiceRegistrar.class);
		
		AnalyzeCommandTaskFactory taskFactory = new AnalyzeCommandTaskFactory(serviceRegistrar);
		
		Properties props = new Properties();
		props.put(ServiceProperties.COMMAND, "analyze");
		props.put(ServiceProperties.COMMAND_NAMESPACE, "kartest");
		props.put(ServiceProperties.COMMAND_SUPPORTS_JSON, "true");
		registerService(context, taskFactory, TaskFactory.class, props);
	}
 
}

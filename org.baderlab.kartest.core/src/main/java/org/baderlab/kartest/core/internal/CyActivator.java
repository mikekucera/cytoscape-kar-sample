package org.baderlab.kartest.core.internal;

import java.util.Properties;

import org.baderlab.kartest.core.SampleAnalyzer;
import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("org.baderlab.kartest.core CyActivator.start()");
		SampleAnalyzer sampleAnalyzer = new SampleAnalyzerImpl();
		
		Properties properties = new Properties();
		registerService(context, sampleAnalyzer, SampleAnalyzer.class, properties);
	}

}
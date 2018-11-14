package org.baderlab.kartest.command.internal;

import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class AnalyzeCommandTaskFactory extends AbstractTaskFactory {

	private final CyServiceRegistrar serviceRegistrar;
	
	public AnalyzeCommandTaskFactory(CyServiceRegistrar serviceRegistrar) {
		this.serviceRegistrar = serviceRegistrar;
	}

	@Override
	public TaskIterator createTaskIterator() {
		AnalyzeCommandTask task = new AnalyzeCommandTask(serviceRegistrar);
		return new TaskIterator(task);
	}

}

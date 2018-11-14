package org.baderlab.kartest.command.internal;

import java.util.Arrays;
import java.util.List;

import org.baderlab.kartest.core.AnalysisResults;
import org.baderlab.kartest.core.SampleAnalyzer;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.json.JSONResult;

import com.google.gson.Gson;

public class AnalyzeCommandTask extends AbstractTask implements ObservableTask {

	private final CyServiceRegistrar serviceRegistrar;
	
	private AnalysisResults results;
	
	public AnalyzeCommandTask(CyServiceRegistrar serviceRegistrar) {
		this.serviceRegistrar = serviceRegistrar;
	}
	
	@Override
	public void run(TaskMonitor tm)  {
		CyApplicationManager applicationManager = serviceRegistrar.getService(CyApplicationManager.class);
		SampleAnalyzer sampleAnalyzer = (SampleAnalyzer) serviceRegistrar.getService(SampleAnalyzer.class);
		
		CyNetwork network = applicationManager.getCurrentNetwork();
		this.results = sampleAnalyzer.analyzeNetwork(network);
	}

	public String getJson() {
		Gson gson = new Gson();
		return gson.toJson(results);
	}
	
	@Override
	public <R> R getResults(Class<? extends R> type) {
		if(String.class.equals(type)) {	
			return type.cast(results.toString());
		} 
		else if(JSONResult.class.equals(type)) {
			JSONResult res = this::getJson;
			return type.cast(res);
		}

		return null;
	}
	
	@Override 
	public List<Class<?>> getResultClasses() {
		return Arrays.asList(String.class, JSONResult.class);
	}

}

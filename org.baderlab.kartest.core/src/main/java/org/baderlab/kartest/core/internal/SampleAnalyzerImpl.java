package org.baderlab.kartest.core.internal;


import org.baderlab.kartest.core.AnalysisResults;
import org.baderlab.kartest.core.SampleAnalyzer;
import org.cytoscape.model.CyNetwork;

public class SampleAnalyzerImpl implements SampleAnalyzer {

	public AnalysisResults analyzeNetwork(CyNetwork n) {
		if(n == null)
			throw new NullPointerException("network is null");

		int numNodes = n.getNodeCount();
		int numEdges = n.getEdgeCount();
		
		return new AnalysisResults(numNodes, numEdges);
	}
}

package org.baderlab.kartest.core;

import org.cytoscape.model.CyNetwork;


public interface SampleAnalyzer {

	AnalysisResults analyzeNetwork(CyNetwork n);
}

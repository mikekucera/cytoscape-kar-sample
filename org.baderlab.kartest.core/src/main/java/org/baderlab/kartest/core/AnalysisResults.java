package org.baderlab.kartest.core;

public class AnalysisResults {

	private final int numNodes;
	private final int numEdges;
	
	public AnalysisResults(int numNodes, int numEdges) {
		this.numNodes = numNodes;
		this.numEdges = numEdges;
	}

	public int getNumNodes() {
		return numNodes;
	}

	public int getNumEdges() {
		return numEdges;
	}

	@Override
	public String toString() {
		return "AnalysisResults [numNodes=" + numNodes + ", numEdges=" + numEdges + "]";
	}
	
}

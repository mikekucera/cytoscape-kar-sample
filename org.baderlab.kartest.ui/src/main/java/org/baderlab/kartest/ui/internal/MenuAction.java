package org.baderlab.kartest.ui.internal;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.baderlab.kartest.core.AnalysisResults;
import org.baderlab.kartest.core.SampleAnalyzer;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.service.util.CyServiceRegistrar;


/**
 * Creates a new menu item under Apps menu section.
 */
@SuppressWarnings("serial")
public class MenuAction extends AbstractCyAction {

	private final CyServiceRegistrar serviceRegistrar;
	
	
	public MenuAction(CyServiceRegistrar serviceRegistrar) {
		super("KarTest App", serviceRegistrar.getService(CyApplicationManager.class), null, null);
		setPreferredMenu("Apps");
		this.serviceRegistrar = serviceRegistrar;
	}
	

	public void actionPerformed(ActionEvent e) {
		CyApplicationManager applicationManager = serviceRegistrar.getService(CyApplicationManager.class);
		CySwingApplication swingApplication = serviceRegistrar.getService(CySwingApplication.class);
		SampleAnalyzer sampleAnalyzer = (SampleAnalyzer) serviceRegistrar.getService(SampleAnalyzer.class);
		
		CyNetwork network = applicationManager.getCurrentNetwork();
		AnalysisResults results = sampleAnalyzer.analyzeNetwork(network);
		
		String message = "Number of nodes: " + results.getNumNodes();
		
		JOptionPane.showMessageDialog(swingApplication.getJFrame(), message);
	} 
}

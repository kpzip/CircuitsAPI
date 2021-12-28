package com.kpzip.circuitsapi.circuitsimulator;

import java.awt.Dialog;

import com.kpzip.circuitsapi.circuitsimulator.gui.CirSim;

// add plugin.jar to classpath during compilation
import netscape.javascript.JSObject;

class ImportExportAppletDialog extends Dialog implements ImportExportDialog {
    Action type;
    CirSim cframe;
    String circuitDump;

    ImportExportAppletDialog(CirSim f, Action type)
    throws Exception
    {
	super(f, (type == Action.EXPORT) ? "Export" : "Import", false);
	this.type = type;
	cframe = f;
	if ( cframe.applet == null )
	    throw new Exception("Not running as an applet!");
    }

    public void setDump(String dump)
    {
	circuitDump = dump;
    }

    public void execute()
    {
    	try
	{
	    //JSObject window = JSObject.getWindow(cframe.applet);
    	JSObject window = null;
	    if ( type == Action.EXPORT )
	    {
		//cframe.setVisible(false);
		window.call("exportCircuit", new  Object[] { circuitDump });
	    }
	    else
	    {
		//cframe.setVisible(false);
		circuitDump = (String)window.eval("importCircuit()");
		cframe.readSetup( circuitDump );
	    }
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
    }
}

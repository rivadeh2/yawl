package com.nexusbpm.command;

import java.beans.PropertyChangeEvent;

import junit.framework.TestCase;
import operation.WorkflowOperation;
import au.edu.qut.yawl.elements.YAtomicTask;
import au.edu.qut.yawl.elements.YExternalNetElement;
import au.edu.qut.yawl.elements.YInputCondition;
import au.edu.qut.yawl.elements.YNet;
import au.edu.qut.yawl.elements.YOutputCondition;
import au.edu.qut.yawl.elements.YSpecification;
import au.edu.qut.yawl.persistence.dao.DAO;
import au.edu.qut.yawl.persistence.dao.DAOFactory;
import au.edu.qut.yawl.persistence.dao.DatasourceRoot;
import au.edu.qut.yawl.persistence.managed.DataContext;
import au.edu.qut.yawl.persistence.managed.DataProxy;
import au.edu.qut.yawl.persistence.managed.DataProxyStateChangeAdapter;
import au.edu.qut.yawl.persistence.managed.DataProxyStateChangeListener;

import com.nexusbpm.services.NexusServiceInfo;

/**
 * 
 * @author Dean Mao
 * @created Aug 4, 2006
 */
public class CreateSpecificationTest extends CommandTestCase  {

	DataProxy<YSpecification> specificationProxy;

	public void proxyAttached( DataProxy proxy, Object data, DataProxy parent ) {
		assert proxy != null : "Proxy can't be null!";
		specificationProxy = proxy;
	}

	public void testCreateCompleteSpec() throws Exception {
        Command createSpec = new CreateSpecificationCommand(
        		rootProxy,
                "Test Specification",
                this );
        createSpec.execute();

        Command createNet = new CreateNetCommand(
        		specificationProxy,
                "Test Root Net",
                null );
        createNet.execute();
        
        DataProxy<YNet> netProxy = dataContext.getDataProxy(
        		specificationProxy.getData().getDecompositions().get( 0 ), null );

        assert netProxy != null : "net proxy was null";
        

        NexusServiceInfo jython = NexusServiceInfo.getServiceWithName( "Jython" );
        Command createJython = new CreateNexusComponentCommand(
                netProxy,
                jython.getServiceName(),
                jython.getServiceName(),
                jython,
                null );
        createJython.execute();
        
        // Find the input/output proxies from context
        DataProxy<YInputCondition> inputProxy = null;
        DataProxy<YAtomicTask> jythonProxy = null;
        DataProxy<YOutputCondition> outputProxy= null;
        for( YExternalNetElement element : netProxy.getData().getNetElements() ) {
        	if( element instanceof YAtomicTask ) {
                NexusServiceInfo info = WorkflowOperation.getNexusServiceInfoForTask( (YAtomicTask) element );
                if( info != null ) {
                    if( info.getServiceName().equals( "Jython" ) ) {
                        jythonProxy = dataContext.getDataProxy( element, null );
                    }
                }
            }
            else if( element instanceof YInputCondition ) {
                inputProxy = dataContext.getDataProxy( element, null );
            }
            else if( element instanceof YOutputCondition ) {
                outputProxy = dataContext.getDataProxy( element, null );
            }
        }

        assert inputProxy != null : "input proxy was null";
        assert jythonProxy != null : "jython proxy was null";
        assert outputProxy != null : "output proxy was null";
        
        Command flow = new CreateFlowCommand(
                inputProxy,
                jythonProxy,
                null );
        flow.execute();
        
        flow = new CreateFlowCommand(
                jythonProxy,
                outputProxy,
                null );
        flow.execute();
        
        // Get specification and validate
        YSpecification specification = specificationProxy.getData();
        String xml = specification.toXML();
        specification.verify();
	}
}
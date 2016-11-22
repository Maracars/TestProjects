package test.dao.Gate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDaoGate {
	
	DaoGate daoGate = new DaoGate();
	 
	@Test
	public void testInsertGateIntoDB(){
		Gate gate = new Gate();
		
		gate.setGateNumber(3);
		gate.setTerminal(terminal);
		int result = daoGate.insertGate(gate);
		assertEquals("Error insert gate into database",1,result);
	}
	
	@Test
	public void testLoadAllGatesFromOneSpecificTerminal(){
		int terminalId = 1;
		ArrayList<Gate> gateList;
		gateList = daoGate.loadAllGatesFromTerminal(terminalId);
		assertNotNull("Error getting all gates of a terminal from database",gateList);
	}
	
	@Test
	public void testRemoveOneSpecificGate(){
		Gate gate = new Gate();
		gate.setGateId(1);
		int result = daoGate.removeGate(gate.getGateId); //aukeran Gate bidaldu edo gateId
		assertEquals("Error removing one gate from database",1,result);
	}

}

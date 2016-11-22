package test.dao.Terminal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import test.dao.Gate.ArrayList;
import test.dao.Gate.DaoGate;
import test.dao.Gate.Gate;
import test.dao.Gate.Terminal;

public class TestDaoTerminal {

	DaoTerminal daoTerminal;
	
	@Before
	public void setup() {
		daoTerminal = new DaoTerminal();
	}

	@Test
	public void testInsertGateIntoDB() {
		Terminal terminal = new Terminal();
		terminal.setName(3);
		int result = daoTerminal.insertTerminal(terminal);
		assertEquals("Error insert terminal into database", 1, result);
	}

	@Test
	public void testLoadAllTerminalsFromOneSpecificAirport() {
		int airportId = 1;
		ArrayList<Terminal> terminalList;
		terminalList = daoTerminal.loadAllGatesFromTerminal(airportId);
		assertNotNull("Error getting all terminals of an airport from database", terminalList);
	}


	@Test
	public void testRemoveOneSpecificTerminal() {
		Terminal terminal = new Terminal();
		terminal.setTerminalId(1);
		int result = daoTerminal.removeGate(terminal.getTerminalId()); // aukeran Terminal bidaldu edo terminalId
		assertEquals("Error removing one terminal from database", 1, result);
	}

}

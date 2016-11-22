package test.dao.State;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.State.DAOState;
import model.State.State;

public class TestDaoState {


	@Test
	public void testInsertStateIntoDB() {
		State state = new State();
		state.setName("Euskal Herria");
		boolean result = DAOState.insertState(state);
		assertEquals("Error insert gate into database", true, result);
	}
	@Test
	public void testInsertStateIntoDBSendingNullAsParameter() {
		assertEquals("Error insert gate into database", false, DAOState.insertState(null));
	}

	

	@Test
	public void testRemoveOneSpecificState() {
		State state = new State();
		state.setId(1);
		boolean result = DAOState.deleteState(state);
		assertEquals("Error removing one gate from database", true, result);
	}
	@Test
	public void testRemoveOneSpecificStateSendingNullAsParameter() {

		assertEquals("Error removing one gate from database", false, DAOState.deleteState(null));
	}

}

package test.dao.City;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import dao.City.DAOCity;
import dao.Terminal.DAOTerminal;
import model.City.City;
import model.State.State;

public class TestDaoCity {

	@Test
	public void testInsertCityWithoutIntoDB() {
		City city = new City();
		city.setName("Bergara");
		boolean result = DAOCity.insertCity(city);
		assertEquals("Error insert city into database", false, result);
	}
	
	@Test
	public void testInsertCityWithStateIntoDB() {
		State state = new State();
		state.setName("Euskal herria");
		City city = new City();
		city.setName("Bergara");
		city.setState(state);
		boolean result = DAOCity.insertCity(city);
		assertEquals("Error insert city into database", true, result);
	}
	@Test
	public void testInsertNullTerminalIntoDB() {
		assertEquals("Error insert city into database", false, DAOTerminal.insertTerminal(null));
	}


	@Test
	public void testRemoveOneSpecificTerminal() {
		City city = new City();
		city.setId(1);
		boolean result = DAOCity.deleteCity(city); // aukeran Terminal bidaldu edo terminalId
		assertEquals("Error removing one city from database", true, result);
	}
	@Test
	public void testRemoveOneNullTerminal() {
		assertEquals("Error removing one city from database", false, DAOCity.deleteCity(null));
	}

}

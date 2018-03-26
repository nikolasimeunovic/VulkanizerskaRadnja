/**
 * 
 */
package gume;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Nikola Simeunovic
 *
 */
public class AutoGumaTest {
	
	private AutoGuma ag;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ag = new AutoGuma();
	}
		
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ag = null;
	}

	/**
	 * Test method for {@link gume.AutoGuma#setMarkaModel(java.lang.String)}.
	 */
	@Test
	public void testSetMarkaModel() {
		ag.setMarkaModel("Pirelli");
		
		assertEquals("Pirelli", ag.getMarkaModel());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMarkaModelKratkoIme() {
		ag.setMarkaModel("P");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMarkaModelNullString() {
		ag.setMarkaModel(null);
	}

	/**
	 * Test method for {@link gume.AutoGuma#setPrecnik(int)}.
	 */
	@Test
	public void testSetPrecnik() {
		ag.setPrecnik(17);
		
		assertEquals(17, ag.getPrecnik());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrecnikManji() {
		ag.setPrecnik(7);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrecnikVeci() {
		ag.setPrecnik(27);
	}

	/**
	 * Test method for {@link gume.AutoGuma#setSirina(int)}.
	 */
	@Test
	public void testSetSirina() {
		ag.setSirina(150);
		
		assertEquals(150, ag.getSirina());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetSirinaManje() {
		ag.setSirina(100);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetSirinaVece() {
		ag.setSirina(500);
	}
	/**
	 * Test method for {@link gume.AutoGuma#setVisina(int)}.
	 */
	@Test
	public void testSetVisina() {
		ag.setVisina(50);
		
		assertEquals(50, ag.getVisina());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetVisinaManje() {
		ag.setVisina(20);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetVisinaVise() {
		ag.setVisina(100);
	}

	/**
	 * Test method for {@link gume.AutoGuma#toString()}.
	 */
	@Test
	public void testToString() {
		ag.setMarkaModel("Tigar");
		ag.setPrecnik(15);
		ag.setSirina(200);
		ag.setVisina(95);
		
		assertEquals("AutoGuma [markaModel=Tigar, precnik=15, sirina=200, visina=95]", ag.toString());
	}
	@Test
	public void testEqualsObjectTrue() {
		ag.setMarkaModel("Pirelli");
		ag.setPrecnik(15);
		ag.setSirina(200);
		ag.setVisina(95);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Pirelli");
		ag2.setPrecnik(15);
		ag2.setSirina(200);
		ag2.setVisina(95);
		
		assertTrue(ag.equals(ag2));
	}
	
	@Test
	public void testEqualsObjectFalse() {
		ag.setMarkaModel("Mercedes");
		ag.setPrecnik(15);
		ag.setSirina(200);
		ag.setVisina(95);
	
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("BMW");
		ag2.setPrecnik(18);
		ag2.setSirina(200);
		ag2.setVisina(80);
	
		assertFalse(ag.equals(ag2));
	}
	
	
	

}

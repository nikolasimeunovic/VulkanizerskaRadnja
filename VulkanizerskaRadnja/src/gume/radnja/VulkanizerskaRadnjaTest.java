/**
 * 
 */
package gume.radnja;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gume.AutoGuma;

/**
 * @author Nikola
 *
 */
public class VulkanizerskaRadnjaTest {

	
	private VulkanizerskaRadnja v;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		v = new VulkanizerskaRadnja();	
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		v = null;
	}

	/**
	 * Test method for {@link gume.radnja.VulkanizerskaRadnja#dodajGumu(gume.AutoGuma)}.
	 */
	@Test
	public void testDodajGumu() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Tigar");
		ag.setPrecnik(20);
		ag.setSirina(150);
		ag.setVisina(80);
		
		v.dodajGumu(ag);
		
		assertEquals(ag,v.gume.getFirst());
	}
	
	@Test (expected = java.lang.NullPointerException.class)
	public void testDodajGumuNull() {
		v.dodajGumu(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajGumuContains() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Tigar");
		ag.setPrecnik(20);
		ag.setSirina(150);
		ag.setVisina(80);
		
		v.dodajGumu(ag);
		v.dodajGumu(ag);
	}
	/**
	 * Test method for {@link gume.radnja.VulkanizerskaRadnja#pronadjiGumu(java.lang.String)}.
	 */
	@Test
	public void testPronadjiGumu() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Tigar");
		
		v.dodajGumu(ag);
		assertEquals(ag,v.pronadjiGumu("Tigar").getFirst());
	}
	
	@Test (expected = java.lang.NullPointerException.class)
	public void pronadjiGumuNull() {		
		v.pronadjiGumu(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void pronadjiGumuNePostoji() {	
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("Tigar");
		
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("Pirelli");
		
		v.dodajGumu(a);
		v.dodajGumu(a2);
		
		v.pronadjiGumu("Mercedes");
	}
	
	@Test 
	public void pronadjiGumuRazliciteDimenzije() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("Tigar");
		a.setPrecnik(20);
		a.setSirina(150);
		a.setVisina(80);
		
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("Tigar");
		a2.setPrecnik(19);
		a2.setSirina(151);
		a2.setVisina(79);
		
		v.dodajGumu(a);
		v.dodajGumu(a2);
		
		assertTrue(v.pronadjiGumu("Tigar").get(0).equals(a2) && 
				v.pronadjiGumu("Tigar").get(1).equals(a));
	
}

}

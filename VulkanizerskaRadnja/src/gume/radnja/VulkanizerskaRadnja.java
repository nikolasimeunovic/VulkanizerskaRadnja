package gume.radnja;

import java.util.LinkedList;
import gume.AutoGuma;
/**
 * Klasa koja opisuje vulkanizersku radnju
 * 
 * @author Nikola Simeunovic
 * @version 1.0
 */
public class VulkanizerskaRadnja {

	/**
	 * Lista automobilskih guma
	 */
	private LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();
	
	/**
	 * Dodaje gumu na pocetak liste gume.
	 * 
	 * @param aa- objekat klase AutoGuma
	 * @throws java.lang.RuntimeException ako je unet:
	 * <ul>
	 *		<li>null</li>
	 *		<li>objekat koji vec postoji u listi gume</li>
	 * </ul>
	 */
	public void dodajGumu(AutoGuma a) {
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		
		gume.addFirst(a);
	}
	
	/**
	 * Pronalazi i vraca gumu po nazivu marke modela.
	 * 
	 * @param markaModel- naziv marke modela koji se trazi
	 * @return
	 * <ul>
	 *		<li>null, ako je uneta marka modela null</li>
	 *		<li>novaLista, u suprotnom</li>
	 * </ul>
	 */
	public LinkedList<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			return null;
		LinkedList<AutoGuma> novaLista = new LinkedList<AutoGuma>();
			for(int i=0;i<gume.size();i++)
				if (gume.get(i).equals(markaModel))
					novaLista.add(gume.get(i));
		
		return novaLista;
	}

}

/**
 * 
 */
package curso.repaso.basico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class HashMapPersonaPersona {
	//recibo un hashmap que tiene clave y valor
	//ordeno los valores
	//en hashmap el metodo.values y lo meto en una lista
	//ordeno la lista
	//recorro esa coleccion y los meto en un Linkedhashmap que
	//respeto el orden de insersion
	//
	
	public HashMap<Persona, Persona> ordenarHMPP(HashMap<Persona, Persona> hm){
		HashMap<Persona, Persona> respuesta = null;
		//valores del hashmap que recibo
		ArrayList<Persona> valorhm =(ArrayList<Persona>)hm.values();
		//ordeno los valores
		Collections.sort(valorhm);
		
		TreeMap<Persona, Persona> tm = new TreeMap<Persona, Persona>();
		tm.putAll(hm);
		LinkedHashMap<Persona,Persona> lhm = new LinkedHashMap<Persona,Persona>();
		lhm.putAll(tm);
		
		
		
		return respuesta;
		
	
		
	}
	
	
	
}

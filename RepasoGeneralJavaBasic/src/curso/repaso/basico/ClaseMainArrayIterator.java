/**
 * 
 */
package curso.repaso.basico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import curso.repaso.excepciones.InsertarPersonaException;
import curso.repaso.excepciones.NotaException;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ClaseMainArrayIterator {

	/**
	 * @param args
	 * @throws InsertarPersonaException 
	 * @throws NotaException 
	 */
	public static void main(String[] args) throws InsertarPersonaException, NotaException {
		// TODO Auto-generated method stub
		
		
		Persona p1 = new Persona("alb", 30);
		Persona p2 = new Persona("mik", 28);
		Persona p3 = new Persona("tam", 27);
		
		//usando Array list
		//ArrayList<Persona> alp = new ArrayList<Persona>();
		
		//usando iterator
		
		ListaPersonas lp = new ListaPersonas();
		lp.mostrar();
		try{
			lp.insertarPersona(p1);
			}catch (InsertarPersonaException e){
			}catch (NullPointerException n){}
		lp.mostrar();
		try{
			lp.insertarPersona(p2);
			}catch (InsertarPersonaException e){
			}catch (NullPointerException n){}
		try{
			lp.insertarPersona(p3);
			}catch (InsertarPersonaException e){
			}catch (NullPointerException n){}
		lp.mostrar();
		Iterator<Persona> ip = lp.iterator();
		
		while(ip.hasNext()){
			ip.next().toString();
		}
		Persona p = new Persona("kk", 999);
		Map <String, Persona> mapaPersonas = new HashMap<String, Persona>();
		mapaPersonas.put(p.getNombre(),p);
		
		System.out.println(mapaPersonas);
		p = new Persona("kk", 100005);
		mapaPersonas.put(p.getNombre()+"xxx",p);
		System.out.println(mapaPersonas.toString());
		
		//MapToString mts = new MapToString(mapaPersonas);
		//System.out.println(mts);
		
		
		Alumno a1 = new Alumno("alb", 30, 9);
		Alumno a2 = new Alumno("mik", 28, 10);
		Alumno a3 = new Alumno("iña", 35, 4);//A sugerencia de tamara!!! xD
		Alumno a4 = new Alumno("Tama", 28, 8);
		TreeMap<Integer , Persona> tmmp = new TreeMap<>();
		tmmp.put(a1.getNota(),a1);
		tmmp.put(a2.getNota(),a2);
		tmmp.put(a3.getNota(),a3);
		tmmp.put(a4.getNota(),a4);
		
		System.out.println(tmmp);
		
		LinkedHashMap<Integer, Persona> lhmmp = new LinkedHashMap<>();
		lhmmp.put(a1.getNota(),a1);
		lhmmp.put(a2.getNota(),a2);
		lhmmp.put(a3.getNota(),a3);
		lhmmp.put(a4.getNota(),a4);
		
		System.out.println(lhmmp);
		
	}

}

/**
 * 
 */
package curso.repaso.basico;

import java.io.IOException;
import java.util.ArrayList;

import curso.repaso.excepciones.InsertarPersonaException;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ClaseMainRepaso {

	/**
	 * @param args
	 * @throws InsertarPersonaException 
	 * @throws IOException 
	 */
	
	/*public static void mostrarListaPersonas(ArrayList<Persona> ar){
		
		
		
	}*/
	
	public static void main(String[] args) throws InsertarPersonaException, IOException {
		// TODO Auto-generated method stub
		ListaPersonas lp = new ListaPersonas();
		Persona p = new Persona("kk", 21);
		
		lp.mostrar();
		lp.deserializar();
		lp.mostrar();
		System.out.println("sssxxxxssss");
		lp.insertarPersona(p);
		lp.mostrar();
		lp.insertarPersona(p);
		lp.mostrar();
		lp.eliminarPersona(p);
		lp.mostrar();
		lp.insertarPersona(p);
		lp.mostrar();
		
		ArrayList <Persona> alp= new ArrayList<Persona>();
		
		alp.add(p);
		p = new Persona("alb", 30);
		alp.add(p);
		p = new Persona("mik", 28);
		alp.add(p);
		p = new Persona("tam", 27);
		alp.add(p);
		System.out.println(alp.toString());
		alp.remove(p);
		System.out.println(alp.toString());
		alp.add(p);
		System.out.println(alp.toString());
		System.out.println(lp.serializar());
		
		
		
	}

}

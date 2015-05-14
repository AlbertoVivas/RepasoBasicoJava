/**
 * 
 */
package curso.repaso.basico;

import java.io.IOException;

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
		System.out.println(lp.serializar());
	}

}

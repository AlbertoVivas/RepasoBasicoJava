/**
 * 
 */
package curso.repaso.basico;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author Alberto Vivas 
 */
public class Recorrer implements Iterator<Persona>{
	
	private int puntero;
	private ListaPersonas listaPersona;
	
	
	
	public Recorrer(ListaPersonas listaPersona){
		this.puntero = 0;
		this.listaPersona = listaPersona;
		
		
	}
	/* (non-Javadoc)
	 * @see java.util.Iterator#forEachRemaining(java.util.function.Consumer)
	 */
	@Override
	public void forEachRemaining(Consumer<? super Persona> arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return this.puntero < listaPersona.numeroPersonas();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public Persona next() {
		// TODO Auto-generated method stub
		Persona rpta = null;
		
		rpta = this.listaPersona.getArrayPersonas()[this.puntero];
		puntero++;
		
		return rpta;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		this.listaPersona.eliminarPersona(this.listaPersona.getArrayPersonas()[this.puntero]);
		puntero--;
	}

}

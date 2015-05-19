/**
 * 
 */
package curso.repaso.basico;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class MapToString extends HashMap<String, Persona>{

	String key = null;
	Persona persona = null;
	//private HashMap<String , Persona > hm;
	
	public MapToString(){
		
		super();
		
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractMap#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		//hm.
		String str_dev = "";
		Iterator i = this.entrySet().iterator();
		
		while (i.hasNext())
		{
			str_dev = str_dev + i.next().toString()+"\n";
		}
		return str_dev;
	}
	

}

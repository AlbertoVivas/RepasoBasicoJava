/**
 * 
 */
package curso.repaso.basico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import curso.repaso.excepciones.InsertarPersonaException;



/**
 * @author Alberto Vivas
 *
 * 
 */

//package val.examples.basic;

//import val.examples.basic.exceptions.InsertarPersonaException;

public class ListaPersonas {
	
	public static final int CAPACIDAD = 10;

	//private int personasNoNull = 0;
	
	private Persona[] array_personas;
	
	
	/**
	 * Es muy posible que haga falta añadir algún campo más
	 */
	
	public ListaPersonas()
	{
		//TODO HAY QUE HACER UN CONSTRUCTOR
		//RECUERDA QUE EL CONSTRUCTOR SIRVE PARA
			//RESERVAR MEMORIA
			//INICIALIZAR EL ESTADO DEL OBJETO Y SUS ATRIBUTOS
		this.array_personas = new Persona [CAPACIDAD];
		
		
	}
	
	public Persona[] getListaPersonas ()
	{//TODO HAY QUE DEVOLVER EL ARRAY DE PERSONAS QUE CONFORMAN LA LISTA
		return this.array_personas;
		}
	
	public Persona buscarPersona (String nombre)
	{   //TODO BUSCAR PERSONA POR NOMBRE Y DEVOLVERLA
		//SI NO ESTÁ, DEVOLVER NULO
		Persona respuesta = null;
		boolean encontrado = false;
		int contador = 0;
		while((numeroPersonas()!= 0)&&(!encontrado)&&(contador < CAPACIDAD)){
			if(nombre.equals(array_personas[contador].getNombre())){
				encontrado = true;
				respuesta = array_personas[contador];
			}
			contador++;
		}
		return respuesta;
	}
	
	public Persona buscarPersona (int edad)
	{
		//TODO BUSCAR PERSONA POR EDAD Y DEVOLVERLA
		//SI NO ESTÁ, DEVOLVER NULO
		Persona respuesta = null;
		boolean encontrado = false;
		int contador = 0;
		while((numeroPersonas()!= 0)&&(!encontrado)&&(contador < this.array_personas.length)){
			if(edad==(array_personas[contador].getEdad())){
				encontrado = true;
				respuesta = array_personas[contador];
			}
			contador++;
		}
		return respuesta;
	}
	
	public boolean serializar () throws IOException
	{
		//Hacer uso del fichero de propiedades serializa.properties, 
		//para obtener de él el valor de la clave destino, 
		//que representa el nombre del fichero de salida
		boolean respuesta = false;
		FileInputStream fis = new FileInputStream("serializa.properties");
		Properties properties = new Properties();
		
		ObjectOutputStream oos = null;
		File file = null;
		try{
		properties.load(fis);//cargo las propiedades de serializa	
		file = new File(properties.getProperty("destino"));
		file.createNewFile();
		oos = new ObjectOutputStream(new FileOutputStream(properties.getProperty("destino")));
		oos.writeObject(array_personas);
		respuesta = true;
		}catch (Exception e ){
			System.out.println("Error al escribir el fichero "+properties.getProperty("destino"));
		}finally{
			oos.close();
		}
		return respuesta;
	}
	/**
	 * Con este metodo, recupero las personas que estan almacenadas en un 
	 * archivo, el cual viene dado por properties
	 * @return
	 * @throws IOException 
	 */
	public boolean deserializar() throws IOException
	{
		boolean respuesta = false;
		FileInputStream fis = new FileInputStream("serializa.properties");
		Properties properties = new Properties();
		
		ObjectInputStream ois = null;
		File file = null;
		try
		{
			
			properties.load(fis);//cargo las propiedades de serializa	
			file = new File(properties.getProperty("destino"));
			file.createNewFile();
			ois = new ObjectInputStream(new FileInputStream(properties.getProperty("destino")));
			this.array_personas =(Persona [])ois.readObject();
			respuesta = true;
		}
		catch (Exception e )
		{
			System.out.println("Error al escribir el fichero "+properties.getProperty("destino"));
		}
		finally
			{
				ois.close();
			}
		return respuesta;	
	}
	
		
	
	public void insertarPersona (Persona p) throws InsertarPersonaException
	{//no se puede insertar una persona si es igual
		if (!estaLlena()){//si tengo espacio para insertar	
			if(numeroPersonas()!=0){
				if(buscarPersona(p.getNombre())== null) {
					System.out.println("num de per "+numeroPersonas() );
					array_personas[numeroPersonas()]=p;
				
				}else{
					System.out.println("Ya existe esa persona");
				}
			}else{
				array_personas[0]=p;
			}
		}else{
			System.out.println("Capacidad limite alcanzada!!!");
			throw new InsertarPersonaException();
		}
		
		
		
	}
	
	public int numeroPersonas()
	{
		int respuesta = 0;
		for (int i = 0; i < CAPACIDAD; i++) {
			if(this.array_personas[i]!=null){
				respuesta++;
			}
		}
		return respuesta;
	}
	
	public boolean estaLlena()
	{
		return numeroPersonas()==CAPACIDAD;
	}
	
	public void mostrar()
	{
		//TODO MOSTRAR LA LISTA DE PERSONAS
		// pista: ayudarse del método toString de persona
		if (numeroPersonas()>0)
		for (int i = 0; i < numeroPersonas(); i++) {
			System.out.println("Persona("+(i+1)+"): "+array_personas[i].toString());
		}else{
			System.out.println("No hay personas que mostrar");
		}
	}
	public void eliminarPersona(Persona p){
		int posicionBorrar = -1;
		int contador = 0;
		int numPer =numeroPersonas();
		
		System.out.println(!buscarPersona(p.getNombre()).getNombre().equals(null));
		
		if(numPer!=0){
			if(!(buscarPersona(p.getNombre()).getNombre().equals(null))){
			
				while ((posicionBorrar ==-1)&&(contador < CAPACIDAD)) {
					if(p.getNombre().equals(array_personas[contador].getNombre())){
						posicionBorrar = contador;	
					}	
					contador++;
				}
				if (posicionBorrar == -1){
					System.out.println("El nombre no existe!!!");
				}else{
					int j=0;
					for (int i = 0; i < CAPACIDAD; i++) {
						if(i!=posicionBorrar){
							array_personas[j]=array_personas[i];
							j++;
						}	
					}
					array_personas[numPer]=null;
				}	
				
				
			}else{
				System.out.println("No se puede borrar una persona que no existe");
			}	
		}else{
			System.out.println("No hay personas que borrar");
		}
		
	}
		
}


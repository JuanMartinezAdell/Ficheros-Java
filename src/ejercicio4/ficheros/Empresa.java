/**
 * 
 */
package ejercicio4.ficheros;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ejercicio3.ficheros.Gamer;

/**
 * @author Juan
 *
 */
public class Empresa {
	
	private List<Empleado> empleados;
    private String nombre;
	
    
    /**
	 * 
	 */
	public Empresa() {
		this.empleados = new ArrayList<>();
	}


	/**
	 * @param empleados
	 * @param nombre
	 */
	public Empresa( String nombre) {
		this();
		this.nombre = nombre;
	}


	public List<Empleado> getEmpleados() {
		return empleados;
	}



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\tNombre empresa: \n");
		builder.append(nombre);
		for(Empleado e : this.empleados)
			builder.append(empleados);
		return builder.toString();
	}
    
	public boolean addEmpleado(Empleado e) {
		 if(!empleados.contains(e))  {
	            empleados.add(e);
	            return true;
	        } else {
	            return false;
	        }
	}
	
	public void cargarCVS() {
		
		
		//Leer el fichero empleados.cvs y cargaremos los empleados en Empleado
		try {
			Path fichero = Paths.get("empleados.csv");    
					
			 if (Files.exists(fichero)) {
		    		Files.lines(fichero)   //Stream<String> 
						.sorted()
						.map(l -> Arrays.asList(l.split(",")) )  //List<String> cada línea
						.forEach( lista -> {
							Empleado empleado = new Empleado(/*Integer.parseInt(lista.get(0)),*/ lista.get(1),lista.get(2), lista.get(3), lista.get(4),Integer.parseInt(lista.get(5)) ); 
							this.addEmpleado(empleado);							});				
				}
			} catch(IOException ex) {
				System.out.println("El fichero no existe");
				ex.printStackTrace();
			}	
	}
	
	public void grabarCVS( ) {
		
		try {
			Path fichero = Paths.get("empleados.csv");
			BufferedWriter bw = Files.newBufferedWriter(fichero, 
					Charset.forName("UTF-8"), StandardOpenOption.CREATE);
			
			for(Empleado e : empleados) {
				bw.write(e.getId() + "," + e.getNombre()+ "," + e.getApellidos()+ "," + e.getEmail()+ "," + e.getGenero()+ "," + e.getSalario());
				bw.newLine();
			}
			
			bw.close();
					
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
    
	public void mostrarEmpleados() {
		
		empleados.stream()
		.sorted(Comparator.comparing(Empleado::getApellidos))
		.collect(Collectors.toList());
		
	}
	
    

}

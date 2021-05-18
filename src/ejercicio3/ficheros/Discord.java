/**
 * 
 */
package ejercicio3.ficheros;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

/**
 * @author Juan
 *
 */
public class Discord {
	
	private List<Gamer> gamers;
	

	/**
	 * @param gamer
	 */
	public Discord( ) {
	
		this.gamers  = new ArrayList<>();
	}



	public List<Gamer> getGamer() {
		return gamers;
	}
    
	
	public boolean addGamer(Gamer g) {
		 if(!gamers.contains(g))  //No añadimos repetidos. Para la busqueda binaria
	            return gamers.add(g);
	            
		 return false;
		//Ordenamos la lista cada vez que añado un elmemto
		//Collections.sort(gamers);
		 
	}
	
	public boolean removeGamer(Gamer g) {
		return gamers.remove(g);
	}
	
	
	/**
	 * Graba todo el fichero machacando lo que había
	 */
	public void grabar() {
		try {
			Path fichero = Paths.get("gamers.txt");
			BufferedWriter bw = Files.newBufferedWriter(fichero, 
					Charset.forName("UTF-8"), StandardOpenOption.CREATE);
			
			for(Gamer g : gamers) {
				bw.write( g.getNick() + ";" + g.getEmail() + ";" + g.getJuego()+ ";" + g.getNivel());
				bw.newLine();
			}
			
			bw.close();
					
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	/**
	 * Carga los jugadores del fichero jugadores.txt
	 */
	public void loadJuagadores() {
		//Leer el fichero jugadores.txt y cargaremos los contactos en Gamer
		try {
			Path fichero = Paths.get("gamers.txt");
			
			if (Files.exists(fichero)) {
				Files.lines(fichero)   //Stream<String> 
					.sorted()
					.map(l -> Arrays.asList(l.split(";")) )  //List<String> cada línea
					.forEach( lista -> {
						Gamer gamer = new Gamer(lista.get(0), lista.get(1),lista.get(2), lista.get(3)); 
						this.addGamer(gamer);
					});				
			}
		} catch(IOException ex) {
			System.out.println("El fichero no existe");
			ex.printStackTrace();
		}	
		
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Juagadores: \n");
		for(Gamer g : this.gamers)
			builder.append(gamers);
		return builder.toString();
	}
	
	public Object findGamer(String nick) {
		
		for(Gamer g : gamers) 
			if(g.getNick().contains(nick))
				return g;

		return "No existe!!";
	}
	
	/*public Gamer findGamer(String nick) {
		
		//Le paso la lista y un objeto publicacion y busca por el equals
		int posicion = Collections.binarySearch(gamers, new Gamer(nick, " ", " ", " "));
		if (posicion >= 0)
			return gamers.get(posicion);


		return null;
	}*/
	

}















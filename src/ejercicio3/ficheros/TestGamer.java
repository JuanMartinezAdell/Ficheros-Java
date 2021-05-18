/**
 * 
 */
package ejercicio3.ficheros;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

/**
 * @author Juan
 *
 */
public class TestGamer {
	
	public static void main(String[] args) {
		
		
		Discord fich = new Discord();
		fich.loadJuagadores(); 
		int op= -1;
		
		do {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\t//----------------Jugadores--------------//");
			System.out.println("\t 1.Añadir jugador");
			System.out.println("\t 2.Eliminar jugador");
			System.out.println("\t 3.Buscar jugador");
			System.out.println("\t 4.Listar");
			System.out.println("\t 5.Salir");
			op=Integer.parseInt(sc.nextLine());
			
			switch(op){
				case 1:{
					
					int opci= -1;
					
					System.out.println("Dame nick: ");
					String nick = sc.nextLine();
					System.out.println("Dame email: ");
					String email = sc.nextLine();
					System.out.println("Dame juego: ");
					String juego = sc.nextLine();
					
					System.out.println("\tDame el nivel: ");
					System.out.println("\t 1.DIOS");
					System.out.println("\t 2.MAQUINA");
					System.out.println("\t 3.BUENO");
					System.out.println("\t 4.NORMAL");
					System.out.println("\t 5.REGULAR");
					System.out.println("\t 6.PAQUETE");
					opci=Integer.parseInt(sc.nextLine());
					Nivel niveles = null;
					
					switch(opci) {
						case 1:
							niveles=Nivel.DIOS;
							niveles.toString();
							break;
						case 2:
							niveles=Nivel.MAQUINA;
							niveles.toString();
							break;
						case 3:
							niveles=Nivel.BUENO;
							niveles.toString();
							break;
						case 4:
							niveles=Nivel.NORMAL;
							niveles.toString();
							break;
						case 5:
							niveles=Nivel.REGULAR;
							niveles.toString();
							break;
						case 6:
							niveles=Nivel.PAQUETE;
							niveles.toString();
							break;
						
						default:
							throw new IllegalArgumentException("Unexpected value: " + opci);
					}
					
					if(fich.addGamer(new Gamer( nick, email, juego, niveles.toString())))           
					  System.out.println("El jugador se ha añadido con exito");
					else
						System.out.println("El jugador ya existe");
					break;
				}
				case 2:{ 
					System.out.println("Dame la direccion de coreo: ");
					String correo = sc.nextLine();
					if(fich.getGamer().remove(new Gamer(" ", correo, " ", " "))) { //Borra en memoria
						System.out.println("Borrado!");	
						fich.grabar(); 
					}else {
						System.out.println("El jugador no existe!");
					}
					break;
				}
				case 3:{ 
					System.out.println("Intorduce el Nick a buscar: ");
					String nic = sc.nextLine();
					
					System.out.println(fich.findGamer(nic));
					
					
					break;
				}
				case 4:{
					
					fich.getGamer().sort( (g1,g2) -> g1.getNick().compareTo(g2.getNick()) );
					for(Gamer f : fich.getGamer()) {
						System.out.println(f);
					}
					break;
				}
				case 5:{ 
					    System.out.print("Has salido del programa");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + op);
			}
			
			
		}while(op!=5);
		fich.grabar();
	}

}

/**
 * 
 */
package ejercicio4.ficheros;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

import ejercicio3.ficheros.Gamer;
import ejercicio3.ficheros.Nivel;

/**
 * @author Juan
 *
 */
public class TestEmpresa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empresa empres = new Empresa();
		empres.cargarCVS();
		
		Scanner sc = new Scanner(System.in);
		int opcion = -1;
		do {
			
			System.out.println("0.Salir");
			System.out.println("1.Listar empleados");
			System.out.println("2.Añadir empleado");
			System.out.println("3.Listar empleado por apellido");
			System.out.println("4.Listar empleado por salario");
			System.out.println("5.Listar jefes");
			System.out.println("6.Listar mujeres");
			System.out.println("7.Grabar");
			
			opcion=Integer.parseInt(sc.nextLine());
			int id;
			int salario;
			
			switch (opcion) {
				case 1: {
					empres.getEmpleados().sort( (e1,e2) -> e1.getApellidos().compareTo(e2.getApellidos()) );
					for(Empleado e : empres.getEmpleados()) {
						System.out.println(e);
					}
					
					
					
					break;
				}
				case 2: {
					
				    int opci=-1;
			
					System.out.println("Dame nombre: ");
					String nombre = sc.nextLine();
					System.out.println("Dame apellidos: ");
					String apellidos = sc.nextLine();
					System.out.println("Dame email: ");
					String email = sc.nextLine();
					
					System.out.println("Dame genero: ");
					String genero =sc.nextLine();
					/*System.out.println("\t 1.MASCULINO");
					System.out.println("\t 2.FEMENINO");
					opci=Integer.parseInt(sc.nextLine());
					Genero genero = null;*/
					
					/*switch(opci) {
						case 1:
							genero=Genero.MASCULINO;
							//genero.toString();
							break;
						case 2:
							genero=Genero.FEMENINO;
							//genero.toString();
							break;
							
						default:
							throw new IllegalArgumentException("Unexpected value: " + opci);
					}*/
					
					System.out.println("Dame salario: ");
					salario = Integer.parseInt(sc.nextLine());
					
					empres.addEmpleado(new Empleado( nombre, apellidos, email, genero, salario));  //Añade en memoria
					
					break;
					
				} 
				case 3: {
					
					break;
				}
				
				case 4:{
					
				break;
				}
				case 5:{
					
				break;	
				}
				case 6:{
					
				break;	
				}
				case 7:{
					empres.grabarCVS( );
				break;	
				}
			}
			
		} while (opcion != 0);
		
		
		
	}

}

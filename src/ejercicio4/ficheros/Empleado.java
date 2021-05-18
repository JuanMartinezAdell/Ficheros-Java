/**
 * 
 */
package ejercicio4.ficheros;

/**
 * @author Juan
 *
 */
public class Empleado {
	
	private static int idEm;
	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private String genero;
	private double salario;
	
	
	
	/**
	 * 
	 */
	public Empleado() {
		super();
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param genero
	 * @param salario
	 */
	public Empleado( String nombre, String apellidos, String email, String genero, int salario) {
		super();
		this.id = ++idEm;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.genero = genero;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("\n\t--Empleado " + id + "--\n" );
		builder.append("\t\n idEmpleado= ");
		builder.append(id);
		builder.append("\t\n nombre= ");
		builder.append(nombre);
		builder.append("\t\n apellidos= ");
		builder.append(apellidos);
		builder.append("\t\n email= ");
		builder.append(email);
		builder.append("\t\n genero= ");
		builder.append(genero);
		builder.append("\t\n salario= ");
		builder.append(salario);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
	
	

}

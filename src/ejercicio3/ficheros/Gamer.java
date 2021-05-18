/**
 * 
 */
package ejercicio3.ficheros;

/**
 * @author Juan
 *
 */
public class Gamer {
	
	private String nivel;
	private String nick;
	private String email;
	private String juego;
	/**
	 * 
	 */
	public Gamer() {
		
	}
	

	/**
	 * @param nivel
	 * @param nick
	 * @param email
	 * @param juego
	 */
	public Gamer(  String nick, String email, String juego, String nivel) { 
		
		
		this.nick = nick;
		this.email = email;
		this.juego = juego;
		this.nivel = nivel;
		
		
	}
	

	public String getNick() {
		return nick;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("\t--Jugador--\n");
		builder.append("\nNick del jugador= ");
		builder.append(nick);
		builder.append("\nemail= ");
		builder.append(email);
		builder.append("\njuego= 4\n");
		builder.append(juego);
		builder.append("\nNivel= ");
		builder.append(nivel);
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
		Gamer other = (Gamer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	

	
	
	
	
}

package ejercicio4.ficheros;

public enum Genero {
	
	FEMENINO("Female"),
	MASCULINO("Male");
	
    public String genero;
	
	
	private Genero(String genero){
	  
		this.genero = genero;
	}
	
	public String getGenero(){
		return genero;
	}
	
	
	@Override
	public String toString() {
	     return this.genero;
	}
	
	

}

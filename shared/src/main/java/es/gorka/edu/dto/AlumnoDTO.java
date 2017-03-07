package es.gorka.edu.dto;

import org.springframework.stereotype.Component;

@Component
public class AlumnoDTO implements IEntityDTO{
	
	private String alumno;
	private String bocadillo;
	private String naranja;
	
	public String getAlumno() {
		return alumno;
	}
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	public String getBocadillo() {
		return bocadillo;
	}
	public void setBocadillo(String bocadillo) {
		this.bocadillo = bocadillo;
	}
	public String getNaranja() {
		return naranja;
	}
	public void setNaranja(String naranja) {
		this.naranja = naranja;
	}	
}
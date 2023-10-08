package Modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_inscripcion;

	private Carrera idCarrera;

	private Estudiante nroDni;

	private int anioIngreso;

	private int anioEgreso;
	
	

	public Inscripcion() {
	}

	public Inscripcion(int id_inscripcion, Estudiante nroDni, Carrera idCarrera, int anioIngreso) {

		this.id_inscripcion = id_inscripcion;
		this.idCarrera = idCarrera;
		this.nroDni = nroDni;
		this.anioIngreso = anioIngreso;
	}



	public int getIdInscripcion() {
		return id_inscripcion;
	}

	public void setIdInscripcion(int id_inscripcion) {
		this.id_inscripcion = id_inscripcion;
	}


	public Carrera getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Carrera idCarrera) {
		this.idCarrera = idCarrera;
	}

	public Estudiante getNroDni() {
		return nroDni;
	}

	public void setNroDni(Estudiante nroDni) {
		this.nroDni = nroDni;
	}
	public int getAnioIngreso() {
		return anioIngreso;
	}

	public void setAnioEgreso(int anio) {
		this.anioEgreso = anio;
	}
	public int getAnioEgreso() {
		return anioEgreso;
	}

	public String toString() {
		return "Inscripcion [id_inscripcion=" + id_inscripcion + ", antiguedad=" + "idCarrera="
				+ idCarrera + ", nroDni=" + nroDni + ", anioIngreso="
						+ anioIngreso
						+ ", anioEgreso=" + anioEgreso + ",]";
	}
}

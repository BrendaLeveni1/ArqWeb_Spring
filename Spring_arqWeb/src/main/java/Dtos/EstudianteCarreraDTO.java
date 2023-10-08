package Dtos;

import Modelo.Carrera;
import Modelo.Estudiante;
import Modelo.Inscripcion;

public class EstudianteCarreraDTO {
    private Estudiante estudiante;
    private Carrera carrera;
    private Inscripcion inscripcion;

    public EstudianteCarreraDTO() {
        super();
    }
    private int fech;
    public EstudianteCarreraDTO(Carrera carrera,Estudiante estudiante, Inscripcion inscripcion, int fech) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.inscripcion= inscripcion;
        this.fech=fech; //esta fecha se corresponde tanto como ingreso como egreso
    }

    @Override
    public String toString() {
        String carrera = String.format("%1$-20s", this.carrera.getNombre());

        String accionSinFormato="Ingresó ";
        if (this.inscripcion.getAnioIngreso()!=this.fech) accionSinFormato="EGRESÓ";

        String fechaEgres=" En curso";
        if (this.inscripcion.getAnioEgreso()!=0) fechaEgres=" Egresó en: "+this.inscripcion.getAnioEgreso();
        String accion = String.format("%1$-10s", accionSinFormato);

        String nombre=String.format("%1$-30s", (this.estudiante.getNombre()+"~"+this.estudiante.getApellido()));
        return "\n"+ carrera+"Fecha: "+this.fech+" "+ accion+" Nombre: "+nombre+"|"+fechaEgres+ "]";
    }

    public String getNombreCarrera(){
        return this.carrera.getNombre();
    }
    public int getFechaCarrera(){
        return this.inscripcion.getAnioIngreso();
    }
    public int getFech(){
        return this.fech;
    }
 
    
}


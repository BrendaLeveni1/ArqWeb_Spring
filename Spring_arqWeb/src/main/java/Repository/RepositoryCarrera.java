package Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Dtos.CarreraYCantidadDTO;
import Dtos.EstudianteCarreraDTO;
import Modelo.Carrera;

@Repository
public interface RepositoryCarrera extends JpaRepository<Carrera, Long> {

	@Query("SELECT c FROM Carrera c WHERE c.nombre LIKE %:nombre%")
	public Carrera Nombre(String nombre);

	@Query("SELECT NEW Dto.CarreraYCantidadDTO(c , SIZE(c.estudiantes)) FROM Carrera c ORDER BY SIZE(c.estudiantes)")
	List<CarreraYCantidadDTO> listaCarrerasConInscriptos();
	
	
	@Query("SELECT NEW Dto.EstudianteCarreraDTO(c , e, i, i.fecha as fech) FROM Inscripcion i JOIN i.estudiante e JOIN i.carrera c")
	public List<EstudianteCarreraDTO> listaDeIngresos();

	@Query("SELECT NEW Dto.EstudianteCarreraDTO(c , e, i, (i.fecha + i. antiguedad) as fech) FROM Inscripcion i JOIN i.estudiante e JOIN i.carrera c WHERE i.esEgresado = 1")
	public List<EstudianteCarreraDTO> listaDeEgresos();

}

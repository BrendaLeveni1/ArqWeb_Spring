package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Modelo.Carrera;
import Modelo.Estudiante;

public interface RepositoryEstudiante extends JpaRepository<Estudiante,Long>{
	

	@Query("SELECT e FROM Estudiante e WHERE e.genero LIKE %:gen% ORDER BY e.apellido, e.nombre")
	public List<Estudiante> Genero(String gen);
	

	@Query("SELECT e FROM Estudiante e JOIN e.carreras c WHERE c = :carrera AND e.ciudadDeRecidencia LIKE %:ciudad%")
	public List<Estudiante> filtrar(Carrera carrera, String ciudad);
	
	
}

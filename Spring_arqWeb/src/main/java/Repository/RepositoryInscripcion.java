package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Modelo.Inscripcion;
@Repository
public interface RepositoryInscripcion extends JpaRepository<Inscripcion,Long>{

	

	
}
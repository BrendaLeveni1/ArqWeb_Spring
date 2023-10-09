package Controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Dtos.CarreraYCantidadDTO;
import Dtos.EstudianteCarreraDTO;
import Modelo.Carrera;
import Repository.RepositoryCarrera;

@RestController
@RequestMapping("/carrera")
public class CarreraController {
    @Autowired
    private EstudianteRepo estudianteRepo;
    @Autowired
    private RepositoryCarrera repositorio;

    @GetMapping
    public List<Carrera> listarCarreras(){
        return repositorio.findAll();
    }
    
    @GetMapping("/anotados")
    public List<CarreraYCantidadDTO> listarCarrerasConInscriptos() {
        return repositorio.listaCarrerasConInscriptos();
    }
    @GetMapping("/reporte")
    public List<EstudianteCarreraDTO> reportar(){

        List<EstudianteCarreraDTO> listaCarreras=repositorio.listaDeIngresos();
        listaCarreras.addAll(repositorio.listaDeEgresos());
        listaCarreras.sort(Comparator
        .comparing(EstudianteCarreraDTO::getNombreCarrera) 
        .thenComparing(EstudianteCarreraDTO::getFecha)
        );

        return listaCarreras;
    }
    @PostMapping
    public void grabarCarrera(@RequestBody Carrera c){
        repositorio.save(c);
    }

    @DeleteMapping("/{id}")
	public void eliminarCarrera(@PathVariable Long id) {
		RepositoryCarrera.deleteById(id);
	}





}
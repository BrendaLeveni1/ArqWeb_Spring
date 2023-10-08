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
    private RepositoryCarrera repo;

    // @Autowired
    // private EstudianteRepo estudianteRepo;

    @GetMapping
    public List<Carrera> listarCarreras(){
        return repo.findAll();
    }

    @PostMapping
    public void grabarCarrera(@RequestBody Carrera c){
        repo.save(c);
    }

    @GetMapping("/anotados")
    public List<CarreraYCantidadDTO> listarCarrerasConInscriptos() {
        return repo.listaCarrerasConInscriptos();
    }


    // ver este no anda
    @GetMapping("/reporte")
    public List<EstudianteCarreraDTO> reportar(){

        List<EstudianteCarreraDTO> listaCarreras=repo.listaDeIngresos();
        listaCarreras.addAll(repo.listaDeEgresos());
        listaCarreras.sort(Comparator
		.comparing(EstudianteCarreraDTO::getNombreCarrera) 
		.thenComparing(EstudianteCarreraDTO::getFech)
		);


        return listaCarreras;
    }




}
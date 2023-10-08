package Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Modelo.Carrera;
import Modelo.Estudiante;
import Repository.RepositoryCarrera;
import Repository.RepositoryEstudiante;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private RepositoryEstudiante repo;

    @Autowired
    private RepositoryCarrera carreraRepo;

    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Estudiante> estudianteXlibreta(@PathVariable Long id) {
        return repo.findById(id);
    }
    @GetMapping("/g/{genero}")
    public List<Estudiante> Genero(@PathVariable String genero){
        return repo.Genero(genero);
    }

    @PostMapping
    public void grabarEstudiante(@RequestBody Estudiante e) {
        repo.save(e);
    }

    @GetMapping("/{nombre}/{ciudad}")
    public List<Estudiante> filtrar (@PathVariable String nombre, @PathVariable String ciudad){
        System.out.println("busca"+nombre+" "+ciudad);
        Carrera c=carreraRepo.Nombre(nombre);
        System.out.println("carera encontrada "+ c.getNombre());
        return repo.filtrar(c, ciudad);
    }


}
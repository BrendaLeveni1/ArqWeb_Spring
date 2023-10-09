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
    private RepositoryEstudiante repositorio;

    @Autowired
    private RepositoryCarrera repoCarrera;

    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Estudiante> estudianteXlibreta(@PathVariable Long id) {
        return repositorio.findById(id);
    }
    @GetMapping("/g/{genero}")
    public List<Estudiante> Genero(@PathVariable String genero){
        return repositorio.Genero(genero);
    }
    
    @GetMapping("/{nombre}/{ciudad}")
    public List<Estudiante> filtrar (@PathVariable String nombre, @PathVariable String ciudad){
        System.out.println("busca"+nombre+" "+ciudad);
         Carrera c=repoCarrera.Nombre(nombre);
         System.out.println("carera encontrada "+ c.getNombre());
          return repositorio.filtrar(c, ciudad);
    }

    @PostMapping
    public void grabarEstudiante(@RequestBody Estudiante e) {
        repositorio.save(e);
    }
    @DeleteMapping("/{nroDni}")
	public void eliminarEstudiante(@PathVariable Long nroDni) {
	        RepositoryEstudiante.deleteById(nroDni);
	}



}
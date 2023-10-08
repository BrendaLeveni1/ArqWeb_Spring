package Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Modelo.Inscripcion;
import Repository.RepositoryCarrera;
import Repository.RepositoryEstudiante;
import Repository.RepositoryInscripcion;
import Modelo.Carrera;
import Modelo.Estudiante;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {

    @Autowired
    private RepositoryInscripcion repo;

    @Autowired
    private RepositoryEstudiante repoEstudiante;

    @Autowired
    private RepositoryCarrera repoCarrera;

    @GetMapping
    public List<Inscripcion> listarInscriptos() {
        return repo.findAll();
    }

    @PostMapping
    public Inscripcion inscribir(@RequestBody Map<String, Integer> json) {
        Optional<Estudiante> e = repoEstudiante.findById((long) json.get("nroDni"));
        Optional<Carrera> c = repoCarrera.findById((long) json.get("id"));
        Inscripcion i = new Inscripcion((int) json.get("id_inscripcion"),e.get(), c.get(), (int) json.get("anioIngreso") );
        return repo.save(i);
    }
   
}
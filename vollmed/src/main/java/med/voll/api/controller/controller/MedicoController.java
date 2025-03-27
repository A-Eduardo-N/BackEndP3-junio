package med.voll.api.controller.controller;

import med.voll.api.controller.medico.DadosCadastroMedico;
import med.voll.api.controller.medico.DadosListagemMedico;
import med.voll.api.controller.medico.Medico;
import med.voll.api.controller.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }
    @GetMapping
    public List<Medico> listar(){
        return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).tolist;
}
}



package med.voll.api.controller.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Table(name="medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
   @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
   @Embedded
    private Endereco endereco;

   public Medico(DadosCadastroMedico dados){
       this.nome = dados.nome();
       this.email = dados.email();
       this.crm = dados.crm();
       this.especialidade = dados.especialidade();
       this.edereco = new Edereco(dados.endereco());
   }
    @GetMapping
    public List<DadosListagemMedico> listar(){
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
   }

    public String getNome() {
        return null;
    }

    public String getEmail() {
        return null;
    }

    public String getCrm() {
        return null;
    }

    public Especialidade getEspecialidade() {
        return null;
    }
}

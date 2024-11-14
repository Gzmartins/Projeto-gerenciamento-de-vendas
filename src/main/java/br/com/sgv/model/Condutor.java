package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Condutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeCondutor; 
    private String cpfCondutor; 
    private String nomeDono; 
    private LocalDate dataNascimentoCondutor;
    private boolean estuda;
    private boolean garagem;
    private boolean garagemFaculdade;
    private boolean idadeCondutores; 
    private String moradia; 
    private boolean outrosVeiculos; 
    private String portao; 
    private int quantos; 
    private String sexo; 
    private boolean utilizaTrabalho; 
    private String cepPernoite; 
    private String utilizacao; 
}

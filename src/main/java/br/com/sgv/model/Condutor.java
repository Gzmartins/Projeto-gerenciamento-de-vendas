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

    @NotBlank
    private String nomeCondutor; 
    
    @NotBlank
    private String cpfCondutor; 
    private String nomeDono; 
    
    @NotNull
    private LocalDate dataNascimentoCondutor;
    
    private boolean estuda;
    private boolean garagem;
    private boolean garagemFaculdade;
    
    @NotNull
    private boolean idadeCondutores; 
    
    @NotBlank
    private String moradia; 
    
    private boolean outrosVeiculos; 
    private String portao; 
    
    @NotNull
    private int quantos; 
    
    @NotBlank
    private String sexo; 
    
    private boolean utilizaTrabalho; 
    
    @NotBlank
    private String cepPernoite; 
    
    @NotBlank
    private String utilizacao; 
}

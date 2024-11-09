package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo; 
    private int portas; 
    private String cor;
    private String cambio; 
    private String placa;
    private String chassi;
    private int anoModelo; 
    private String combustivel; 
    private String opcionais;
    private boolean financiado; 
    private String danosMateriais; 
    private String danosCorporais; 
    private String franquia;
    private String vigencia;
    private boolean gnv;
    private boolean tabelaFipe;
    private String financeira;
    private String nomeDono;
    private String cpfDono;
}



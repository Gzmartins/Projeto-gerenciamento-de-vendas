package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String rg;
    private String dataExpedicao;
    private String orgao;
    private String cpf;
    private String estadoCivil;
    private String dataNascimento;
    private String cep;
    private String profissao;
}

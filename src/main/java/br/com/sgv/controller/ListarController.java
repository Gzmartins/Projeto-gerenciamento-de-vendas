package br.com.sgv.controller;

import br.com.sgv.model.Cliente;
import br.com.sgv.model.Veiculo;
import br.com.sgv.model.Condutor;
import br.com.sgv.repository.CondutorRepository;
import br.com.sgv.repository.ClienteRepository;
import br.com.sgv.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private CondutorRepository condutorRepository; 

    // Construtor que recebe os repositórios
    public ListarController(ClienteRepository clienteRepository, VeiculoRepository veiculoRepository, CondutorRepository condutorRepository) {
        this.clienteRepository = clienteRepository;
        this.veiculoRepository = veiculoRepository;
        this.condutorRepository = condutorRepository; 
    }

    public void listarDados(String nome) {
        Cliente cliente = clienteRepository.findByNome(nome).orElse(null);
        List<Veiculo> veiculos = veiculoRepository.findByNomeDono(nome);
        List<Condutor> condutores = condutorRepository.findByNomeDono(nome); 

        if (cliente != null) {
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());

            if (!veiculos.isEmpty()) {
                for (Veiculo veiculo : veiculos) {
                    System.out.println("Veículo: " + veiculo.getNomeDono());
                    System.out.println("Placa: " + veiculo.getPlaca()); 
                }
            } else {
                System.out.println("Nenhum veículo encontrado para este CPF.");
            }

            if (!condutores.isEmpty()) {
                for (Condutor condutor : condutores) { 
                    System.out.println("Condutor: " + condutor.getNomeCondutor()); 
                    System.out.println("CPF do Condutor: " + condutor.getCpfCondutor()); 
                }
            } else {
                System.out.println("Nenhum condutor encontrado para este CPF.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}

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
    private CondutorRepository condutorRepository; // Corrigido para CondutorRepository

    // Construtor que recebe os repositórios
    public ListarController(ClienteRepository clienteRepository, VeiculoRepository veiculoRepository, CondutorRepository condutorRepository) {
        this.clienteRepository = clienteRepository;
        this.veiculoRepository = veiculoRepository;
        this.condutorRepository = condutorRepository; // Corrigido para CondutorRepository
    }

    public void listarDados(String nome) {
        // Busca o cliente pelo CPF
        Cliente cliente = clienteRepository.findByNome(nome).orElse(null);
        // Busca os veículos associados ao CPF do cliente
        List<Veiculo> veiculos = veiculoRepository.findByNomeDono(nome);
        // Busca os condutores associados ao CPF do cliente
        List<Condutor> condutores = condutorRepository.findByNomeDono(nome); // Corrigido para condutores

        if (cliente != null) {
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());

            if (!veiculos.isEmpty()) {
                for (Veiculo veiculo : veiculos) {
                    System.out.println("Veículo: " + veiculo.getNomeDono());
                    System.out.println("Placa: " + veiculo.getPlaca()); // Ajuste aqui para usar o atributo correto
                }
            } else {
                System.out.println("Nenhum veículo encontrado para este CPF.");
            }

            if (!condutores.isEmpty()) {
                for (Condutor condutor : condutores) { // Corrigido para iterar sobre condutores
                    System.out.println("Condutor: " + condutor.getNomeCondutor()); // Adicionei a impressão do nome do condutor
                    System.out.println("CPF do Condutor: " + condutor.getCpfCondutor()); // Adicionei a impressão do CPF do condutor
                }
            } else {
                System.out.println("Nenhum condutor encontrado para este CPF.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}

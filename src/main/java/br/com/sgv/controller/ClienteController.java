package br.com.sgv.controller;

import br.com.sgv.model.Cliente;
import br.com.sgv.model.Veiculo; 
import br.com.sgv.model.Condutor;
import br.com.sgv.repository.ClienteRepository;
import br.com.sgv.repository.CondutorRepository;
import br.com.sgv.repository.VeiculoRepository; 
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeiculoRepository veiculoRepository; 
    
    @Autowired
    private CondutorRepository condutorRepository; 

    @GetMapping("/cliente")
    public String listar(Model model) {
        model.addAttribute("listaCliente", clienteRepository.findAll());
        return "gerenciar_cliente";
    }

    @GetMapping("/cliente/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "editar_cliente";
    }

    @GetMapping("/cliente/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "editar_cliente";
        } else {
            model.addAttribute("mensagem", "Cliente não encontrado");
            return "gerenciar_cliente"; // Retorna à lista se não encontrado
        }
    }

    @PostMapping("/cliente")
    public String salvar(@Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_cliente";
        }
        clienteRepository.save(cliente);
        return "redirect:/cliente";
    }

    @DeleteMapping("/cliente/{id}")
    public String excluir(@PathVariable("id") long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }
        return "redirect:/cliente";
    }

    @GetMapping("/cliente/dados")
    public String listarDados(@RequestParam("nome") String nome, Model model) {
        Optional<Cliente> cliente = clienteRepository.findByNome(nome);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            model.addAttribute("veiculos", veiculoRepository.findByNomeDono(nome));
            model.addAttribute("condutores", condutorRepository.findByNomeDono(nome)); 
            return "listar_dados_cliente"; // Exibe os dados do cliente e veículos
        } else {
            model.addAttribute("mensagem", "Cliente não encontrado");
            return "buscar_cliente"; // Redireciona para a página de busca se não encontrado
        }
    }

    @GetMapping("/cliente/buscar")
    public String mostrarPaginaDeBusca() {
        return "buscar_cliente";
    }
}

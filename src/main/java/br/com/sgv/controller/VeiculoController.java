package br.com.sgv.controller;

import br.com.sgv.model.Veiculo;
import br.com.sgv.repository.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping("/veiculo")
    public String listar(Model model) {
        model.addAttribute("listaVeiculo", veiculoRepository.findAll());
        return "gerenciar_veiculo";
    }

    @GetMapping("/veiculo/novo")
    public String novo(Model model) {
        model.addAttribute("veiculo", new Veiculo());
        return "editar_veiculo";
    }

    @GetMapping("/veiculo/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Veiculo veiculo = veiculoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado com ID: " + id));
        model.addAttribute("veiculo", veiculo);
        return "editar_veiculo";
    }

    @PostMapping("/veiculo")
    public String salvar(@Valid @ModelAttribute Veiculo veiculo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editar_veiculo";
        }
        veiculoRepository.save(veiculo);
        model.addAttribute("mensagem", "Veículo salvo com sucesso!");
        return "redirect:/veiculo";
    }

    @DeleteMapping("/veiculo/{id}")
    public String excluir(@PathVariable("id") long id) {
        veiculoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado com ID: " + id));
        veiculoRepository.deleteById(id);
        return "redirect:/veiculo";
    }
}

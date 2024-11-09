package br.com.sgv.controller;

import br.com.sgv.model.Condutor;
import br.com.sgv.repository.CondutorRepository;
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


@Controller
public class CondutorController {

    @Autowired
    private CondutorRepository condutorRepository;

    @GetMapping("/condutor")
    public String listar(Model model) {
        model.addAttribute("listaCondutor", condutorRepository.findAll());
        return "gerenciar_condutor";
    }

    @GetMapping("/condutor/novo")
    public String novo(Model model) {
        model.addAttribute("condutor", new Condutor());
        return "editar_condutor";
    }

    @GetMapping("/condutor/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Condutor> condutor = condutorRepository.findById(id);
        model.addAttribute("condutor", condutor.get());
        return "editar_condutor";
    }

    @PostMapping("/condutor")
    public String salvar(@Valid Condutor condutor, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_condutor";
        }
        condutorRepository.save(condutor);
        return "redirect:/condutor";
    }

    @DeleteMapping("/condutor/{id}")
    public String excluir(@PathVariable("id") long id) {
        condutorRepository.deleteById(id);
        return "redirect:/condutor";
    }
}

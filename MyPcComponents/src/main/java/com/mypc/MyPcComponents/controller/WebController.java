package com.mypc.MyPcComponents.controller;


import com.mypc.MyPcComponents.model.Component;
import com.mypc.MyPcComponents.service.ComponentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller che gestisce le pagine HTML con Thymeleaf.
 */
@Controller
public class WebController {

    private final ComponentService service;

    public WebController(ComponentService service) {
        this.service = service;
    }

    //Home page con lista componenti
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("components", service.findAll());
        return "index";
    }

    //Pagina dettaglio per singolo componente
    @GetMapping("/component/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Component component = service.findById(id)
                .orElseThrow(() -> new RuntimeException("Componente non trovato"));
        model.addAttribute("component", component);
        return "detail";
    }

    //Mostra il form per aggiungere un nuovo componente
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("component", new Component());
        return "add";
    }

    //Gestisce il salvataggio del nuovo componente
    @PostMapping("/add")
    public String addComponent(@ModelAttribute("component") Component component) {
        service.save(component);
        return "redirect:/"; //dopo il salvataggio torna alla home
    }

    //Mostra il form di modifica
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Component component = service.findById(id)
                .orElseThrow(() -> new RuntimeException("Componente non trovato"));
        model.addAttribute("component", component);
        return "edit";
    }

    //Salva le modifiche
    @PostMapping("/edit/{id}")
    public String editComponent(@PathVariable Long id, @ModelAttribute("component") Component component) {
        service.update(id, component);
        return "redirect:/";
    }

    //Elimina un componente
    @GetMapping("/delete/{id}")
    public String deleteComponent(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}


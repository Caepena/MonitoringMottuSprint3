package br.com.fiap.MonitoringMottuSprint3.moto;

import br.com.fiap.MonitoringMottuSprint3.config.MessageHelper;
import br.com.fiap.MonitoringMottuSprint3.usuario.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/moto")
@RequiredArgsConstructor
public class MotoController {

    private final MotoService motoService;
    private final MessageHelper messageHelper;
    private final MessageSource messageSource;
    private final UsuarioService usuarioService;

    @GetMapping
    public String index(Model model) {
        var motos = motoService.getAllMotos();
        model.addAttribute("motos", motos);
        return "index-moto";
    }

    @GetMapping("/form")
    public String motoForm(Moto moto) {
        return "form-moto";
    }

    @PostMapping("/form")
    public String create(@Valid Moto moto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) return "form-moto";

        motoService.save(moto);
        redirectAttributes.addFlashAttribute("message", messageHelper.get("moto.create.success"));
        return "redirect:/moto";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        motoService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", messageHelper.get("moto.delete.success"));
        return "redirect:/moto";
    }
}

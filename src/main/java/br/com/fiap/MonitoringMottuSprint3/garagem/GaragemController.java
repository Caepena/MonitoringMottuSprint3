package br.com.fiap.MonitoringMottuSprint3.garagem;

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
@RequestMapping("/garagem")
@RequiredArgsConstructor
public class GaragemController {

    private final GaragemService garagemService;
    private final MessageSource messageSource;
    private final MessageHelper messageHelper;
    private final UsuarioService usuarioService;

    @GetMapping
    public String index(Model model) {
        var garagens = garagemService.getAllGaragens();
        model.addAttribute("garagens", garagens);
        return "index";
    }

    @GetMapping("/form")
    public String form(Garagem garagem) {
        return "form-garagem";
    }

    @PostMapping("/form")
    public String create(@Valid Garagem garagem, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) return "form-garagem";

        garagemService.save(garagem);
        redirectAttributes.addFlashAttribute("message", messageHelper.get("garagem.create.success"));
        return "redirect:/garagem";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        garagemService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", messageHelper.get("garagem.delete.success"));
        return "redirect:/garagem";
    }
}

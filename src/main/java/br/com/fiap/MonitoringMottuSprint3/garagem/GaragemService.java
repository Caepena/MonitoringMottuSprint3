package br.com.fiap.MonitoringMottuSprint3.garagem;

import br.com.fiap.MonitoringMottuSprint3.config.MessageHelper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GaragemService {

    private final GaragemRepository garagemRepository;
    private final MessageHelper messageHelper;

    public GaragemService(GaragemRepository garagemRepository, MessageHelper messageHelper) {
        this.garagemRepository = garagemRepository;
        this.messageHelper = messageHelper;
    }

    public List<Garagem> getAllGaragens() {
        return garagemRepository.findAll();
    }

    public Garagem save(Garagem garagem) {
        return garagemRepository.save(garagem);
    }

    public void deleteById(Long id) {
        garagemRepository.delete(getGaragem(id));
    }

    private Garagem getGaragem(Long id) {
        return garagemRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(messageHelper.get("garagem.notfound"))
        );
    }
}

package br.com.fiap.MonitoringMottuSprint3.moto;

import br.com.fiap.MonitoringMottuSprint3.config.MessageHelper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    private final MotoRepository motoRepository;
    private final MessageHelper messageHelper;

    public MotoService(MotoRepository motoRepository, MessageHelper messageHelper) {
        this.motoRepository = motoRepository;
        this.messageHelper = messageHelper;
    }

    public List<Moto> getAllMotos() {
        return motoRepository.findAll();
    }

    public Moto save(Moto moto) {
        return motoRepository.save(moto);
    }

    public void deleteById(Long id) {
        motoRepository.delete(getMoto(id));
    }

    private Moto getMoto(Long id) {
        return motoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(messageHelper.get("{moto.notfound}"))
        );
    }
}

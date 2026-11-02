package backend.apiestacionamento.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class EstablishmentNotFoundException extends RuntimeException {
    public EstablishmentNotFoundException(Long id) {
        super("Estabelecimento não encontrado: " + id);
    }
}

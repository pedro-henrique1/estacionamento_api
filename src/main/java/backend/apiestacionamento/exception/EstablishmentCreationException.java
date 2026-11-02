package backend.apiestacionamento.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
public class EstablishmentCreationException extends RuntimeException {
  public EstablishmentCreationException() {
        super("Não foi possível criar o estabelecimento");
    }
}

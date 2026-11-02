package backend.integration;

import backend.apiestacionamento.model.Establishment;
import backend.apiestacionamento.repository.EstablishmentRepository;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
class EstablishmentControllerIntegrationTest extends AbstractIntegrationTest {

        private static final String DEFAULT_CNPJ = "12.345.678/0001-90";

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private EstablishmentRepository establishmentRepository;

        private Long establishmentId;

        private String establishmentJson(String cnpj) {
                return """
                                {
                                  "name": "Estacionamento Teste",
                                  "cnpj": "%s",
                                  "phone": "(31) 99999-9999",
                                  "vacancies_motorcycles": 10,
                                  "vacancies_car": 20
                                }
                                """.formatted(cnpj);
        }

        @BeforeEach
        void setup() throws Exception {
                establishmentRepository.deleteAll();

                String response = mockMvc.perform(post("/establishments")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(establishmentJson(DEFAULT_CNPJ)))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString();

                establishmentId = ((Number) JsonPath.read(response, "$.id")).longValue();
        }

        @Test
        void shouldCreateEstablishment() throws Exception {
                mockMvc.perform(post("/establishments")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(establishmentJson("98.765.432/0001-10")))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.id").isNumber())
                                .andExpect(jsonPath("$.name").value("Estacionamento Teste"));
        }

        @Test
        void shouldReturnAllEstablishments() throws Exception {
                mockMvc.perform(get("/establishments"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", hasSize(1)))
                                .andExpect(jsonPath("$[0].cnpj").value(DEFAULT_CNPJ));
        }

        @Test
        void shouldReturnNotFoundWhenEstablishmentDoesNotExist() throws Exception {
                mockMvc.perform(get("/establishments/{id}", 999999))
                                .andExpect(status().isNotFound());
        }

        @Test
        void shouldUpdateEstablishment() throws Exception {
                String updatedJson = """
                                {
                                  "id": %d,
                                  "name": "Estacionamento Atualizado",
                                  "cnpj": "%s",
                                  "phone": "(31) 88888-8888",
                                  "vacancies_motorcycles": 15,
                                  "vacancies_car": 25
                                }
                                """.formatted(establishmentId, DEFAULT_CNPJ);

                mockMvc.perform(patch("/establishments")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(updatedJson))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.message").value("Estabelecimento atualizado com sucesso"));

                Establishment updated = establishmentRepository.findById(establishmentId).orElseThrow();
                assertEquals("Estacionamento Atualizado", updated.getName());
        }

        @Test
        void shouldReturnNotFoundWhenDeletingNonExistingEstablishment() throws Exception {
                mockMvc.perform(delete("/establishments/{id}", 999999L))
                                .andExpect(status().isNoContent());
        }

}
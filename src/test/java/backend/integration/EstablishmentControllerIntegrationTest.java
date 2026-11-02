package backend.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EstablishmentControllerIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateAndRetrieveEstablishment() throws Exception {
        String establishment = """
                {
                  "name": "Estacionamento Teste",
                  "cnpj": "12.345.678/0001-90",
                  "phone": "(31) 99999-9999",
                  "vacancies_motorcycles": 10,
                  "vacancies_car": 20
                }
                """;

        String response = mockMvc.perform(post("/establishments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(establishment))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").value("Estacionamento Teste"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Number id = com.jayway.jsonpath.JsonPath.read(response, "$.id");

        mockMvc.perform(get("/establishments/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.cnpj").value("12.345.678/0001-90"));
    }
}

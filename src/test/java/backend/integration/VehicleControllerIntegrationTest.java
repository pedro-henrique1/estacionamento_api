package backend.integration;

import backend.apiestacionamento.model.Establishment;
import backend.apiestacionamento.model.Vehicle;
import backend.apiestacionamento.repository.EstablishmentRepository;
import backend.apiestacionamento.repository.VehicleRepository;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional 
public class VehicleControllerIntegrationTest extends AbstractIntegrationTest {

    private static final String DEFAULT_CNPJ = "12.345.678/0001-90";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EstablishmentRepository establishmentRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    private Long establishmentId;
    private Establishment establishmentEntity;

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


    private String vehicleJson(Long id, String plate, String mark, String model, String color, String type) {
        return """
            {
              "id": %d,
              "mark": "%s",
              "model": "%s",
              "color": "%s",
              "plate": "%s",
              "type": "%s",
              "establishment": %d
            }
            """.formatted(id, mark, model, color, plate, type, establishmentId);
    }

    private String defaultVehicleJson(String plate) {
        return vehicleJson(1L, plate, "Toyota", "Corolla", "Preto", "Carro");
    }

    private Vehicle saveVehicleInDb(String plate) {
        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(plate);
        vehicle.setMark("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setColor("Preto");
        vehicle.setType("Carro");
        vehicle.setEstablishment(establishmentEntity);
        return vehicleRepository.save(vehicle);
    }

    @BeforeEach
    void setup() throws Exception {
        vehicleRepository.deleteAll();
        establishmentRepository.deleteAll();

        String response = mockMvc.perform(post("/establishments")
            .contentType(MediaType.APPLICATION_JSON)
            .content(establishmentJson(DEFAULT_CNPJ)))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        establishmentId = ((Number) JsonPath.read(response, "$.id")).longValue();
        establishmentEntity = establishmentRepository.findById(establishmentId).orElseThrow();
    }

    @Test
    void shouldCreateVehicle() throws Exception {
        mockMvc.perform(post("/vehicle")
            .contentType(MediaType.APPLICATION_JSON)
            .content(defaultVehicleJson("ABC-1234")))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.plate").value("ABC-1234"))
            .andExpect(jsonPath("$.mark").value("Toyota"))
            .andExpect(jsonPath("$.model").value("Corolla"))
            .andExpect(jsonPath("$.color").value("Preto"));
    }

    @Test 
    void shouldGetVehicleById() throws Exception {
        Vehicle savedVehicle = saveVehicleInDb("ABC-1234");

        mockMvc.perform(get("/vehicle/{id}", savedVehicle.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.plate").value("ABC-1234"))
            .andExpect(jsonPath("$.mark").value("Toyota"))
            .andExpect(jsonPath("$.model").value("Corolla"))
            .andExpect(jsonPath("$.color").value("Preto"));
    }

    @Test 
    void shoulUpdateVehicle() throws Exception {
        Vehicle savedVehicle = saveVehicleInDb("ABC-1234");

        String updatedJson = vehicleJson(
            savedVehicle.getId(), "XYZ-5678", "Honda", "Civic", "Branco", "Carro");

        mockMvc.perform(patch("/vehicle")
            .contentType(MediaType.APPLICATION_JSON)
            .content(updatedJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Veiculo atualizado com successo"));

        Vehicle updatedVehicle = vehicleRepository.findById(savedVehicle.getId()).orElseThrow();
        assertEquals("XYZ-5678", updatedVehicle.getPlate());
        assertEquals("Honda", updatedVehicle.getMark());
        assertEquals("Civic", updatedVehicle.getModel());
        assertEquals("Branco", updatedVehicle.getColor());
    }

    @Test 
    void shouldDeleteVehicle() throws Exception {
        Vehicle savedVehicle = saveVehicleInDb("ABC-1234");

        mockMvc.perform(delete("/vehicle/{id}", savedVehicle.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Veiculo deletado com successo"));

        boolean exists = vehicleRepository.existsById(savedVehicle.getId());
        assertEquals(false, exists);
    }
}
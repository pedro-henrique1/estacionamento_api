package backend.apiestacionamento.repository;

import backend.apiestacionamento.model.VehicleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleLogRepository extends JpaRepository<VehicleLog, Integer> {
}

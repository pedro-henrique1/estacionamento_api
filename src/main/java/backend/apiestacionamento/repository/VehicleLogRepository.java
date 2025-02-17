package backend.apiestacionamento.repository;

import backend.apiestacionamento.model.VehicleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleLogRepository extends JpaRepository<VehicleLog, Long> {
    @Query("SELECT COUNT(vl) FROM VehicleLog vl JOIN vl.vehicle v " +
            "WHERE vl.establishment.id = :establishmentId " +
            "AND v.type = :vehicleType " +
            "AND vl.exitTime IS NULL")
    int countActiveVehiclesByType(@Param("establishmentId") Long establishmentId,
                                  @Param("vehicleType") String vehicleType);
}

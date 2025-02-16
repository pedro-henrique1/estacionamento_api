package backend.apiestacionamento.repository;


import backend.apiestacionamento.model.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Long> {
}

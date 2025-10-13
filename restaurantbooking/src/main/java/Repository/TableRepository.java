package Repository;

import Model.ETable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TableRepository extends JpaRepository<ETable, Long> {
    Optional<ETable> findByName(String name);
}

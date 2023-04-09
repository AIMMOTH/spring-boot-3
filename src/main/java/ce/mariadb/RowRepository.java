package ce.mariadb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RowRepository extends JpaRepository<RowEntity, Integer> {
}

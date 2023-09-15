package ce.mariadb;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowRepository extends R2dbcRepository<RowEntity, Integer> {
}

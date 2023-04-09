package ce.service;

import ce.api.dto.RowDto;
import ce.api.dto.RowIdDto;
import ce.api.dto.RowValueDto;
import ce.mariadb.RowEntity;
import ce.mariadb.RowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RowService {

    private RowRepository repo;

    public RowIdDto createRow(RowValueDto value) {
        var entity = RowEntity.builder().value(value.getValue()).build();
        var saved = repo.save(entity);
        return new RowIdDto().id(saved.getId());
    }

    public RowDto readRow(Integer id) {
        var entity = repo.findById(id);
        if (entity.isPresent()) {
            return new RowDto().id(entity.get().getId()).value(entity.get().getValue());
        } else {
            throw new IllegalArgumentException("");
        }
    }
}

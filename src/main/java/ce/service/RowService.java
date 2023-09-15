package ce.service;

import ce.api.dto.RowDto;
import ce.api.dto.RowIdDto;
import ce.api.dto.RowValueDto;
import ce.mariadb.RowEntity;
import ce.mariadb.RowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class RowService {

    private RowRepository repo;

    public Optional<RowIdDto> createRow(RowValueDto value) {
        var entity = RowEntity.builder().value(value.getValue()).build();
        var saved = repo.save(entity).blockOptional();
        if (saved.isPresent()) {
            return Optional.of(new RowIdDto().id(saved.get().getId()));
        } else {
            return Optional.empty();
        }
    }

    public RowDto readRow(Integer id) {
        var entity = repo.findById(id).blockOptional();
        if (entity.isPresent()) {
            return new RowDto().id(entity.get().getId()).value(entity.get().getValue());
        } else {
            throw new IllegalArgumentException("");
        }
    }
}

package ce.service;

import ce.api.dto.IdDto;
import ce.api.dto.ImmutableDto;
import ce.api.dto.PostImmutableDto;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Log
@Service
public class ImmutableService {

    private Map<String, ImmutableDto> model = new HashMap<>();

    public IdDto createImmutable(PostImmutableDto value) {
        var id = UUID.randomUUID().toString();
        var entity = new ImmutableDto().id(id).value(value.getValue());
        log.info("Putting object at id " + id + " with value " + entity);
        model.put(id, entity);
        return new IdDto().id(id);
    }

    @Cacheable("immutable")
    public ImmutableDto readImmutable(String id) {
        // Fake delay
        try {
            log.info("Sleeping to mock fetch. Next call should use cache.");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var entity = model.get(id);
        log.info("Getting object with id " + id + ", returning object " + entity);
        return entity;
    }
}

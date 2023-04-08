package ce.controller;

import ce.api.controller.ImmutableApi;
import ce.api.dto.IdDto;
import ce.api.dto.ImmutableDto;
import ce.api.dto.PostImmutableDto;
import ce.service.ImmutableService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Log
@Controller
public class ImmutableController implements ImmutableApi {

    private ImmutableService service;

    @Override
    public ResponseEntity<IdDto> postImmutable(PostImmutableDto value) {
        IdDto result = service.createImmutable(value);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<ImmutableDto> getImmutable(String id) {
        ImmutableDto result = service.readImmutable(id);
        return ResponseEntity.ok(result);
    }
}

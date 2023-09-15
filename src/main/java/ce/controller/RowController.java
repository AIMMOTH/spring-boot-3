package ce.controller;

import ce.api.controller.RowApi;
import ce.api.dto.RowDto;
import ce.api.dto.RowIdDto;
import ce.api.dto.RowValueDto;
import ce.service.RowService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@AllArgsConstructor
@Controller
@Log
public class RowController implements RowApi {

    private RowService service;

    @Override
    public ResponseEntity<RowIdDto> postRow(RowValueDto value) {
        log.info("postRow, value=" + value);
        Optional<RowIdDto> result = service.createRow(value);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<RowDto> getRow(Integer id) {
        log.info("getRow, id=" + id);
        log.info("postRow");
        RowDto result = service.readRow(id);
        return ResponseEntity.ok(result);
    }
}

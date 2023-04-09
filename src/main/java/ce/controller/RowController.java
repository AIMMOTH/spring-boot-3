package ce.controller;

import ce.api.controller.RowApi;
import ce.api.dto.RowDto;
import ce.api.dto.RowIdDto;
import ce.api.dto.RowValueDto;
import ce.service.RowService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class RowController implements RowApi {

    private RowService service;

    @Override
    public ResponseEntity<RowIdDto> postRow(RowValueDto value) {
        RowIdDto result = service.createRow(value);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<RowDto> getRow(Integer id) {
        RowDto result = service.readRow(id);
        return ResponseEntity.ok(result);
    }
}

package ce.controller;

import ce.api.controller.UserApi;
import ce.api.dto.AllUsersDto;
import ce.api.dto.UserDto;
import ce.api.dto.UserIdDto;
import ce.api.dto.UserValueDto;
import ce.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class UserController implements UserApi {

    private UserService service;

    @Override
    public ResponseEntity<UserIdDto> postUser(UserValueDto value) {
        Optional<UserIdDto> result = service.createUser(value);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<UserDto> getUser(String id) {
        UserDto result = service.readUser(id);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<AllUsersDto> getAllUsers() {
        AllUsersDto result = service.readAllUsers();
        return ResponseEntity.ok(result);
    }
}

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

@AllArgsConstructor
@Controller
public class UserController implements UserApi {

    private UserService service;

    @Override
    public ResponseEntity<UserIdDto> postUser(UserValueDto value) {
        UserIdDto result = service.createUser(value);
        return ResponseEntity.ok(result);
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

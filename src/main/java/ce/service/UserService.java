package ce.service;

import ce.api.dto.AllUsersDto;
import ce.api.dto.UserDto;
import ce.api.dto.UserIdDto;
import ce.api.dto.UserValueDto;
import ce.mongodb.UserDocument;
import ce.mongodb.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

// https://www.bezkoder.com/spring-boot-mongodb-reactive/
@AllArgsConstructor
@Log
@Service
public class UserService {

    private UserRepository repo;

    public Optional<UserIdDto> createUser(UserValueDto value) {
        var document = new UserDocument();
        document.setValue(value.getValue());
        log.info("Saving document:" + document);
        var saved = repo.save(document).blockOptional();
        if (saved.isPresent()) {
            log.info("Saved:" + saved);
            return Optional.of(new UserIdDto().id(saved.get().getId()));
        } else {
            return Optional.empty();
        }
    }

    public UserDto readUser(String id) {
        log.info("Finding user document with id:" + id);
        var document = repo.findById(id).blockOptional();
        if (document.isPresent()) {
            log.info("Found document with id:" + id);
            return new UserDto().id(document.get().getId()).value(document.get().getValue());
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public AllUsersDto readAllUsers() {
        var all = repo.findAll().map(document -> new UserDto().id(document.getId()).value(document.getValue())).toStream().collect(Collectors.toList());
        return new AllUsersDto().users(all);
    }
}

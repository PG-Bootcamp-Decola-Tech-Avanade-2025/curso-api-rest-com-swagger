package pg.decola_tech_avanade_2025.cursos.api_rest_com_swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pg.decola_tech_avanade_2025.cursos.api_rest_com_swagger.dto.EditorUserDto;
import pg.decola_tech_avanade_2025.cursos.api_rest_com_swagger.model.User;
import pg.decola_tech_avanade_2025.cursos.api_rest_com_swagger.repository.UserRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody EditorUserDto newUserDto) {
        User newUser = new User(
                newUserDto.getUsername(),
                newUserDto.getPassword()
        );

        userRepository.save(newUser);

        return ResponseEntity.created(
                URI.create(String.format("/users/%s", newUser.getId()))
        ).body(newUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable UUID id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            throw new RuntimeException(String.format("Usuário de id %s não foi encontrado.", id));
        }

        return ResponseEntity.ok(user.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable UUID id, @RequestBody EditorUserDto newUserDto) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            throw new RuntimeException(String.format("Usuário de id %s não foi encontrado.", id));
        }

        User persistedUser = user.get();

        persistedUser.setName(newUserDto.getUsername());
        persistedUser.setPassword(newUserDto.getPassword());
        userRepository.save(persistedUser);

        return ResponseEntity.ok(persistedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

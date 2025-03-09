package pg.decola_tech_avanade_2025.cursos.api_rest_com_swagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    private ResponseEntity<String> getHome() {
        return ResponseEntity.ok("Hello, world!");
    }
}

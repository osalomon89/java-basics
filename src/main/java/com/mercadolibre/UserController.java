package com.mercadolibre;

import com.mercadolibre.response.ApiResponse;
import com.mercadolibre.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
class UserController {
    private User.Usuario user = new User.Usuario(1, "John");

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        if (id == user.getId()) {
            return ResponseEntity.ok().body(new ApiResponse("Usuário encontrado.", false));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Usuário não encontrado.", true));
        }
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User newUser) {
        user = (User.Usuario) newUser;
        return ResponseEntity.ok().body(new ApiResponse("Usuário foi criado com sucesso.", newUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody User updatedUser) {

        if (id == user.getId()) {
            user = (User.Usuario) updatedUser;
            return ResponseEntity.ok().body(new ApiResponse("Usuário foi atualizado com sucesso.", updatedUser));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Usuário não encontrado.", true));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        if (id == user.getId()) {
            user = null;
            return ResponseEntity.ok().body("Usuário removido: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
    }
}


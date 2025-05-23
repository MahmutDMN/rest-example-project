package tr.com.rest.example.restuserservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.com.rest.example.restuserservice.model.User;
import tr.com.rest.example.restuserservice.model.UserAddRequest;
import tr.com.rest.example.restuserservice.model.UserUpdateRequest;
import tr.com.rest.example.restuserservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
    private UserService userService;

//    // Kullanıcı ekleme (POST) request param ile yollama
//    @PostMapping("/add")
//    public User addUser(@RequestParam String name, @RequestParam String surname) {
//        return userService.addUser(name, surname);
//    }
//    
//    // Kullanıcı ekleme (POST) body ile yollama
//    @PostMapping("/add2")
//    public User addUser(@RequestBody UserAddRequest request) {
//        return userService.addUser(request.getName(), request.getSurname());
//    }
//
//    // Tüm kullanıcıları getirme (GET)
//    @GetMapping("/all")
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
	
	// Kullanıcı ekleme (POST)
    @PostMapping("/add")
    public User addUser(@RequestBody UserAddRequest request) {
        return userService.addUser(request.getName(), request.getSurname());
    }

    // Tüm kullanıcıları getirme (GET)
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    // Soyisime göre kullanıcıları getirme (GET) - Request Param
    @GetMapping("/surname")
    public List<User> getUsersBySurname(@RequestParam String surname) {
        return userService.getUsersBySurname(surname);
    }

    // ID'ye göre kullanıcıyı getirme (GET)
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Kullanıcıyı güncelleme (PUT)
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(id, request.getName(), request.getSurname());
    }

    // Kullanıcıyı silme (DELETE)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

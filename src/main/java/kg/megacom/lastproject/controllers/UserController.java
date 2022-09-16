package kg.megacom.lastproject.controllers;


import kg.megacom.lastproject.models.User;
import kg.megacom.lastproject.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("save")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/get")
    public User getById(@RequestParam Long id){
        return userService.findById(id);
    }

    @PutMapping
    public Long update(@RequestBody Long id, String status){
        return null;
    }

    @PostMapping("/add")
    private User addUser(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/add/file")
    private User addImageToUser(@RequestParam Long userId, @RequestPart MultipartFile file){
        User user = userService.findById(userId);
        return  userService.addUser(user, file);
    }
}


package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Model.UserModel;
import Service.UserService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
	
	private final UserService userService;
	
	 @Autowired
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }

	    @GetMapping
	    public ResponseEntity<List<UserModel>> findAll() {
	        return ResponseEntity.ok(userService.findAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<UserModel> findById(@PathVariable Long id) {
	        Optional<UserModel> userModel = userService.findById(id);

	        return ResponseEntity.ok(userService.findById(id).get());
	    }

	    @PostMapping
	    public ResponseEntity<UserModel> create(UserModel userModel) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<UserModel> update(@PathVariable Long id, @RequestBody UserModel userModel) {
	        return ResponseEntity.accepted().body(userService.save(userModel));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	    	userService.deleteById(id);
	        return ResponseEntity.accepted().build();
	    }

}

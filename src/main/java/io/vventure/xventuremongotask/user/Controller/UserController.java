package io.vventure.xventuremongotask.user.Controller;

import io.vventure.xventuremongotask.user.DTO.UserDTO;
import io.vventure.xventuremongotask.user.Exception.DeleteWasNotwork;
import io.vventure.xventuremongotask.user.Exception.NoUserAvailableException;
import io.vventure.xventuremongotask.user.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/adduser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO dto){
        return new ResponseEntity<>(userService.addUser(dto), HttpStatus.OK);
    }

    @GetMapping(value = "/getuser/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id){
        try {
            return new ResponseEntity<>(userService.findUserById(id),HttpStatus.OK);
        } catch (Exception e) {
            throw new NoUserAvailableException("User is not available",e);
        }
    }

    @GetMapping(value = "getall")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> all = userService.getAll();
        if(all.isEmpty()){
            throw new NoUserAvailableException("Currently there is no users");
        }else{
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/deleteuser/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id){
        boolean b = userService.deleteUser(id);
        if(b){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            throw new DeleteWasNotwork("Delete was not successful");
        }
    }
}

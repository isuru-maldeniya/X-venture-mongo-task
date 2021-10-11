package io.vventure.xventuremongotask.user.Controller;

import io.vventure.xventuremongotask.user.DTO.UserDTO;
import io.vventure.xventuremongotask.user.Exception.DeleteWasNotwork;
import io.vventure.xventuremongotask.user.Exception.NoUserAvailableException;
import io.vventure.xventuremongotask.user.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    private Logger logger;

    @PostMapping(value = "/adduser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO dto){
        return new ResponseEntity<>(userService.addUser(dto), HttpStatus.OK);
    }

    @GetMapping(value = "/getuser/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id){
        try {
            return new ResponseEntity<>(userService.findUserById(id),HttpStatus.OK);
        } catch (Exception e) {
            logger.trace("user is no available");
            throw new NoUserAvailableException("User is not available",e);
        }
    }

    @GetMapping(value = "getall")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> all = userService.getAll();
        if(all.isEmpty()){
            logger.trace("User list is empty");
            throw new NoUserAvailableException("Currently there is no users");
        }else{
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
    }

    @PutMapping(value = "updateuser")
    public ResponseEntity<UserDTO> updateUSer(@RequestBody UserDTO dto){
        UserDTO userDTO = userService.updateUser(dto);
        if(userDTO==null){
            logger.trace("user is no available");
            throw new NoUserAvailableException("User is not available");
        }else{
            return new ResponseEntity<>(userDTO,HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/deleteuser/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id){
        boolean b = userService.deleteUser(id);
        if(b){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            logger.trace("user is no available");
            throw new DeleteWasNotwork("Delete was not successful");
        }
    }
}

package io.vventure.xventuremongotask.user.Services;

import io.vventure.xventuremongotask.user.DTO.UserDTO;
import io.vventure.xventuremongotask.user.Entities.User;
import io.vventure.xventuremongotask.user.Repositories.UserRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO addUser(UserDTO dto){
        User save = userRepository.save(new User(dto.getId(), dto.getName(), dto.getEmail(), dto.getDob()));
        return new UserDTO(save.getId(), save.getName(), save.getEmail(), save.getDob());
    }

    public UserDTO findUserById(String id)throws Exception {
        User user = userRepository.findById(id).get();
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getDob());
    }

    public List<UserDTO> getAll(){
        LinkedList<UserDTO> userDTOS=new LinkedList<>();
        userRepository.findAll().stream().forEach(user->userDTOS.add(new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getDob())));
        return userDTOS;
    }

    public boolean deleteUser(String id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }

    public UserDTO updateUser(UserDTO dto){
        UserDTO userDTO=null;
        User user=null;
        if(!userRepository.existsById(dto.getId())){
            return userDTO;
        }
        user=userRepository.findById(dto.getId()).get();
        if(dto.getName()!=null && dto.getName()!=""){
            user.setName(dto.getName());
        }
        if(dto.getEmail()!=null && dto.getEmail()!=""){
            user.setEmail(dto.getEmail());
        }
        if(dto.getDob()!=null){
            user.setDob(dto.getDob());
        }
        User save = userRepository.save(user);
        return new UserDTO(save.getId(), save.getName(), save.getEmail(), save.getDob());
    }
}

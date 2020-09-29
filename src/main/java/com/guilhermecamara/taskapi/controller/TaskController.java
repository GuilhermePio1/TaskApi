package com.guilhermecamara.taskapi.controller;

import com.guilhermecamara.taskapi.model.Task;
import com.guilhermecamara.taskapi.model.UserT;
import com.guilhermecamara.taskapi.repository.TaskRepository;
import com.guilhermecamara.taskapi.repository.UserRepository;
import com.guilhermecamara.taskapi.security.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/insert")
    public ResponseEntity<?> insert(@RequestBody @Valid Task task, HttpServletRequest request){
        UserT userT = getUser(request);
        task.setUserT(userT);
        taskRepository.save(task);
        return ResponseEntity.ok("Task save successfully");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable (value = "id") Long id, HttpServletRequest request){
        UserT userT = getUser(request);
        Task task = taskRepository.findById(id).get();

        if(userT.getId() != task.getUserT().getId()){
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        taskRepository.delete(task);
        return ResponseEntity.ok("Task delete successfully");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTasks(@PathVariable (value = "id") Long id, HttpServletRequest request){
        UserT userT = getUser(request);

        if (userT.getId() != id){
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        Optional<Task> tasks = taskRepository.findById(id);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping(value = "update")
    public ResponseEntity<?> update(@RequestBody Task task){
        if (task.getId() == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        taskRepository.save(task);
        return ResponseEntity.ok(task);
    }

    private UserT getUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String username = jwtTokenUtil.getUsernameFromToken(token);
        return userRepository.findByUsername(username);
    }
}

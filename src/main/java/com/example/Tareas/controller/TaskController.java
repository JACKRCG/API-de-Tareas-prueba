package com.example.Tareas.controller;

import com.example.Tareas.entity.Task;
import com.example.Tareas.repository.TaskRepository;
import com.example.Tareas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> obtenerListaDeTareas() {
        return taskService.getTasks();
    }

    @PostMapping
    public ResponseEntity<String> guardarTarea(@RequestBody Task task){
        taskService.saveOrUpdate(task);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tarea creada correctamente");
        //return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<String> completarTarea(@PathVariable Long id) {
        taskService.completeTask(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tarea actualizada a completada correctamente");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTarea(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tarea eliminada correctamente");
    }


}

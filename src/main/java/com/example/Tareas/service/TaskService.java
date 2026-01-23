package com.example.Tareas.service;

import com.example.Tareas.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> getTasks(); //Devuelve toda la lista de tareas
    Optional<Task> getTask(Long id);
    void completeTask(Long id);
    void saveOrUpdate(Task task);
    void delete(Long id);

}

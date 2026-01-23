package com.example.Tareas.service.impl;

import com.example.Tareas.entity.Task;
import com.example.Tareas.repository.TaskRepository;
import com.example.Tareas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void completeTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        task.setCompleted(true);
        taskRepository.save(task);
    }

    @Override
    public void saveOrUpdate(Task task) {
        if (task.getId() == null) { // nueva tarea
            task.setCompleted(false);
            task.setCreatedAt(LocalDateTime.now());
        }
        taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}

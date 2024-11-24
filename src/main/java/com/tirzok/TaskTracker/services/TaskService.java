package com.tirzok.TaskTracker.services;

import com.tirzok.TaskTracker.models.Task;
import com.tirzok.TaskTracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return (List<Task>) taskRepository.findAll();

    }

//    public List<Task> getTasksByCategory(String category) {
//        return taskRepository.findByCategory(category);
//    }

    public Task getTaskById(Long task_id){
        return taskRepository.findById(task_id).get();
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Task task){
        return taskRepository.save(task);
    }
    public String deleteTask (Task task){
        taskRepository.delete(task);
        return "Task is deleted Successfully for task id: "+task.getTask_id();
    }
}

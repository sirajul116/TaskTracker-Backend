package com.tirzok.TaskTracker.controller;

import com.tirzok.TaskTracker.models.Task;
import com.tirzok.TaskTracker.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3360)
@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/tasks")
    public ResponseEntity< List<Task>> getAllTasks () {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @GetMapping("/tasks/{task_id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("task_id") Long task_id){
        return ResponseEntity.ok(taskService.getTaskById(task_id));
    }
    @GetMapping("/tasks/category/{category}")
    public ResponseEntity<List<Task>> getTasksByCategory(@PathVariable("category") String category) {
        return ResponseEntity.ok(taskService.getTasksByCategory(category));
    }
    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask (@RequestBody Task task){
        return ResponseEntity.ok(taskService.addTask(task));
    }
    @PatchMapping("tasks/{task_id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task,@PathVariable("task_id") Long task_id){
        Task taskObj = taskService.getTaskById(task_id);
        if(taskObj!=null){
            taskObj.setCategory(task.getCategory());
            taskObj.setDetails(task.getDetails());
            taskObj.setStatus(task.getStatus());
            task.setPersistence(task.getPersistence());
        }
        return ResponseEntity.ok(taskService.updateTask(taskObj));
    }
    @DeleteMapping("/tasks/{task_id}")
    public ResponseEntity<String> deleteTask(@PathVariable("task_id") Long task_id){
        Task taskObj = taskService.getTaskById(task_id);
        String dltmsg=null;
        if(taskObj!=null){
            dltmsg = taskService.deleteTask(taskObj);
        }
        return ResponseEntity.ok(dltmsg);
    }
}

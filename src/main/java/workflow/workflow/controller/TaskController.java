package workflow.workflow.controller;

import workflow.workflow.pojo.TaskRequest;
import workflow.workflow.pojo.TaskUpdateRequest;
import workflow.workflow.pojo.ApiResponse;
import workflow.workflow.entity.Task;
import workflow.workflow.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<ApiResponse<Task>> createTask(@Valid @RequestBody TaskRequest request,
                                                        Authentication authentication) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Task created", taskService.createTask(request, authentication.getName())));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Task>>> getMyTasks(Authentication authentication) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Tasks fetched", taskService.getMyTasks(authentication.getName())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> getTask(@PathVariable String id, Authentication authentication) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Task fetched", taskService.getTaskById(id, authentication.getName())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> updateTask(@PathVariable String id,
                                                        @Valid @RequestBody TaskUpdateRequest request,
                                                        Authentication authentication) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Task updated", taskService.updateTask(id, request, authentication.getName())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteTask(@PathVariable String id, Authentication authentication) {
        taskService.deleteTask(id, authentication.getName());
        return ResponseEntity.ok(new ApiResponse<>(true, "Task deleted", id));
    }
}

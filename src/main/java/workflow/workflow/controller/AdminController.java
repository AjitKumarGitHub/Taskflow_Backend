package workflow.workflow.controller;

import workflow.workflow.pojo.ApiResponse;
import workflow.workflow.pojo.TaskRequest;
import workflow.workflow.entity.Task;
import workflow.workflow.entity.User;
import workflow.workflow.repository.UserRepository;
import workflow.workflow.service.AdminService;
import workflow.workflow.service.TaskService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private AdminService adminService;

	@PostMapping("/tasks")
	public ResponseEntity<ApiResponse<Task>> createTask(@Valid @RequestBody TaskRequest request,
			Authentication authentication) {
		return ResponseEntity
				.ok(new ApiResponse<>(true, "Task created", taskService.createTask(request, authentication.getName())));
	}

	@GetMapping("/users")
	public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
		return ResponseEntity.ok(new ApiResponse<>(true, "Users fetched", userRepository.findAll()));
	}

	@GetMapping("/tasks")
	public ResponseEntity<ApiResponse<List<Task>>> getAllTasks() {
		return ResponseEntity.ok(new ApiResponse<>(true, "All tasks fetched", taskService.getAllTasks()));
	}

	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<ApiResponse<String>> deleteAnyTask(@PathVariable String id) {
		taskService.deleteAnyTask(id);
		return ResponseEntity.ok(new ApiResponse<>(true, "Task deleted by admin", id));
	}

	@DeleteMapping("/userdelete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId, Authentication authentication) {

		String currentAdminEmail = authentication.getName();

		return ResponseEntity.ok(adminService.deleteUser(userId, currentAdminEmail));
	}
}

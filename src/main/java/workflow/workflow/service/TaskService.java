package workflow.workflow.service;


import workflow.workflow.pojo.TaskRequest;
import workflow.workflow.pojo.TaskUpdateRequest;
import workflow.workflow.entity.Task;
import workflow.workflow.entity.User;
import workflow.workflow.exception.ResourceNotFoundException;
import workflow.workflow.repository.TaskRepository;
import workflow.workflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public Task createTask(TaskRequest request, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(request.getStatus())
                .priority(request.getPriority())
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return taskRepository.save(task);
    }

    public List<Task> getMyTasks(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return taskRepository.findByUserId(user.getId());
    }

    public Task getTaskById(String id, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        if (!task.getUserId().equals(user.getId())) {
            throw new RuntimeException("Unauthorized access");
        }

        return task;
    }

    public Task updateTask(String id, TaskUpdateRequest request, String email) {
        Task task = getTaskById(id, email);
        if(request.getTitle() != null || request.getTitle() != " ") task.setTitle(request.getTitle());
        if(request.getDescription() != null || request.getDescription() != " ") task.setDescription(request.getDescription());
        if(request.getStatus() != null || request.getStatus() != " ") task.setStatus(request.getStatus());
        if(request.getPriority() != null || request.getPriority() != " ") task.setPriority(request.getPriority());
         
         
        task.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }

    public void deleteTask(String id, String email) {
        Task task = getTaskById(id, email);
        taskRepository.delete(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteAnyTask(String id) {
        taskRepository.deleteById(id);
    }
}

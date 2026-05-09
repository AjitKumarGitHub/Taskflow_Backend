package workflow.workflow.service;

import workflow.workflow.entity.User;
import workflow.workflow.repository.TaskRepository;
import workflow.workflow.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public String deleteUser(
            String userId,
            String currentAdminEmail
    ) {

        User currentAdmin = userRepository.findByEmail(currentAdminEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Admin not found"));

        User userToDelete = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        // Prevent admin from deleting own account
        if (currentAdmin.getId().equals(userToDelete.getId())) {
            throw new RuntimeException(
                    "Admin cannot delete their own account"
            );
        }

        // Delete all tasks created by user
        taskRepository.deleteByUserId(userToDelete.getId());

        // Delete user
        userRepository.delete(userToDelete);

        return "User and all associated tasks deleted successfully";
    }
}
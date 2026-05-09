package workflow.workflow.repository;

import workflow.workflow.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByUserId(String userId);
    void deleteByUserId(String userId);
}

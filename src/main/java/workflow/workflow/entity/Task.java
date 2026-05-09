package workflow.workflow.entity;
 

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tasks")
public class Task {
    @Id
    private String id;

    private String title;
    private String description;
    private String status;
    private String priority;
    private String userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

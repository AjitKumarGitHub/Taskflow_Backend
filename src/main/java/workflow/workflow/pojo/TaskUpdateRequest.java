package workflow.workflow.pojo;

import lombok.Data;

@Data
public class TaskUpdateRequest {

	private String title;

	private String description;

	private String status;

	private String priority;
}

package org.example.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Feedback {
    private Integer feedbackid;
    private Integer userid;
    @NotEmpty
    private String content;
    private String timetemp;
    private Integer show;
    private Integer deleted;
    @NotNull
    private Integer suggestionid;
}

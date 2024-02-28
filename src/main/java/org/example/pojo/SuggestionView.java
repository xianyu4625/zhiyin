package org.example.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SuggestionView {
    private Integer suggestionid;
    private Integer userid;
    @NotEmpty
    private String question;
    @NotEmpty
    private String Suggestion;
    private String timestamp;
    private Integer show;
    private Integer deleted;
    private String username;
    private Integer roleid;
}

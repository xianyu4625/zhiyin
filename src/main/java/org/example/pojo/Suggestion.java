package org.example.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class Suggestion {
    private Integer suggestionid;
    private Integer userid;
    @NotEmpty
    private String question;
    @NotEmpty
    private String Suggestion;
    private String timestamp;
    private Integer show;
    private Integer deleted;

}

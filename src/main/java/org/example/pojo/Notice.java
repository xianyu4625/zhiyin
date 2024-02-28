package org.example.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Notice {
    private Integer noticeid;
    private Integer userid;
    @NotEmpty
    private String content;
    private String timestamp;
    private Integer deleted;
    private Integer show;
}

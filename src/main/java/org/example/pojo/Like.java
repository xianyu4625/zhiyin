package org.example.pojo;

import lombok.Data;

@Data
public class Like {
    private Integer likeid;
    private Integer userid;
    private String timestamp;
    private Integer deleted;
    private Integer suggestionid;
}

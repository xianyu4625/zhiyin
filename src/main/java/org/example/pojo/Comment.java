package org.example.pojo;

import lombok.Data;

@Data
public class Comment {
    private Integer commentid;
    private Integer userid;
    private String content;
    private String timestamp;
    private Integer suggestionid;
    private Integer deleted;
}

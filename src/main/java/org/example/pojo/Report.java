package org.example.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;

@Data
public class Report {
    private Integer reportid;
    private Integer userid;
    @NotEmpty
    private String reportcontent;
    private String timestamp;
    private Integer show;
    private Integer deleted;
}

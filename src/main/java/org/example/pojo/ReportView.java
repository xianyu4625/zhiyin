package org.example.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ReportView {
    private Integer reportid;
    private Integer userid;
    @NotEmpty
    private String reportcontent;
    private String timestamp;
    private Integer show;
    private Integer deleted;
    private String nickname;
    private Integer roleid;
}

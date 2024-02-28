package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Switch {
    private Integer switchid;
    @NotNull
    private Integer userid;
    @NotNull
    private Integer goodid;
    @NotNull
    private Integer change;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String timestamp;
    private Integer deleted;
}

package org.example.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Score {
    private Integer scoreid;
    @NotNull
    private Integer userid;
    @NotEmpty
    private Integer score;
}

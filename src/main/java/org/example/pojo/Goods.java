package org.example.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.swing.*;
@Data
public class Goods {
    private Integer goodid;
    @NotEmpty
    @Pattern(regexp = "^\\S{5,99}$")
    private String scription;
    @NotNull
    private Integer score;
    @NotEmpty
    private String goodname;
    @URL
    private String goodimg;
    private Integer deleted;

}

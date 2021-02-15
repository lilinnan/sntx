package com.lln.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    /**
    * 主键ID
    */
    private Integer id;

    @NotNull
    @NotBlank
    private String contact;

    @NotNull
    @NotBlank
    private String feedback;
}
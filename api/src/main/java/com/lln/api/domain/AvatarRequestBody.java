package com.lln.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/5 1:38
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvatarRequestBody {

    @NotNull
    @NotBlank
    private String uid;

    @NotBlank
    @NotBlank
    private String type;
}

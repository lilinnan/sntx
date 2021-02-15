package com.lln.api.domain;

import lombok.*;

import java.util.List;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/5 1:06
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Result {
    private String prefix = "";

    private String suffix = "";

    private String uid = "";

    private List<Integer> list;

}

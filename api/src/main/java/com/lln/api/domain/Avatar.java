package com.lln.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Avatar {

    private Integer id = -1;

    private String uid = "";

    private String data = "";

    /**
     * 0 国服
     * 1 台服
     * 2 日服
     */
    private Integer type = -1;
}
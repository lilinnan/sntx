package com.lln.api.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/5 1:41
 */

@Builder
@Data
public class Message {
    private int status;
    private Object message;
}

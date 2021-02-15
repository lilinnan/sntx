package com.lln.api.service;

import com.lln.api.domain.Result;

import java.util.List;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/5 0:28
 */

public interface GetAvatarService {

    /**
     * 获取头像
     *
     * @param uid  用户id
     * @param type 获取类型
     * @return
     */
    Result getAvatar(String uid, String type);
}

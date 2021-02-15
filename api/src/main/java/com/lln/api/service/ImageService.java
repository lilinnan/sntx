package com.lln.api.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/9/24 11:16
 */

public interface ImageService {

    void image(String url, HttpServletResponse response);
}

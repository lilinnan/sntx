package com.lln.api.service.impl;

import com.lln.api.service.ImageService;
import com.lln.api.util.StreamUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/9/24 11:18
 */

@Service
public class ImageServiceImpl implements ImageService {
    private final OkHttpClient okHttpClient;

    public ImageServiceImpl(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public void image(String url, HttpServletResponse response) {
        if (url == null || url.length() == 0) {
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            Response result = okHttpClient.newCall(new Request.Builder().url(url).build()).execute();
            bufferedInputStream = new BufferedInputStream(result.body().byteStream());
            bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
            byte[] data = new byte[1024];
            int length;
            while ((length = bufferedInputStream.read(data)) != -1) {
                bufferedOutputStream.write(data, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StreamUtils.close(bufferedInputStream, bufferedOutputStream);
        }
    }
}

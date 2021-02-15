package com.lln.api.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/9/24 11:27
 */

public class StreamUtils {

    public static void close(Closeable... closeables){
        for(Closeable closeable:closeables){
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

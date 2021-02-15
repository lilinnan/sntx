package com.lln.api.service.impl;

import com.lln.api.constants.CommonConstants;
import com.lln.api.constants.Type;
import com.lln.api.domain.Avatar;
import com.lln.api.domain.Result;
import com.lln.api.mapper.AvatarMapper;
import com.lln.api.service.GetAvatarService;
import com.lln.api.util.CommonUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/5 0:30
 */

@Service
public class GetAvatarServiceImpl implements GetAvatarService {
    private final static String MAINLAND = "http://nn4cn-sh-server-cbt.papegames.com/obt/";
    private final static String TAIWAN = "http://nn4-tw.papegames.com/tw/";
    /**
     * 需要使用的客户端
     */
    private final OkHttpClient okHttpClient;
    /**
     * 头像mapper
     */
    private final AvatarMapper avatarMapper;

    @Value("${sntx.threshold}")
    private int threshold;

    @Autowired
    public GetAvatarServiceImpl(OkHttpClient okHttpClient, AvatarMapper avatarMapper) {
        this.okHttpClient = okHttpClient;
        this.avatarMapper = avatarMapper;
    }

    private boolean isValid(String url) {
        Request request = new Request.Builder().url(url).head().build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.code() == 200;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String avatarUrl(int num, String uid, Type type) {
        String temp = (num < 10 ? "0" : "") + num;
        temp = uid + temp;
        return (Type.MAINLAND.equals(type) ? MAINLAND : TAIWAN)
                + uid + "/photo/" + temp + ".png";
    }

    private boolean isValid(int num, String uid, Type type) {
        return isValid(avatarUrl(num, uid, type));
    }

    @Override
    public Result getAvatar(String uid, String t) {
        Type type = Type.valueOf(t.toUpperCase());
        //初始化
        Avatar avatar = initAvatar(uid);
        //获取之前的数据
        List<Integer> avatarDataList = CommonUtils.parseDataToList(avatar.getData());
        //拿到之前的数据以后，再取出不在数组中的一些数据
        List<Integer> notInArray = CommonUtils.getDataNotInArray(avatarDataList);
        //开始查询这些不在数组中的数据是否在服务器上进行了更新，如果存在，就添加到头像列表中
        for (int i : notInArray) {
            if (isValid(i, uid, type)) {
                avatarDataList.add(i);
            }
        }
        //从列表最大的数据开始,先获取最大的数+1
        int num = getMaxValueInList(avatarDataList) + 1;
        //开始进行检查
        startCheck(avatarDataList, uid, type, num);
        //完成后，对头像数据进行转义
        avatar.setData(CommonUtils.parseListToData(avatarDataList));
        //然后对数据进行保存
        save(avatar);
        return Result.builder().uid(uid).prefix(getPrefix(uid, type)).suffix(".png").list(avatarDataList).build();
    }

    private void startCheck(List<Integer> avatarDataList, String uid, Type type, int start) {
        //失败次数
        int failNum = 0;
        while (start <= CommonConstants.MAX) {
            //判断是否有效
            if (isValid(start, uid, type)) {
                //有效，就进行添加
                avatarDataList.add(start);
                failNum = 0;
            } else {
                //无效，失败次数+1
                failNum++;
                if (failNum >= threshold) {
                    //失败次数已经到达阈值，进行停止，防止浪费资源
                    break;
                }
            }
            start++;
        }
    }

    /**
     * 获取列表中最大的那个数，会对列表进行排序
     *
     * @param data 数据列表
     * @return 最大的数
     */
    private Integer getMaxValueInList(List<Integer> data) {
        if (data == null || data.size() <= 0) {
            return CommonConstants.MIN;
        }
        //先排序
        Collections.sort(data);
        return data.get(data.size() - 1);
    }

    /**
     * 初始化数据
     *
     * @param uid 用户UID
     * @return 查到的数据或是新创建的数据
     */
    private Avatar initAvatar(String uid) {
        Avatar avatar = avatarMapper.selectByUid(uid);
        return avatar == null ? Avatar.builder().id(-1).uid(uid).build() : avatar;
    }


    /**
     * 将数据保存起来
     *
     * @param avatar 头像数据
     */
    private void save(Avatar avatar) {
        if (StringUtils.isEmpty(avatar.getData())) {
            return;
        }
        if (avatar.getId() <= 0) {
            avatarMapper.insert(avatar);
            return;
        }
        avatarMapper.updateByPrimaryKey(avatar);
    }


    private String getPrefix(String uid, Type type) {
        return (Type.MAINLAND.equals(type) ? MAINLAND : TAIWAN) + uid + "/photo/";
    }
}

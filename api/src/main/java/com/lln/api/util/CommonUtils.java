package com.lln.api.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/17 19:28
 */

public class CommonUtils {

    /**
     * 将类似1,5-9,11-20的数据解析为列表
     *
     * @param data 列表数据，列表表达式
     * @return 1, 5, 6, 7, 8, 9, 11, 12...
     */
    public static List<Integer> parseDataToList(String data) {
        List<Integer> dataList = new ArrayList<>();
        if (StringUtils.isEmpty(data)) {
            return dataList;
        }
        String[] s = data.split(",");
        for (String s1 : s) {
            String[] list = s1.split("-");
            if (list.length == 1) {
                dataList.add(Integer.parseInt(list[0]));
                continue;
            }
            if (list.length == 2) {
                for (int i = Integer.parseInt(list[0]); i <= Integer.parseInt(list[1]); i++) {
                    dataList.add(i);
                }
            }
        }
        return dataList;
    }


    /**
     * 将类似1,5,6,7,8,9,11,12的数据转换为1,5-9,11-12
     *
     * @param data 列表数据
     * @return 列表表达式
     */
    public static String parseListToData(List<Integer> data) {
        if (data == null || data.size() <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        //一组的开始
        int min = data.get(0);
        //上一个数字
        int lastNum = data.get(0);
        for (int i = 1, size = data.size(); i <= size; i++) {
            //当前数字
            int num = i < size ? data.get(i) : data.get(size - 1);
            //发现不连续了，证明需要成组
            if (num - lastNum != 1) {
                //看看是否是区间
                if (min == lastNum) {
                    stringBuilder.append(lastNum);
                } else {
                    stringBuilder.append(min).append('-').append(lastNum);
                }
                stringBuilder.append(',');
                min = num;
            }
            lastNum = num;
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    /**
     * 取出不在数组中的数据
     * 例如：1-5,7-8,12，数组区间就是1-12，其中
     * 6,9,10,11就不在其中
     * 数组数组必须是递增的数组，否则可能出现意想不到的结果
     *
     * @param data 数组表达式
     * @return 不存在的数据
     */
    public static List<Integer> getDataNotInArray(String data) {
        List<Integer> dataList = parseDataToList(data);
        return getDataNotInArray(dataList);
    }

    public static List<Integer> getDataNotInArray(List<Integer> dataList) {
        List<Integer> notInArray = new ArrayList<>();
        if (dataList == null || dataList.size() == 0) {
            return notInArray;
        }
        //数据一开始是数组的开头，可以把这个想成另一个指针
        int n = dataList.get(0);
        //指针一开始指向数组的开头
        int pointer = 0;
        while (pointer < dataList.size()) {
            int num = dataList.get(pointer);
            if (n == num) {
                pointer++;
            } else {
                notInArray.add(n);
            }
            n++;
        }
        return notInArray;
    }


}

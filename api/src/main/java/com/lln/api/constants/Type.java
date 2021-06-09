package com.lln.api.constants;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/6/17 22:22
 */

public enum Type {
    /**
     * 大陆服
     */
    MAINLAND(0, "http://nn4cn-sh-server-cbt.papegames.com/obt/"),
    /**
     * 台服
     */
    TAIWAN(1, "http://nn4-tw.papegames.com/tw/"),
    /**
     * 日服
     */
    JAPAN(2, "http://nn4-jp-server.paperdb.com/obt-new/");


    private final String link;
    private final int type;

    Type(int type, String link) {
        this.type = type;
        this.link = link;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return link;
    }
}

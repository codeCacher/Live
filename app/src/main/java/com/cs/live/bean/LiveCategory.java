package com.cs.live.bean;

/**
 * 直播分类信息
 */

public class LiveCategory {

    private long id;
    private String name;
    /**
     * 1-default 0-not
     */
    private int is_default;
    private int sort;
    private String icon_gray;
    private String icon_red;
    private String icon_image;
    private String slug;
    private int type;
    private int screen;

    public boolean isDefault(){
        int DEFAULT = 1;
        return (is_default== DEFAULT);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getIcon_gray() {
        return icon_gray;
    }

    public void setIcon_gray(String icon_gray) {
        this.icon_gray = icon_gray;
    }

    public String getIcon_red() {
        return icon_red;
    }

    public void setIcon_red(String icon_red) {
        this.icon_red = icon_red;
    }

    public String getIcon_image() {
        return icon_image;
    }

    public void setIcon_image(String icon_image) {
        this.icon_image = icon_image;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

}

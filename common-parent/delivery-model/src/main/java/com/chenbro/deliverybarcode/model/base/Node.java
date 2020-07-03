package com.chenbro.deliverybarcode.model.base;

import java.util.List;

/**
 * @ClassName Node
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/15 9:50
 * @Version 1.0
 **/
public class Node {

    private String id;
    private String pId;
    private String text;
    private String href;
    private String icon;
    private String tags;
    private List<Node> nodes;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}

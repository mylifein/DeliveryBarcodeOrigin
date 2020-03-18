package com.chenbro.deliverybarcode.utils;

import com.chenbro.deliverybarcode.model.base.Node;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TreeNodeUtil
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/15 10:41
 * @Version 1.0
 **/
@Component
public class TreeNodeBuilder {

    List<Node> nodes = new ArrayList<>();


    public TreeNodeBuilder() {
    }



    public List<Node> buildTree(List<Node> nodes){

        this.nodes = nodes;
        List<Node> rootNodes = new ArrayList<>();
        List<Node> treeNodes = new ArrayList<>();
        //1.查询所有的根节点
        for(Node node : nodes){
            if(StringUtils.isEmpty(node.getpId())){
                rootNodes.add(node);
            }
        }
        //2.构建根节点的子节点
        for(Node rootNode : rootNodes){
            buildChildNodes(rootNode);
            treeNodes.add(rootNode);
        }

        return treeNodes;
    }


    //递归子节点
    public void buildChildNodes(Node node){
        List<Node> children = new ArrayList<>();
        //查询节点的所有子节点
        for(Node childNode :nodes){
            if(!StringUtils.isEmpty(childNode.getpId())){
                if(childNode.getpId().equals(node.getId())){
                    children.add(childNode);
                }
            }
        }
        if(!children.isEmpty()){
            for(Node child : children){
                buildChildNodes(child);
            }
            node.setNodes(children);
        }
    }





    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}

package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private int id;
    private TreeNode parentNode;
    private List<TreeNode> childList;

    public TreeNode() {
        initChildList();
    }

    public void initChildList() {
        if (childList == null)
            childList = new ArrayList<TreeNode>();
    }

    public static String traverseTree(TreeNode treeNode){
        StringBuilder builder = new StringBuilder();
        for (TreeNode cNode : treeNode.getChildList()) {
            if (cNode.getChildList().size() > 0 ) {
                builder.append(traverseTree(cNode));
            }else {
                while (cNode.getParentNode() != null){
                    builder.append(cNode.getId() + ",");
                    cNode = cNode.getParentNode();
                }
                builder.append("0");
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public List<TreeNode> getChildList() {
        return childList;
    }

    public void setChildList(List<TreeNode> childList) {
        this.childList = childList;
    }
}

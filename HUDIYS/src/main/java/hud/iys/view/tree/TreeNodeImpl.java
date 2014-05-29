package hud.iys.view.tree;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

public class TreeNodeImpl extends DefaultTreeNode {
 
    private static final long serialVersionUID = 5333810777428638968L;
 
    public TreeNodeImpl(TreeNodeType type, Object data, TreeNode parent) {
        super(type.getType(), data, parent);
    }
 
    public TreeNodeImpl(Object data, TreeNode parent) {
        super(data, parent);
    }
 
    
    @Override
    public String getType() {
        if (isLeaf()) {
            return TreeNodeType.LEAF.getType();
        } else {
            return TreeNodeType.NODE.getType();
        }
    }
}
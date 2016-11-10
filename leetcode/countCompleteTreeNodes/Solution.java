public class Solution {
    public int depth(TreeNode root){
        if(root.right==null)return 1;
        return depth(root.right) + 1;
    }
    
    public int find(TreeNode root, int now){
        if(root.left == null) return (now - 1) * 2 + 1;
        if(root.right == null) return now * 2; 
        
        if(depth(root) == depth(root.left) + 1) return find(root.left, now * 2);
        return find(root.right, now * 2 + 1);
    }
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return find(root,1);
    }
}
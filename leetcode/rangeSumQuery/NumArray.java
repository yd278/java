public class NumArray {
    public class TreeNode{
        public int left,right;
        public int val;
        public TreeNode lSon,rSon;
        public TreeNode(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    TreeNode root;
    int[] nums;
    public void build(TreeNode t){
        if(t.left == t.right){
            t.val = nums[t.left];
            return;
        }
        
        int mid = (t.left + t.right) >> 1;
        t.lSon = new TreeNode(t.left, mid);
        build(t.lSon);
        t.rSon = new TreeNode(mid + 1, t.right);
        build(t.rSon);
        t.val = t.lSon.val + t.rSon.val;
        
    }
    
    public void mUpdate(TreeNode t, int i, int val){
        if(t.left == t.right){
            t.val = val;
            return;
        }
        int mid = (t.left + t.right) >> 1;
        if(i <= mid) mUpdate(t.lSon, i, val);
        else         mUpdate(t.rSon, i, val);
        t.val = t.lSon.val + t.rSon.val;
    }
    
    public int query(TreeNode t, int l, int r)
    {
        if((t.left == l)&&(t.right == r)) return t.val;
        int mid = (t.left + t.right) >> 1;
        if(r <= mid) return query(t.lSon, l, r);
        if(l >  mid) return query(t.rSon, l, r);
        return query(t.lSon, l, mid) + query(t.rSon, mid + 1, r);
    }
    
    public NumArray(int[] nums) {
        this.nums = nums;
        root = new TreeNode(0,nums.length - 1);
        build(root);
    }

    void update(int i, int val) {
        mUpdate(root, i, val);
    }

    public int sumRange(int i, int j) {
        return query(root, i, j);
    }
}


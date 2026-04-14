class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }else{
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root);
            while(!q.isEmpty()){
               
                  
                for(int i =0;i<q.size();i++){
                    TreeNode temp = q.poll();
                    TreeNode temp1 = temp.left;
                    temp.left= temp.right;
                    temp.right= temp1;
                    if(temp.left!=null){
                            q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }
                    
                   
                }
            }
        }
        return root;
    }
}

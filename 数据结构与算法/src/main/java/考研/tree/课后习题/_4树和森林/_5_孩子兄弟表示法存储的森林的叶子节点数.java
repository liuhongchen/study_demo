package 考研.tree.课后习题._4树和森林;

import model.ChildBroNode;

import java.util.List;

public class _5_孩子兄弟表示法存储的森林的叶子节点数 {


    /**
     * m1+m2=错解，不是让遍历所有的孩子兄弟二叉树找出树的节点，而是把它们还原成树之后的
     */
    public Integer m1(List<ChildBroNode> forest){
        if (forest==null||forest.isEmpty())return 0;

        Integer res=0;

        for (ChildBroNode root : forest) {
            res+=m2(root);
        }

        return res;
    }


    public Integer m2(ChildBroNode root){
        if (root==null)return 0;
        int res=0;
        if (root.child==null){
            res++;
        }else{
            res+=m2(root.child);
        }

        if (root.bro!=null)res+=m2(root.bro);

        return res;
    }




}

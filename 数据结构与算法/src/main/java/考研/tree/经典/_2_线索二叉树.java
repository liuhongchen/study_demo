package 考研.tree.经典;

import model.ThreadNode;
import org.junit.Test;

public class _2_线索二叉树 {

    public void InThread(ThreadNode pre,ThreadNode p){
        if (p!=null){
            InThread(p.left,pre);

            if (p.left==null){
                p.left=pre;
                p.ltag=1;
            }
            if (pre!=null&&pre.right==null){
                pre.right=p;
                pre.rtag=1;
            }
            pre=p;
            InThread(p.right,pre);

        }
    }

    @Test
    public void test(){

    }




}

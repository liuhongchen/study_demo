package 考研.tree.经典;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

public class _3_BST {


    public void insert(TreeNode root,int val){

    }



    @Test
    public void test(){
        TreeNode tree = MyUtil.createTreeByPreIn(
                new int[]{6, 2, 1, 4, 3, 5, 8},
                new int[]{1, 2, 3, 4, 5, 6, 8});

        System.out.println(tree);
        System.out.println();

    }
}

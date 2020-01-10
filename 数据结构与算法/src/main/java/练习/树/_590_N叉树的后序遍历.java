package 练习.树;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:_590_N叉树的后序遍历
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 12:29
 * @author:892698613@qq.com
 */
public class _590_N叉树的后序遍历 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (root.children == null || root.children.size() == 0) {
            res.add(root.val);
            return res;
        }
        for (Node child : root.children) {
            res.addAll(postorder(child));
        }
        res.add(root.val);
        return res;
    }


}

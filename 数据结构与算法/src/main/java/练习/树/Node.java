package 练习.树;

import java.util.List;

/**
 * ClassName:Node
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 09:59
 * @author:892698613@qq.com
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}

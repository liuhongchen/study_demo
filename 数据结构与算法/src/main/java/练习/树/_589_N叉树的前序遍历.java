package 练习.树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:_589_N叉树的前序遍历
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 09:59
 * @author:892698613@qq.com
 */
public class _589_N叉树的前序遍历 {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        if (root.children != null && root.children.size() > 0) {
            for (Node child : root.children) {
                result.addAll(preorder(child));
            }
        }
        return result;
    }

    //wrong
    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> stack=new Stack<>();
        result.add(root.val);
        ac:while (root.children!=null&&root.children.size()>0){
            Iterator<Node> iterator = root.children.iterator();
            while (iterator.hasNext()){
                Node child=iterator.next();
                result.add(child.val);
                if (child.children==null||child.children.size()==0){
                    iterator.remove();
                }else{
                    stack.push(root);
                    root=child;
                    continue ac;
                }
            }

            if (stack.size()>0){
                Node temp=root;
                root=stack.pop();
                if (root==temp&&stack.size()>0)root=stack.pop();
                root.children.remove(temp);

            }
        }
        return result;
    }

    @Test
    public void test(){
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node3=new Node(3);
        List<Node> node3Children=new ArrayList<>();
        node3Children.add(node5);
        node3Children.add(node6);
        node3.children=node3Children;
        Node node2=new Node(2);
        Node node4=new Node(4);
        List<Node> node1Children=new ArrayList<>();
        node1Children.add(node3);
        node1Children.add(node2);
        node1Children.add(node4);
        Node node1=new Node(1);
        node1.children=node1Children;
        List<Integer> integers = preorder2(node1);
        System.out.println(integers);
    }
}

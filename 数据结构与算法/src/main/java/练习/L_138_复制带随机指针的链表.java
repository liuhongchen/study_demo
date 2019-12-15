package 练习;

import org.jetbrains.annotations.NotNull;

public class L_138_复制带随机指针的链表 {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }


    public Node copyRandomList(@NotNull Node head) {
        Node node=new Node();
        node.val=head.val;
        node.next=head.next;
        node.random=head.random;
        return null;
    }


}

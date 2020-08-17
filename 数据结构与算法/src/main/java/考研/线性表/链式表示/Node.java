package 考研.线性表.链式表示;

public class Node {
    public Integer val;
    public Node next;


    public Node() {
    }

    public Node(Integer val) {
        this.val = val;
    }

    public Node(Integer val, Node next) {
        this.val = val;
        this.next = next;
    }


}

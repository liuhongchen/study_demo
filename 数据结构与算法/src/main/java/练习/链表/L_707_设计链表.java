package 练习.链表;


public class L_707_设计链表 {


    static class MyLinkedList {


        private int size;
        private Node first;
        private Node last;

        public MyLinkedList() {
            size = 0;
        }


        public int get(int index)  {
            if (index<0||index>=size) return -1;
            int mid = size / 2;
            if (index < mid) {
                Node temp = first;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
                return temp.val;
            } else {
                Node temp = last;
                for (int i = 0; i < size-index-1; i++) {
                    temp = temp.prev;
                }
                return temp.val;
            }
        }



        public void addAtHead(int val) {
            Node node = new Node(val);
            if (size==0){
                first=node;
                last=node;
                size++;
                return;
            }
            node.next = first;
            first.prev = node;
            first = node;
            size++;
        }


        public void addAtTail(int val) {
            Node node = new Node(val);
            if (size==0){
                first=node;
                last=node;
                size++;
                return;
            }
            last.next = node;
            node.prev = last;
            last = node;
            size++;
        }


        public void addAtIndex(int index, int val)  {
            if (index<=0){
                addAtHead(val);
                return;
            }
            if (index==size-1) {
                addAtTail(val);
                return;
            }
            if (index>=size){
                addAtTail(val);
                return;
            }
            Node oldNode = getNode(index);
            Node newNode = new Node(val);

            oldNode.prev.next = newNode;
            newNode.prev = oldNode.prev;
            newNode.next = oldNode;
            oldNode.prev = newNode;
            size++;
        }

        private Node getNode(int index) {
            if (index<0||index>=size)return null;
            int mid = size / 2;
            if (index < mid) {
                Node temp = first;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
                return temp;
            } else {
                Node temp = last;
                for (int i = 0; i < size-index-1; i++) {
                    temp = temp.prev;
                }
                return temp;
            }
        }


        public void deleteAtIndex(int index) {
            Node node = getNode(index);
            if (node==null)return;
            if (index==0){
                first=first.next;
                return;
            }
            if (index==size-1){
                last=last.prev;
                return;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public class Node<E> {
            public int val;
            public Node prev;
            public Node next;

            public Node(int x) {
                val = x;
            }
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(7);
        obj.addAtTail(0);
        obj.deleteAtIndex(1);
        obj.addAtTail(5);
        obj.addAtIndex(1,1);
        obj.addAtIndex(2,6);
        obj.deleteAtIndex(2);
        obj.deleteAtIndex(1);
        obj.addAtTail(7);
        obj.addAtIndex(1,7);
        obj.addAtTail(6);
//        System.out.println(obj.get(0));

//        obj.addAtTail(3);
//        System.out.println(obj.get(0));
//        System.out.println(obj.get(1));
//        System.out.println(obj.get(2));
//        System.out.println(obj.get(3));
//        obj.deleteAtIndex(1);

    }
}

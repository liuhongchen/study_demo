package 练习.链表;

import com.d03_LinkedList.ListNode;

/**
 * ClassName:L_83_删除排序链表中的重复元素
 * Package:com.d03_LinkedList.test
 * Description:
 *
 * @date:2019-12-10 13:44
 * @author:892698613@qq.com
 */
public class _83_删除排序链表中的重复元素 {


    public ListNode deleteDuplicates(ListNode head) {

        if (head==null)return null;
        int val=head.val;
        ListNode listNode=new ListNode(val);
        ListNode temp=listNode;
        while (head!=null){
            if (head.val!=val){
                val=head.val;
                temp.next=new ListNode(val);
                temp=temp.next;
            }
            head=head.next;
        }

        return listNode;
    }
}

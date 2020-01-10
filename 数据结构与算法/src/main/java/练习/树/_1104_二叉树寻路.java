package 练习.树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName:_1104_二叉树寻路
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 19:06
 * @author:892698613@qq.com
 */
public class _1104_二叉树寻路 {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        if (label <= 0) return list;
        list.add(label);
        if (label==1)return list;
        if (label==2||label==3){
            list.add(1);
            Collections.reverse(list);
            return list;
        }
        int depth = getDepth(label);

        int curLabel = label;
        int curMax = (int) Math.pow(2, depth) - 1;
        int lastIndex = (curMax + 2 - label) / 2;
        int lastMin = (int) Math.pow(2, depth - 2);
        int lastLabel = lastMin + lastIndex - 1;
        list.add(lastLabel);
        boolean flag = true;
        while (list.size() < depth) {
            if (flag) {
                label = curLabel;
                if (label<4){
                    list.add(1);
                    break;
                }
                label /= 4;
                list.add(label);
                curLabel = label;
                flag = false;
            } else {
                label = lastLabel;
                if (label<4){
                    list.add(1);
                    break;
                }
                label /= 4;
                list.add(label);
                lastLabel = label;
                flag = true;
            }
        }
        Collections.reverse(list);
        return list;
    }

    private int getDepth(int label) {
        int i = 0;
        while (true) {
            if (Math.pow(2, i) <= label && label < Math.pow(2, i + 1)) return i + 1;
            i++;
        }
    }

    @Test
    public void test() {
        pathInZigZagTree(16);
    }
}

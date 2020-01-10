package 练习.树;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:_96_不同的BST
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-09 10:01
 * @author:892698613@qq.com
 */
public class _96_不同的BST {

    public int numTrees(int n) {
        if(n<0)return 0;
        switch (n){
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 5;
            case 4:
                return 14;
            case 5:
                return 42;
        }
        int res = 0;
        int mid = n / 2;
        for (int i = 1; i <= mid; i++) {
            res += (numTrees(i - 1) * numTrees(n - i));
        }
        res *= 2;
        if (n % 2 != 0) res += (numTrees(mid) * numTrees(mid));

        return res;
    }
}

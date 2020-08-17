package 练习.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:_119_杨辉三角
 * Package:练习.数组
 * Description:
 *
 * @date:2020-01-19 14:20
 * @author:892698613@qq.com
 */
public class _119_杨辉三角 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        ans.add(1);
        if (rowIndex==0)return ans;
        if (rowIndex==1){
            ans.add(1);
            return ans;
        }
        List<Integer> lastRow = getRow(rowIndex - 1);
        for (int i=1;i<rowIndex;i++){
            ans.add(lastRow.get(i-1)+lastRow.get(i));
        }
        ans.add(1);
        return ans;


    }

}

package 练习.数组;

/**
 * ClassName:_11_盛水最多的容器
 * Package:练习.数组
 * Description:
 *
 * @date:2020-01-17 22:09
 * @author:892698613@qq.com
 */
public class _11_盛水最多的容器 {


    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}

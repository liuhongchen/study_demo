import java.util.ArrayList;

/**
 * ClassName:Main
 * Package:PACKAGE_NAME
 * Description:
 *
 * @date:2019-12-27 13:44
 * @author:892698613@qq.com
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1},{2}};
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int direction = 1;
        int i = 0;
        int j = arr[0].length - 1;
        int m = arr.length - 1;
        int n = 0;
        int size = 0;
        for (int[] in : arr) {
            size += in.length;
        }
        while (arrayList.size() < size) {
            while (true) {
                switch (direction % 4) {
                    case 1:
                        for (int k = n; k < j; k++) {
                            arrayList.add(arr[i][k]);
                        }
                        break;
                    case 2:
                        for (int k = i; k < m; k++) {
                            arrayList.add(arr[k][j]);
                        }
                        break;
                    case 3:
                        for (int k = j; k > n; k--) {
                            arrayList.add(arr[m][k]);
                        }
                        break;
                    default:
                        for (int k = m; k > i; k--) {
                            arrayList.add(arr[k][n]);
                        }
                        break;
                }
                direction++;
                if (direction == 5) {
                    direction = 1;
                    break;
                }
            }
            i++;
            j--;
            m--;
            n++;
        }
        System.out.println(arrayList);
    }


}

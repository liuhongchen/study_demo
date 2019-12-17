package 练习.栈;



public class _739_每日温度 {

    public static int[] dailyTemperatures(int[] T) {
        if (T==null||T.length==0) return T;

        int len=T.length;
        for (int i=0;i<len;i++){
            int tmp = T[i];
            if (i+1<len&&T[i+1]>tmp){
                T[i]=1;
                continue;
            }
            int count=0;
            boolean flag=false;
            for (int j=i+1;j<len;j++){
                count++;
                if (T[j]>T[i]){
                    flag=true;
                    break;
                }
            }

            if (flag){
                T[i]=count;
            }else{
                T[i]=0;
            }
        }
        return T;
    }

    public static void main(String[] args) {

        int[] list={73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemperatures(list).toString());
    }
}

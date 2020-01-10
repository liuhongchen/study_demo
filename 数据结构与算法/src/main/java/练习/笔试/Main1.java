package 练习.笔试;

import java.util.*;
import java.util.regex.Pattern;

/**
 * ClassName:Main1
 * Package:练习.笔试
 * Description:
 *
 * @date:2019-12-21 19:02
 * @author:892698613@qq.com
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<String> legal=new LinkedHashSet<>();
        ArrayList<String> illegal=new ArrayList<>();
        String s;
        while (!((s=sc.nextLine()).equals(""))){
            boolean flag=true;
            for(char cc:s.toCharArray()){
                String c=String.valueOf(cc);
                if(!Pattern.matches("\\d",c)){

                    flag=false;

                    break;
                }
            }
            if(flag){
                legal.add(s);
            }else{
                illegal.add(s);
            }

        }

        for(String ss:legal){
            System.out.print(ss+" ");
        }
        System.out.println();
        for(String ss:illegal){
            System.out.print(ss+" ");
        }

    }

}

package 练习.笔试;

import com.sun.org.apache.regexp.internal.RE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ClassName:Main3
 * Package:练习.笔试
 * Description:
 *
 * @date:2019-12-21 19:50
 * @author:892698613@qq.com
 */
public class Main3 {

    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
        Stack<String> stack=new Stack<String>();
        Map<String,String> map=new HashMap<>();
        Map<String,TreeSet<String>> resultMap=new TreeMap<>();
        String input;
        while (!(input = sc.nextLine()).equals("")){
            if (input==null||input.length()==0)continue;
            String[] result=input.split("\\|");

            if(result.length==7){
                StringBuilder sb=new StringBuilder();
                sb.append(result[2].trim());
                sb.append(result[3].trim());
                sb.append(result[4].trim());
                if (result[6].trim().startsWith("[ENTER]")){
                    map.put(sb.toString(),result[0]);
                } else if(result[6].trim().startsWith("[EXIT]")) {
                    String time1 = map.get(sb.toString());
                    map.remove(sb.toString());
                    String time2=result[0];
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss,SSS");
                    Long time11=sdf.parse(time1).getTime();
                    Long time22=sdf.parse(time2).getTime();
                    Long time=time22-time11;

                    String sb1 = result[4].trim() + ","+time;
                    TreeSet<String> set = resultMap.get(result[3]);

                    boolean flag=false;
                    if (set!=null&&set.size()>0) {
                        for (String sss : set) {
                            if (sss.startsWith(result[4])) {
                                String timeOrin = sss.split(",")[1];
                                Long origin = Long.parseLong(timeOrin);
                                if (time > origin) {
                                    set.add(sb1);
                                    resultMap.put(result[3], set);
                                }
                                flag=true;
                                break;
                            }
                        }
                    }else{
                        set=new TreeSet<>();
                        set.add(sb1);
                        resultMap.put(result[3], set);
                    }
                    if (!flag){
                        set.add(sb1);
                        resultMap.put(result[3], set);
                    }
                }
            }
        }


        Set<String> keySet = resultMap.keySet();

        for(String key:keySet){
            System.out.println(key.trim()+":");
            TreeSet<String> treeSet = resultMap.get(key);
            for(String value:treeSet){
                System.out.println(value);
            }
            System.out.println();
        }
    }
}

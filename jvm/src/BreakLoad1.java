import hello.String;

/**
 * ClassName:BreakLoad1
 * Package:PACKAGE_NAME
 * Description:
 *
 * @date: 2023-03-17 10:14
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class BreakLoad1 {



    public static class MyLoad extends ClassLoader{
//
//        @Override
//        public Class<?> loadClass(String name) throws ClassNotFoundException {
//            File file = new File("d:/test/"+name.replace(".","/").concat(".class"));
//            if (!file.exists()){
//                return super.loadClass(name);
//            }
//            try {
//                InputStream is = new FileInputStream(file);
//                byte[] b = new byte[is.available()];
//                is.read(b);
//                return defineClass(name,b,0,b.length);
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//            return super.loadClass(name);
//        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyLoad myLoad = new MyLoad();
        Class clazz1 = myLoad.loadClass("com.example.jvm.demo.Hello");

        myLoad = null;

        myLoad = new MyLoad();
        Class clazz2 = myLoad.loadClass("com.example.jvm.demo.Hello");

        System.out.println(clazz1==clazz2);

    }

}

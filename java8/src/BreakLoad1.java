import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName:BreakLoad1
 * Package:PACKAGE_NAME
 * Description:
 *
 * @date: 2023-03-17 10:14
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class BreakLoad1 {



    class MyLoad extends ClassLoader{

        @Override
        public Class<?> loadClass(java.lang.String name) throws ClassNotFoundException {
            File file = new File(name);
            try {
                InputStream is = new FileInputStream(file);
                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name,b,0,b.length);
            }catch (IOException e){
                e.printStackTrace();
            }
            return super.loadClass(name);
        }

        @Override
        protected Class<?> findClass(java.lang.String name) throws ClassNotFoundException {
            File file = new File(name);
            try {
                InputStream is = new FileInputStream(file);
                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name,b,0,b.length);
            }catch (IOException e){
                e.printStackTrace();
            }
//            return super.loadClass(name);
            return super.findClass(name);
        }
    }

    @Test
    public void test() throws ClassNotFoundException {
        MyLoad myLoad = new MyLoad();
        Class clazz1 = myLoad.loadClass("/Users/admin/IdeaProjects/study/jvm/src/hello/String.class");

        myLoad = null;

        myLoad = new MyLoad();
        Class clazz2 = myLoad.loadClass("/Users/admin/IdeaProjects/study/jvm/src/hello/String.class");

        System.out.println(clazz1==clazz2);
    }


}

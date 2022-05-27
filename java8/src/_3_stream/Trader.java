package _3_stream;

/**
 * ClassName:Trader
 * Package:_3_stream
 * Description:
 *
 * @date: 2022-05-26 18:57
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}


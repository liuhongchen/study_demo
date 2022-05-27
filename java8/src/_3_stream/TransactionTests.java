package _3_stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName:TransactionTests
 * Package:_3_stream
 * Description:
 *
 * @date: 2022-05-26 18:58
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class TransactionTests {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader brian = new Trader("Brian","Cambridge");
    List<Transaction> transactions = Arrays.asList( new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    /*
        找出2011年发生的所有交易，并按交易额排序(从低到高)。
     */
    @Test
    public void test1() {
        List<Transaction> transactions = this.transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        transactions.forEach(System.out::println);
    }

    /*
        交易员都在哪些不同的城市工作过?
     */
    @Test
    public void test2() {
        List<String> cityList = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        cityList.forEach(System.out::println);
    }

    /*
    查找所有来自于剑桥的交易员，并按姓名排序。
     */
    @Test
    public void test3() {
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        traders.forEach(System.out::println);
    }


    /*
    返回所有交易员的姓名字符串，按字母顺序排序。
     */

    @Test
    public void test4() {
        List<String> names = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        names.forEach(System.out::println);

    }

    /*
    有没有交易员是在米兰工作的?
     */
    @Test
    public void test5() {
        boolean b = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .anyMatch(name -> name.equals("Milan"));
        System.out.println(b);
    }

    /*
    打印生活在剑桥的交易员的所有交易额。
     */
    @Test
    public void test6() {
        Integer sum = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

    }


    /*
    所有交易中，最高的交易额是多少?
     */
    @Test
    public void test7() {
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);

    }

    /*
    找到交易额最小的交易。
     */
    @Test
    public void test8() {
        transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue));

    }
}

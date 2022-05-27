package _3_stream;

/**
 * ClassName:Transaction
 * Package:_3_stream
 * Description:
 *
 * @date: 2022-05-26 18:58
 * @author:Hansing liuhongchengege123@gmail.com
 */

public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " + "value:" + this.value + "}";
    }
}
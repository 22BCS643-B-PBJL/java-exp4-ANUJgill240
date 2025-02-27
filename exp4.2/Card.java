package exp42;


import java.util.*;

public class Card {
    String symbol;
    int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    @Override
    public String toString() {
        return symbol + " " + number;
    }
}

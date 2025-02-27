package exp42;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class CardCollection {
    static Map<String, List<Card>> cardMap = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter Number of Cards: ");
        int n = scanner.nextInt();
        
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter card " + i + " (symbol and number):");
            String symbol = scanner.next();
            int number = scanner.nextInt();
            
            cardMap.putIfAbsent(symbol, new ArrayList<>());
            cardMap.get(symbol).add(new Card(symbol, number));
        }

        displayAllCards();
        searchBySymbol();
    }

    static void displayAllCards() {
        System.out.println("\nDistinct Symbols: " + cardMap.keySet());
        cardMap.keySet().stream().sorted().forEach(symbol -> {
            List<Card> cards = cardMap.get(symbol);
            System.out.println("\nCards in " + symbol + " Symbol");
            cards.forEach(System.out::println);
            System.out.println("Number of cards: " + cards.size());
            System.out.println("Sum of Numbers: " + cards.stream().mapToInt(c -> c.number).sum());
        });
    }

    static void searchBySymbol() {
        System.out.print("\nEnter symbol to search: ");
        String symbol = scanner.next();
        if (cardMap.containsKey(symbol)) {
            System.out.println("Cards in " + symbol + " Symbol:");
            cardMap.get(symbol).forEach(System.out::println);
        } else {
            System.out.println("No cards found for symbol " + symbol);
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCarousel {
    //sprawdza czy instnieje senior do zestawienia
    private static boolean atLeastTwoSeniorsHaveCoins(List<Senior> seniors) {
        int seniorsWithCoinsCounter = 0;
        for (Senior senior: seniors) {
            if (senior.getNumberOfCoins() > 0) {
                seniorsWithCoinsCounter++;
            }
        }
        return seniorsWithCoinsCounter > 2;
    }

    //odejmuje wartości i zestawia porównywane id seniorów
    private static String conversation(Senior s1, Senior s2) {
        s1.setNumberOfCoins(s1.getNumberOfCoins() - 1);
        s2.setNumberOfCoins(s2.getNumberOfCoins() - 1);
        return s1.getID() + "," + s2.getID();
    }

    //generuje losowe pozycje do zestawienia, zapisuje do listy conversations i przekazuje dane do metody powyżej (i nalicza prowizje)
    public static List<String> generateConversationsByRandomSenior(List<Senior> seniors) {
        List<String> conversations = new ArrayList<>();
        int fee = 0;
        Random random = new Random();
        while (atLeastTwoSeniorsHaveCoins(seniors)) {
            List<Senior> seniorsWithCoins = seniors.stream().filter(senior -> senior.getNumberOfCoins() > 0).toList();
            Senior s1 = seniorsWithCoins.get(random.nextInt(seniorsWithCoins.size()));
            Senior s2 = seniorsWithCoins.get(random.nextInt(seniorsWithCoins.size()));
            while (s1 == s2) {
                s2 = seniorsWithCoins.get(random.nextInt(seniorsWithCoins.size()));
            }
            conversations.add(conversation(s1, s2));
            fee++;
        }
        System.out.println("Random senior fee: " + fee);
        return conversations;
    }
}

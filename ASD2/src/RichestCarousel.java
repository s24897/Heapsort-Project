import java.util.ArrayList;
import java.util.List;


public class RichestCarousel {
    //Ta sama metoda co z RandomCarousel
    private static String conversation(Senior s1, Senior s2) {
        s1.setNumberOfCoins(s1.getNumberOfCoins() - 1);
        s2.setNumberOfCoins(s2.getNumberOfCoins() - 1);
        return s1.getID() + "," + s2.getID();
    }



    public static List<String> generateConversationsByRichestSenior(List<Senior> seniors) {
        int Fee = 0;
        List<String> conversations = new ArrayList<>();
        PriorityQueue<Senior> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(seniors);
        while (priorityQueue.size() > 2) {
            // pobieramy seniorów z kolejki
            Senior s1 = priorityQueue.poll();
            Senior s2 = priorityQueue.poll();
            // jeżeli seniorzy posiadają pieniądze to tworzymy konwersację i zapisujemy jej wynik do listy
            if (s1.getNumberOfCoins() > 0 && s2 != null && s2.getNumberOfCoins() > 0) {
                conversations.add(conversation(s1, s2));
                // odkładamy seniorów na kolejkę
                priorityQueue.add(s1);
                priorityQueue.add(s2);
                Fee++;
            }
        }
        System.out.println("Richest senior fee: " + Fee);
        return conversations;
    }
}

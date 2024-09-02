import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String args[]) throws IOException {
        List<Senior> seniors = FileUtils.getSeniorList("datain_200.txt");




        int counter = 0;
        for (Senior senior : seniors) {
            counter += senior.getNumberOfCoins();
        }
        System.out.println(counter);

        List<String> randomConversations = RandomCarousel.generateConversationsByRandomSenior(seniors);
        System.out.println(randomConversations);

        seniors = FileUtils.getSeniorList("datain_200.txt");
        List<String> richestConversations = RichestCarousel.generateConversationsByRichestSenior(seniors);
        System.out.println(richestConversations);


        FileUtils.saveConversationsToFile(seniors.size(), richestConversations);
    }
}

//WNIOSKI:
//W przypadku losowego rozwiązania ciężko było osiągnąc jakąś małą złożoność obliczeniową ze wzglęgu na to że dane są wybierane przez funkcją random.
//Natomiast w przypadku rozwiązania z zastosowaniem kolejki priorytetowej złożoność jest już całkiem przyjemna
//Jeżeli chodzi o to jak w praktyce program Pana Cukierberga powinien funkcjonować uważam, że rozwiązanie losowe jest najlepszym wyborem, ponieważ seniorzy nie będą trafiać na siebie po kilka razy z rzędu.
//Ale jeżeli Panu Cukierbergowi i jego firmie zależałoby tylko i wyłącznie na zyskach to drugie rozwiązanie wydaje się być bardziej optymalne.
//rozwiązanie z zastosowaniem kolejki generuje za każdym razem taki sam zysk (dla 50 jest to 635zł)
//rozwiązanie losowe natomiast często będzie generować mniejsze zyski(dla 50 jest to liczba przeważnie bliska 635) (635 możemy potraktować w tym przypadku jako górną granicę)
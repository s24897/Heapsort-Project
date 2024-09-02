import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<Senior> getSeniorList(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("./data/" + fileName))) {
            String line = br.readLine();
            String[] seniorData = line.split("\\s");
            List<Senior> seniors = new ArrayList<>();
            int size = Integer.parseInt(seniorData[0]);
            for (int i = 0; i < size; i++) {
                seniors.add(new Senior(i + 1, Integer.parseInt(seniorData[i + 1])));
            }
            return seniors;
        }
    }

    public static void saveConversationsToFile(int size, List<String> conversation) throws IOException {
        String conversationString = String.join(" ", conversation);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/dataout_" + size + ".txt"))) {
            bw.write(conversationString);
        }
    }
}

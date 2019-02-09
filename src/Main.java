import sun.text.normalizer.UTF16;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        generateRandomBits();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8));
        BufferedWriter resultWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"),StandardCharsets.UTF_8));

        int finalCounter = 0;
        int counter = 0;
        int symbol = 0;

        while ((symbol = reader.read()) != -1){
            char c = (char) symbol;
            if (c == '1') {
                counter++;
            }else {
                if (finalCounter < counter) {
                    finalCounter = counter;
                }
                counter=0;
            }
        }

        resultWriter.append(Integer.toString(finalCounter));
        resultWriter.flush();
        resultWriter.close();
    }
        private static void generateRandomBits () {
            try {
                FileWriter fileWriter = new FileWriter("input.txt");
                    for (int i = 0; i < 100; i++) {
                        int num = (int) Math.round(Math.random());
                        fileWriter.write(Integer.toString(num));
                        fileWriter.flush();
                    }
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
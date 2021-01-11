package cs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Overlook {

    static int year = 2008;
    public static String path = "\\C:\\Users\\Liam\\Documents\\NBA_" + year
            + ".csv";

    public static void setPath(String s) {
        path = s;
    }

    public static List<Player> trial;

    public static void runnit() {
        int buffer = 0;

        trial = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

            String line = "";

            while ((line = bf.readLine()) != null) {
                String[] values = line.split(",");
                Queue<String> sendToPlayers = new LinkedList<>();
                if (values.length == 29) {
                    for (int i = 0; i < values.length; i++) {
                        sendToPlayers.add(values[i]);
                    }

                    Player player = new Player();
                    if (buffer == 1) {

                        player.createFromQueue(values);
                        trial.add(player);
                    } else {
                        buffer++;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        }

    }

}

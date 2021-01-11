package cs;

import java.util.LinkedList;
import java.util.List;

public class AISorter {

    /*
     * StackOverflow Code
     *
     */
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    List<Player> playerList = new LinkedList<Player>();
    public static String ptsP[] = { "", "", "", "", "", "", "", "", "", "" };
    public static double numP[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    public static String rebP[] = { "", "", "", "", "", "", "", "", "", "" };
    public static double numR[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    /*
     * This class takes a list of players and determines the best.
     */
    //Will fill out the HashMaps
    public static void determine(List<Player> p) {

        /*
         * Sorts through all players and determines the best at a particular
         * skill
         */

        for (Player player : p) {

            //Points

            for (int i = 0; i < 9; i++) {
                if (player.pts / player.games > numP[i]) {
                    //Shift everything down from here

                    for (int t = numP.length - 1; t > i; t--) {
                        numP[t] = numP[t - 1];
                        ptsP[t] = ptsP[t - 1];
                    }
                    numP[i] = round(player.pts / player.games, 2);
                    ptsP[i] = player.name;
                    break;
                }
            }

            //Rebs

            for (int i = 0; i < 9; i++) {
                if (player.trb / player.games > numR[i]) {
                    //Shift everything down from here

                    for (int t = numR.length - 1; t > i; t--) {
                        numR[t] = numR[t - 1];
                        rebP[t] = rebP[t - 1];
                    }

                    numR[i] = round(player.trb / player.games, 2);
                    rebP[i] = player.name;
                    break;
                }
            }

            //Asts
        }

    }

}

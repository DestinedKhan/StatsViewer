package cs;

import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    /*
     * Want to be able to look at any year, and don't really wanna save all the
     * years so may end up pulling from a website.
     *
     */

    /*
     * TO-DO 1. Website setup/uploading 2. Better cards for the players
     *
     */

    /*
     * Better cards for the players, need data shown in an appropriate way
     */

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        Overlook o = new Overlook();
        AISorter timmy = new AISorter();
        List<Player> p = new LinkedList<Player>();
        Overlook.runnit();
        p = Overlook.trial;
        timmy.determine(p);

        FlowPane grid = new FlowPane();
        grid.setMaxHeight(300);
        HBox ho = new HBox();
        Button pt = new Button("PTS Leaders");
        pt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                VBox stats = new VBox();
                stats.setLayoutX(10);
                stats.setLayoutY(10);
                List<Text> t = new LinkedList<Text>();

                if (ho.getChildren().size() > 0) {
                    ho.getChildren().remove(0);
                }
                for (int i = 0; i < 9; i++) {
                    t.add(new Text(
                            "" + timmy.ptsP[i] + "    " + timmy.numP[i]));

                }

                stats.getChildren().addAll(t);

                ho.getChildren().add(stats);
                /*
                 * Display stats on other side of page.
                 */

            }

        });
        Button rl = new Button("REB Leaders");

        //Leader Buttons Edited out for now, dont work

        //ho.getChildren().add(pt);
        //ho.getChildren().add(rl);
        VBox h3 = new VBox();
        h3.setLayoutX(10);
        h3.setSpacing(10);

        Group g = new Group();
        List<Node> l = new LinkedList<Node>();

        for (int i = 0; i < p.size(); i++) {
            /*
             * Need to flesh this part out so that it's not text but a button
             * that can display stats.
             */
            Player currentPlayer = p.remove(0);
            String n = currentPlayer.name;
            Button b = new Button(n);

            /*
             * This button should bring up stats on the next page, which should
             * be
             */
            b.setPadding(new Insets(10, 10, 10, 10));
            b.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    final Stage stage = new Stage();

                    VBox stats = new VBox();
                    stats.setLayoutX(10);
                    stats.setLayoutY(10);
                    if (ho.getChildren().size() > 0) {
                        ho.getChildren().remove(0);
                    }
                    Text team = new Text("Team: " + currentPlayer.team);
                    Text ppg = new Text("PPG: " + round(
                            (currentPlayer.pts / currentPlayer.games), 2));

                    Text rpg = new Text("RPG: " + round(
                            (currentPlayer.trb / currentPlayer.games), 2));
                    Text apg = new Text("APG: " + round(
                            (currentPlayer.ast / currentPlayer.games), 2));
                    Text stl = new Text("STL/G: " + round(
                            (currentPlayer.stl / currentPlayer.games), 2));
                    List<Text> stat = new LinkedList<Text>();
                    stat.add(team);
                    stat.add(ppg);
                    stat.add(rpg);
                    stat.add(apg);
                    stat.add(stl);
                    stats.getChildren().addAll(stat);
                    ho.getChildren().add(stats);

                    Scene st = new Scene(ho);
                    stage.setScene(st);
                    stage.show();
                    /*
                     * Display stats on other side of page.
                     */
                    b.setEffect(new DropShadow());
                }

            });
            //Text l = new Text(p.remove(0).name);
            g.getChildren().add(b);
            l.add(b);
        }
        /*
         *
         */

        SplitPane pane = new SplitPane();
//        ScrollPane aa = new ScrollPane();
//        aa.setContent(h3);
//        aa.setVbarPolicy(ScrollBarPolicy.ALWAYS);
//        aa.heightProperty().addListener((observable, oldValue, newValue) -> {
//            aa.setVvalue(newValue.doubleValue());
//        });
//
//        aa.setPadding(new Insets(20, 0, 0, 0));
//        aa.setPannable(true);
//        aa.setFitToHeight(false);

        /*
         * 10/25/20
         *
         * Fixed the scrolling so that all players are finally viewable
         *
         * Need to clean this code up and separate it into classes as well as
         * upload it to Github so I can get those green squares
         *
         * Need to add cards to popup when each player is clicked so that the
         * scrolling is less of a problem.
         *
         * Could break this up into MVC
         *
         *
         *
         */
        pane.autosize();
        h3.minWidth(100);
        pane.getItems().addAll(h3, ho);
        grid.getChildren().addAll(new ScrollPane(pane));

        primaryStage.setTitle("NBA");
        primaryStage.setScene(new Scene(new ScrollPane(grid), 400, 300));
        primaryStage.setResizable(true);
        primaryStage.show();

        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.size());
            h3.getChildren().add(l.remove(i));
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}

package cs;

public class Player {
    String pos;
    String name;
    String team;
    double games;
    double gamesStarted;
    double minutesPlayed;
    double fg;
    double fga;
    double fgp;
    double tp;
    double tpa;
    double tpp;
    double top;
    double topa;
    double topp;
    double efg;
    double ft;
    double fta;
    double ftp;
    double orb;
    double drb;
    double trb;
    double ast;
    double stl;
    double blk;
    double tov;
    double pf;
    double pts;
    double age;
    double check = 0;

    public void createFromQueue(String[] p) {
        for (int i = 0; i < 29; i++) {
            if (p[i].isEmpty()) {
                p[i] = "0";

            }
        }

        if (p.length == 29 && this.check == 0 && !p[0].isEmpty()) {
            this.check = 1;
            for (int i = 0; i < 29; i++) {
                switch (i) {
                    case 0:

                        this.name = p[0];

                        break;
                    case 1:
                        this.pos = p[1];
                        break;
                    case 2:
                        this.age = Double.parseDouble(p[2]);
                        break;
                    case 3:
                        this.team = p[3];
                        break;
                    case 4:
                        this.games = Double.parseDouble(p[4]);
                        break;
                    case 5:
                        this.gamesStarted = Double.parseDouble(p[5]);
                        break;
                    case 6:
                        this.minutesPlayed = Double.parseDouble(p[6]);
                        break;
                    case 7:
                        this.fg = Double.parseDouble(p[7]);
                        break;
                    case 8:
                        this.fga = Double.parseDouble(p[8]);
                    case 9:
                        this.fgp = Double.parseDouble(p[9]);
                    case 10:
                        this.tp = Double.parseDouble(p[10]);
                    case 11:
                        this.tpa = Double.parseDouble(p[11]);
                    case 12:
                        this.tpp = Double.parseDouble(p[12]);

                    case 13:
                        this.top = Double.parseDouble(p[13]);

                    case 14:
                        this.topa = Double.parseDouble(p[14]);

                    case 15:
                        this.topp = Double.parseDouble(p[15]);

                    case 16:
                        this.efg = Double.parseDouble(p[16]);

                    case 17:
                        this.ft = Double.parseDouble(p[17]);

                    case 18:
                        this.fta = Double.parseDouble(p[18]);

                    case 19:
                        this.ftp = Double.parseDouble(p[19]);

                    case 20:
                        this.orb = Double.parseDouble(p[20]);

                    case 21:
                        this.drb = Double.parseDouble(p[21]);

                    case 22:
                        this.trb = Double.parseDouble(p[22]);

                    case 23:
                        this.ast = Double.parseDouble(p[23]);

                    case 24:
                        this.stl = Double.parseDouble(p[24]);

                    case 25:
                        this.blk = Double.parseDouble(p[25]);

                    case 26:
                        this.tov = Double.parseDouble(p[26]);

                    case 27:
                        this.pf = Double.parseDouble(p[27]);

                    case 28:
                        this.pts = Double.parseDouble(p[28]);
                }
            }
        }

    }
}

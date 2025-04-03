package dynamic_beat_11;

import javax.swing.*;
import java.awt.*;

import static dynamic_beat_11.DynamicBeat.game;

public class Note extends Thread {

    private Image noteBasicImage = new ImageIcon(Main.class.getResource("/images/noteBasic.png")).getImage();
    private Image goodImage = new ImageIcon(Main.class.getResource("/images/Good.png")).getImage();

    private int x;
    private int y = 0; // 이게 -120이라는데 왜 -120이지
    private String noteType;
    private boolean proceeded = true;

    public String getNoteType() {
        return noteType;
    }

    public boolean isProceeded() {
        return proceeded;
    }

    public void close() {
        proceeded = false;
    }

    public Note(String noteType) {
        if (noteType.equals("S")) {
            x = 228;
        } else if (noteType.equals("D")) {
            x = 332;
        } else if (noteType.equals("F")) {
            x = 436;
        } else if (noteType.equals("Space")) {
            x = 540;
        } else if (noteType.equals("J")) {
            x = 744;
        } else if (noteType.equals("K")) {
            x = 848;
        } else if (noteType.equals("L")) {
            x = 952;
        }

        this.noteType = noteType;
    }


    public void screenDraw(Graphics2D g) {
        if (!noteType.equals("Space")) {
            g.drawImage(noteBasicImage, x, y, null);

        } else if (noteType.equals("Space")) {
            g.drawImage(noteBasicImage, x, y, null);
            g.drawImage(noteBasicImage, x + 100, y, null);
        }
    }


    public synchronized void drop() {
        y += Main.NOTE_SPEED;
        if(game.isClosed){
            close();
        }
        if(y>620&&y<628) {
            System.out.println("Miss");
            Main.score -= 100;
        }   if (y > 630) {
                close();
            }

    }

    @Override
    public synchronized void run() {
        try {
            while (true) {
                drop();
                if (proceeded) {
                    Thread.sleep(Main.SLEEP_TIME);
                } else {
                    interrupt();
                    break;
                }
                Thread.sleep(Main.SLEEP_TIME);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public String judge() {
        if (y>620){
            return "Miss";
            }

        else if (y > 613) {
            System.out.println("Late");
            Main.score -= 50;
            close();
            return "Late";
        } else if (y >= 600) {
            System.out.println("Good");
            Main.score += 50;
            close();
            return "Good";
        } else if (y >= 587) {
            System.out.println("Great");
            Main.score += 75;
            close();
            return "Great";
        } else if (y >= 573) {
            System.out.println("Perfect");
            Main.score += 100;
            close();
            return "Perfect";
        } else if (y >= 565) {
            System.out.println("Great");
            Main.score += 75;
            close();
            return "Great";
        } else if (y >=550) {
            System.out.println("Good");
            Main.score += 50;
            close();
            return "Good";
        } else if (y < 550) {
            System.out.println("Early");
            Main.score -= 50;
            close();
            return "Early";
        }
    return "None";
    }

    public int getY(){
        return y;
    }
}


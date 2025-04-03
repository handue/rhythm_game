package dynamic_beat_11;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Game extends Thread{
    private Image noteRouteLine = new ImageIcon(Main.class.getResource("/images/noteRouteLine.png")).getImage();
    private Image judgementLineImage = new ImageIcon((Main.class.getResource("/images/judgementLine.png"))).getImage();
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("/images/gameinfo.png")).getImage();;
    private Image noteRouteImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();

    private Image noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image blueFlareImage ;
    private Image judgeImage;
    /*private Image judgeGoodImage = new ImageIcon(Main.class.getResource("/images/Good.png")).getImage();
    private Image judgeGreatImage = new ImageIcon(Main.class.getResource("/images/Great.png")).getImage();
    private Image judgeLateImage = new ImageIcon(Main.class.getResource("/images/Late.png")).getImage();
    private Image judgePerfectImage = new ImageIcon(Main.class.getResource("/images/Perfect.png")).getImage();*/
    private Image keyPadSImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadDImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadFImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadJImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadKImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadLImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();


    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;
    public boolean isClosed =false;

    ArrayList<Note> noteList = new ArrayList<Note>();
    String[] keyNames = {"S", "D", "F", "Space", "J", "K", "L"};

    Random random = new Random();

    public Game(String titleName,String difficulty, String musicTitle){
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle,false);
    }

    public void screenDraw(Graphics2D g){

        g.drawImage(noteRouteSImage,228,30,null);
        g.drawImage(noteRouteDImage,332,30,null);
        g.drawImage(noteRouteFImage,436,30,null);
        g.drawImage(noteRouteSpace1Image,540,30,null);
        g.drawImage(noteRouteSpace2Image,640,30,null);
        g.drawImage(noteRouteJImage,744,30,null);
        g.drawImage(noteRouteKImage,848,30,null);
        g.drawImage(noteRouteLImage,952,30,null);

        g.drawImage(noteRouteLine,224,30,null);
        g.drawImage(noteRouteLine,328,30,null);
        g.drawImage(noteRouteLine,432,30,null);
        g.drawImage(noteRouteLine,536,30,null);
        g.drawImage(noteRouteLine,740,30,null);
        g.drawImage(noteRouteLine,844,30,null);
        g.drawImage(noteRouteLine,948,30,null);
        g.drawImage(noteRouteLine,1052,30,null);





        g.drawImage(gameInfoImage,0,660,null);
        g.drawImage(judgementLineImage,0,580,null);
        for(int i =0; i<noteList.size(); i++){
            Note note = noteList.get(i);
            if(note.getY()>620){
                judgeImage = new ImageIcon(Main.class.getResource("/images/Miss.png")).getImage();

            }
            if(!note.isProceeded()){
                noteList.remove(i);
                i--;
            }
            else{
                note.screenDraw(g);
            }
        }

        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);// GUI에서 글씨 선명하게 보이게 하는거
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.drawString(titleName,20,702);  // 현재 재생 노래
        g.drawString(difficulty,1190,702); // 모드
        g.setFont(new Font("Arial",Font.PLAIN,26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S",270,609);
        g.drawString("D",374,609);
        g.drawString("F",478,609);
        g.drawString("Space Bar",580,609);
        g.drawString("J",784,609);
        g.drawString("K",889,609);
        g.drawString("L",993,609);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Elephant",Font.BOLD,30));
        if (Main.score>=0 && Main.score <10){
            g.drawString("00000"+String.valueOf(Main.score),565,702); }// 현재 점수
        else if(Main.score>=10 && Main.score<100){
            g.drawString("0000"+String.valueOf(Main.score),565,702); // 현재 점수
        }
        else if(Main.score>=100 && Main.score<1000){
            g.drawString("000"+String.valueOf(Main.score),565,702); // 현재 점수
        }
        else if(Main.score>=1000 && Main.score<10000){
            g.drawString("00"+String.valueOf(Main.score),565,702); // 현재 점수
        }
        else if(Main.score>=10000 && Main.score<100000){
            g.drawString("0"+String.valueOf(Main.score),565,702); // 현재 점수
        }
        else{
            g.drawString(String.valueOf(Main.score),565,702); // 현재 점수
        }
        g.drawImage(blueFlareImage,320,430,null);

        g.drawImage(judgeImage,470,420,null);
        g.drawImage(keyPadSImage, 228,580,null);
        g.drawImage(keyPadDImage, 332,580,null);
        g.drawImage(keyPadFImage, 436,580,null);
        g.drawImage(keyPadSpace1Image, 540,580,null);
        g.drawImage(keyPadSpace2Image, 640,580,null);
        g.drawImage(keyPadJImage, 744,580,null);
        g.drawImage(keyPadKImage, 848,580,null);
        g.drawImage(keyPadLImage, 952,580,null);

    }



    public void pressS(){
        judge("S");
        noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadSImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("sdf sound.mp3", false).start();


    }
    public void pressD(){
        judge("D");
        noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadDImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("sdf sound.mp3", false).start();
    }
    public void pressF(){
        judge("F");
         noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadFImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("sdf sound.mp3", false).start();
    }

    public void pressSpace(){
        judge("Space");
         noteRouteSpace1Image = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
         noteRouteSpace2Image = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadSpace1Image = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
        keyPadSpace2Image = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("space sound.mp3", false).start();
    }

    public void pressJ(){
        judge("J");
         noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadJImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("sdf sound.mp3", false).start();
    }

    public void pressK(){
        judge("K");
         noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadKImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("sdf sound.mp3", false).start();
    }

    public void pressL(){
        judge("L");
         noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadLImage = new ImageIcon(Main.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("sdf sound.mp3", false).start();
    }

    public void releaseS(){
         noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
         keyPadSImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseD(){
         noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
        keyPadDImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseF(){
         noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
        keyPadFImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseSpace(){
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
        keyPadSpace1Image = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
        keyPadSpace2Image = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseJ(){
         noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
        keyPadJImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseK(){
         noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
        keyPadKImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseL(){
         noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
        keyPadLImage = new ImageIcon(Main.class.getResource("/images/keyPadBasic.png")).getImage();
    }



    @Override
    public synchronized void run(){
        dropNotes(this.titleName);
    }

    public void close(){
        gameMusic.close();
        this.interrupt();
        isClosed = true;
    }

    public synchronized void dropNotes(String titleName){
        while(true){
            Beat[] beats = new Beat[500];
            if(titleName.equals("Joakim Karud - Mighty Love")&& difficulty.equals("Easy")){
                int startTime =7800-1000*Main.REACH_TIME;
                int gap = 525;
                beats = new Beat[] {
                        new Beat(startTime+ gap*1, "S"),
                        new Beat(startTime + gap *3, "D"),
                        new Beat(startTime + gap *5, "S"),
                        new Beat(startTime + gap *7, "D"),
                        new Beat(startTime + gap *9, "S"),
                        new Beat(startTime + gap *11, "D"),
                        new Beat(startTime + gap *13, "S"),
                        new Beat(startTime + gap *15, "D"),
                        new Beat(startTime + gap *18, "J"),
                        new Beat(startTime + gap *20, "K"),
                        new Beat(startTime + gap *22, "J"),
                        new Beat(startTime + gap *24, "K"),
                        new Beat(startTime + gap *26, "J"),
                        new Beat(startTime + gap *28, "K"),
                        new Beat(startTime + gap *30, "J"),
                        new Beat(startTime + gap *32, "K"),
                        new Beat(startTime + gap *35, "S"),
                        new Beat(startTime + gap *37, "D"),
                        new Beat(startTime + gap *39, "S"),
                        new Beat(startTime + gap *41, "D"),
                        new Beat(startTime + gap *43, "S"),
                        new Beat(startTime + gap *45, "D"),
                        new Beat(startTime + gap *48, "J"),
                        new Beat(startTime + gap *49, "K"),
                        new Beat(startTime + gap *50, "L"),
                        new Beat(startTime + gap *52, "F"),
                        new Beat(startTime + gap *52, "Space"),
                        new Beat(startTime + gap *52, "J"),
                        new Beat(startTime + gap *54, "S"),
                        new Beat(startTime + gap *56, "D"),
                        new Beat(startTime + gap *59, "F"),
                        new Beat(startTime  + gap *59, "Space"),
                        new Beat(startTime + gap *59, "J"),
                        new Beat(startTime + gap *61, "L"),
                        new Beat(startTime + gap *63, "K"),
                        new Beat(startTime + gap *65, "F"),
                        new Beat(startTime + gap *65, "Space"),
                        new Beat(startTime + gap *65, "J"),
                        new Beat(startTime + gap *70, "S"),
                        new Beat(startTime + gap *72, "S"),
                        new Beat(startTime + gap *74, "S"),
                        new Beat(startTime + gap *78, "J"),
                        new Beat(startTime + gap *79, "K"),
                        new Beat(startTime + gap *80, "L"),
                        new Beat(startTime + gap *83, "Space"),
                        new Beat(startTime + gap *85, "S"),
                        new Beat(startTime + gap *87, "D"),
                        new Beat(startTime + gap *89, "S"),
                        new Beat(startTime + gap *91, "D"),
                        new Beat(startTime + gap *93, "F"),
                        new Beat(startTime + gap *96, "Space"),
                        new Beat(startTime + gap *98, "L"),
                        new Beat(startTime + gap *100, "Space"),
                        new Beat(startTime + gap *102, "S"),
                        new Beat(startTime + gap *103, "D"),
                        new Beat(startTime + gap *106, "Space"),
                        new Beat(startTime + gap *109, "Space"),
                        new Beat(startTime + gap *111, "Space"),
                        new Beat(startTime + gap *116, "Space"),
                        new Beat(startTime + gap *118, "S"),
                        new Beat(startTime + gap *119, "D"),
                        new Beat(startTime + gap *120, "Space"),
                        new Beat(startTime + gap *123, "S"),
                        new Beat(startTime + gap *124, "D"),
                        new Beat(startTime + gap *125, "F"),
                        new Beat(startTime + gap *126, "J"),
                        new Beat(startTime + gap *127, "K"),
                        new Beat(startTime + gap *130, "J"),
                        new Beat(startTime + gap *133, "K"),
                        new Beat(startTime + gap *136, "L"),
                        new Beat(startTime + gap *138, "S"),
                        new Beat(startTime + gap *140, "Space"),
                        new Beat(startTime + gap *142, "S"),
                        new Beat(startTime + gap *144, "Space"),
                        new Beat(startTime + gap *146, "Space"),
                        new Beat(startTime + gap *150, "Space"),
                        new Beat(startTime + gap *152, "Space"),
                        new Beat(startTime + gap *157, "J"),
                        new Beat(startTime + gap *161, "K"),
                        new Beat(startTime + gap *165, "L"),
                        new Beat(startTime + gap *167, "S"),
                        new Beat(startTime + gap *169, "D"),
                        new Beat(startTime + gap *171, "F"),
                        new Beat(startTime + gap *174, "S"),
                        new Beat(startTime + gap *176, "D"),
                        new Beat(startTime + gap *178, "F"),
                        new Beat(startTime + gap *180, "Space"),
                        new Beat(startTime + gap *181, "L"),
                        new Beat(startTime + gap *184, "Space"),
                        new Beat(startTime + gap *187, "L"),
                        new Beat(startTime + gap *188, "K"),
                        new Beat(startTime + gap *189, "J"),
                        new Beat(startTime + gap *192, "S"),
                        new Beat(startTime + gap *192, "Space"),
                        new Beat(startTime + gap *196, "D"),
                        new Beat(startTime + gap *196, "Space"),
                        new Beat(startTime + gap *200, "S"),
                        new Beat(startTime + gap *200, "Space"),
                        new Beat(startTime + gap *207, "J"),
                        new Beat(startTime + gap *207, "Space"),
                        new Beat(startTime + gap *211, "K"),
                        new Beat(startTime + gap *211, "Space"),
                        new Beat(startTime + gap *216, "L"),
                        new Beat(startTime + gap *216, "Space"),
                        new Beat(startTime + gap *218, "Space"),
                        new Beat(startTime + gap *221, "J"),
                        new Beat(startTime + gap *223, "K"),
                        new Beat(startTime + gap *225, "L"),
                        new Beat(startTime + gap *227, "S"),
                        new Beat(startTime + gap *227, "Space"),
                        new Beat(startTime + gap *231, "D"),
                        new Beat(startTime + gap *235, "S"),
                        new Beat(startTime + gap *235, "Space"),
                        new Beat(startTime + gap *242, "S"),
                        new Beat(startTime + gap *242, "Space"),
                        new Beat(startTime + gap *242, "L"),
                        new Beat(startTime + gap *246, "D"),
                        new Beat(startTime + gap *246, "Space"),
                        new Beat(startTime + gap *246, "K"),
                        new Beat(startTime + gap *250, "F"),
                        new Beat(startTime + gap *250, "Space"),
                        new Beat(startTime + gap *250, "J"),
                        new Beat(startTime + gap *255, "J"),
                        new Beat(startTime + gap *257, "K"),
                        new Beat(startTime + gap *259, "K"),
                        new Beat(startTime + gap *262, "S"),
                        new Beat(startTime + gap *262, "Space"),
                        new Beat(startTime + gap *266, "D"),
                        new Beat(startTime + gap *266, "Space"),
                        new Beat(startTime + gap *270, "S"),
                        new Beat(startTime + gap *270, "Space"),
                        new Beat(startTime + gap *275, "J"),
                        new Beat(startTime + gap *277, "K"),
                        new Beat(startTime + gap *279, "L"),
                        new Beat(startTime + gap *282, "J"),
                        new Beat(startTime + gap *284, "K"),
                        new Beat(startTime + gap *286, "L"),
                        new Beat(startTime + gap *289, "J"),
                        new Beat(startTime + gap *291, "K"),
                        new Beat(startTime + gap *293, "L"),
                        new Beat(startTime + gap *295, "J"),
                        new Beat(startTime + gap *297, "F"),
                        new Beat(startTime + gap *299, "D"),
                        new Beat(startTime + gap *301, "S"),
                        new Beat(startTime + gap *304, "F"),
                        new Beat(startTime + gap *306, "D"),
                        new Beat(startTime + gap *308, "S"),
                        new Beat(startTime + gap *310, "F"),
                        new Beat(startTime + gap *312, "D"),
                        new Beat(startTime + gap *314, "S"),
                        new Beat(startTime + gap *317, "F"),
                        new Beat(startTime + gap *319, "D"),
                        new Beat(startTime + gap *321, "S"),
                        new Beat(startTime + gap *323, "F"),
                        new Beat(startTime + gap *325, "D"),
                        new Beat(startTime + gap *327, "S"),
                        new Beat(startTime + gap *330, "F"),
                        new Beat(startTime + gap *332, "S"),
                        new Beat(startTime + gap *332, "Space"),
                        new Beat(startTime + gap *336, "D"),
                        new Beat(startTime + gap *336, "Space"),
                        new Beat(startTime + gap *340, "S"),
                        new Beat(startTime + gap *340, "Space"),
                };
            }

            else if(titleName.equals("Joakim Karud - Mighty Love") && difficulty.equals("Hard")){
                int startTime = 7800-1000*Main.REACH_TIME;

                int gap = 272;
                for (int i=0; i<beats.length;i++){
                    String randomKey  = keyNames[random.nextInt(keyNames.length)];
                    beats[i] = new Beat(startTime + gap*(i+1),randomKey);
                }

            }



            else if(titleName.equals("Joakim Karud - Wild Flower") && difficulty.equals("Easy")){
                int startTime = 2000;
                int gap = 723;
                for(int i=0; i<beats.length;i++){
                    String randomKey = keyNames[random.nextInt(keyNames.length)];
                    beats[i] = new Beat(startTime+gap*(i+1),randomKey);
                }
            }



            else if(titleName.equals("Joakim Karud - Wild Flower") && difficulty.equals("Hard")){
                int startTime = 2000;
                int gap = 361;
                for(int i=0;i<beats.length;i++){
                    String randomKey = keyNames[random.nextInt(keyNames.length)];
                    beats[i] = new Beat(startTime+ gap*(i+1),randomKey);
                }
            }
            else if(titleName.equals("Bensound - Energy") && difficulty.equals("Easy")){
                int startTime = 0;
                int gap = 875;

                for(int i=0; i<beats.length;i++){
                    String randomKey = keyNames[random.nextInt(keyNames.length)];
                    if(i==0){
                        beats[i] = new Beat(startTime,randomKey);
                    }
                    else {
                        beats[i] = new Beat(startTime + gap * (i), randomKey);
                    }
                }
            }

            else if(titleName.equals("Bensound - Energy") && difficulty.equals("Hard")){
                int startTime = 1000;
                int gap = 450;
                for(int i=0; i<beats.length;i++){
                    String randomKey = keyNames[random.nextInt(keyNames.length)];
                    beats[i] = new Beat(startTime+gap*(i+1),randomKey);
                }

            }


            else if(titleName.equals("Doja cat - Paint The Town Red") && difficulty.equals("Easy")){
                int startTime = 7500 - 1000*Main.REACH_TIME;
                int gap = 100;
                int bpm = 600;

                /*eats = new Beat[] {
                        new Beat(startTime+gap*5, "S"),
                        new Beat(startTime+gap*11, "D"),
                        new Beat(startTime+gap*16, "S"),
                        new Beat(startTime+gap*23, "D"),

                        new Beat(startTime+gap*54, "J"),  //5.5초에 시작해서 13.5초대니까 8초 더 추가
                        new Beat(startTime+gap*60, "K"),
                        new Beat(startTime+gap*65, "J"),
                        new Beat(startTime+gap*71, "K"),   // 18초에 다시

                        new Beat(startTime+gap*100, "S"),
                        new Beat(startTime+gap*106, "D"),
                        new Beat(startTime+gap*112, "S"),
                        new Beat(startTime+gap*118, "D"), //  5.2초 이후 다시 실행

                        new Beat(startTime+gap*150, "J"),
                        new Beat(startTime+gap*156, "K"),
                        new Beat(startTime+gap*161, "J"),
                        new Beat(startTime+gap*166, "K"),

                        new Beat(startTime+gap+166, )
                };

                timer.close();*/

                for (int i = 0; i < beats.length; i++) {
                    String randomKeyName = keyNames[random.nextInt(keyNames.length)];
                    beats[i] = new Beat(startTime + bpm * (i + 1), randomKeyName);
                }
            }



            else if(titleName.equals("Doja cat - Paint The Town Red") && difficulty.equals("Hard")){
                int startTime = 7500 - 1000*Main.REACH_TIME;
                int bpm = 300;
                for(int i=0; i< beats.length;i++){
                    String randomKeyName = keyNames[random.nextInt(keyNames.length)];
                    beats[i] = new Beat(startTime+bpm*(i+1),randomKeyName);}
            }

            int i = 0;
            gameMusic.start();
            while(i<beats.length && !isInterrupted()){
                boolean dropped = false;

                if(beats[i].getTime() <= gameMusic.getTime()) // 비트가 떨어지는 시간대가 gameMusic의 시간보다 적거나 같을때만 비트가 떨어지는게 실행
            {
                Note note = new Note(beats[i].getNoteName());
                note.start();
                noteList.add(note);
                i++;
                dropped = true;
            }
                if(!dropped){
                    try{
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

        }
    }

    public void judge(String input){
        for (int i = 0; i<noteList.size();i++){
                Note note = noteList.get(i);
                if(input.equals(note.getNoteType())){
                    judgeEvent(note.judge());
                    break;

                }
        }
    }
    public void judgeEvent(String judge){
        if(!judge.equals("None")){
            blueFlareImage = new ImageIcon(Main.class.getResource("/Images/blueFlare.png")).getImage();
        }
        if(judge.equals("Miss")){
            judgeImage = new ImageIcon(Main.class.getResource("/images/Miss.png")).getImage();
        }
        else if(judge.equals("Late")){
            judgeImage = new ImageIcon(Main.class.getResource("/images/Late.png")).getImage();
        }
        else if(judge.equals("Early")){
            judgeImage = new ImageIcon(Main.class.getResource("/images/Early.png")).getImage();
        }
        else if(judge.equals("Good")){
            judgeImage = new ImageIcon(Main.class.getResource("/images/Good.png")).getImage();
        }
        else if(judge.equals("Great")){
            judgeImage = new ImageIcon(Main.class.getResource("/images/Great.png")).getImage();
        }
        else   if(judge.equals("Perfect")){
            judgeImage = new ImageIcon(Main.class.getResource("/images/Perfect.png")).getImage();

        }
    }
}

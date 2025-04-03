package dynamic_beat_7;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {

    private Image screenImage; // 더블 버퍼링 위한 인스턴스
    private Graphics screenGraphic; // 마찬가지

    private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage(); // 배경 사진
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));


    private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
    private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
    private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
    private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
    private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
    private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));

    private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
    private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
    private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
    private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));

    private JButton exitButton = new JButton(exitButtonBasicImage);
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);
    private JButton rightButton = new JButton(rightButtonBasicImage);
    private JButton leftButton = new JButton(leftButtonBasicImage);


    private int mouseX,mouseY;

    private boolean isMainScreen = false;

    ArrayList<Track> trackList = new ArrayList<>();

    private Music selectedMusic;
    private Image titleImage;
    private Image selectedImage;
    private int nowSelected =0;

    public DynamicBeat(){
        setUndecorated(true); // : 기본적으로 존재하는 바를 사라지게 해주고 menuBar만 존재하게 해줌.
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false); // 한 번 정해진 사이즈는 사용자가 임의로 수정 불가능
        setLocationRelativeTo(null);// 실행했을 때 우리가 만든 창이 정확히 우리의 정 중앙에 위치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램(게임) 종료시 전체 종료
        setVisible(true);// 기본값은 false인데 true 라고 하면 나중에 실행할 때 화면에 우리가 만든게 보이게 하는거
        Music introMusic = new Music("introMusic.mp3",true);
        introMusic.start();
        setBackground(new Color(0,0,0,0));
        setLayout(null);


        trackList.add(new Track("Mighty Love Title Image.png","Mighty Love Start Image.png","Mighty Love Game Image.jpg","Mighty Love Selected.mp3","Joakim Karud - Mighty Love.mp3"));
        trackList.add(new Track("Wild Flower Title Image.png","Wild Flower Start Image.png","Wild Flower Game Iamge.jpg","Wild Flower Selected.mp3","Joakim Karud - Wild Flower.mp3"));
        trackList.add(new Track("Energy Title Image.png","Energy Start Image.png","Energy Game Image.png","Energy Selected.mp3","Bensound - Energy.mp3"));
        trackList.add(new Track("Paint the town red Title Image.png","Paint the town red START image.jpg","Paint the town red GAME image.png","Paint the town red Select music.mp3","Paint the town red Start Music.mp3"));

        exitButton.setBounds(1250,0,30,30);

        // 이 3개는 내가 가져온 exiButton의 아이콘만 가져오도록 다른 이미지 없애는거
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEnteredImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
                buttonEnteredMusic.start();
                try{
                    Thread.sleep(1000);
                }  catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });

        //
        add(exitButton);

        leftButton.setBounds(140,310,60,60);

        // 이 3개는 내가 가져온 exiButton의 아이콘만 가져오도록 다른 이미지 없애는거
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                leftButton.setIcon(leftButtonEnteredImage);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                leftButton.setIcon(leftButtonBasicImage);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
                buttonEnteredMusic.start();
                selectLeft();
            }
        });

        rightButton.setBounds(1080,310,60,60);

        // 이 3개는 내가 가져온 exiButton의 아이콘만 가져오도록 다른 이미지 없애는거
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                rightButton.setIcon(rightButtonEnteredImage);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                rightButton.setIcon(rightButtonBasicImage);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
                buttonEnteredMusic.start();
                selectRight();
            }
        });

        startButton.setBounds(40,200,400,100);

        // 이 3개는 내가 가져온 exiButton의 아이콘만 가져오도록 다른 이미지 없애는거
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonEnteredImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                startButton.setIcon(startButtonBasicImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
                buttonEnteredMusic.start();
                introMusic.close();
                selectTrack(0);

                startButton.setVisible(false);
                quitButton.setVisible(false);
                background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();


                isMainScreen = true;
                add(leftButton);
                add(rightButton);


            }
        });

        //
        add(startButton);

        quitButton.setBounds(40,330,400,100);

        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                quitButton.setIcon(quitButtonEnteredImage);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                quitButton.setIcon(quitButtonBasicImage);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
                buttonEnteredMusic.start();
                try{
                    Thread.sleep(1000);
                }  catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });

        add(quitButton);




        menuBar.setBounds(0,0,1280,30);//setbounds = 위치와 크기를 정해준다
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX=e.getX();
                mouseY=e.getY();
            }
        });

        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x-mouseX,y-mouseY);
            }
        });
        add(menuBar);//JFRAME 에 메뉴 바 추가



    }

    public void paint(Graphics g){ //paint 함수는 JFRAME 을 상속받은 GUI 에서 가장 첫 번 째로 화면을 그려주는 함수, 약속된거라 뷔끼지 않음
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic); // draw 함수를 통해서 그래픽을 그려주는 거임.
        g.drawImage(screenImage, 0, 0,null);
    }

    public void screenDraw(Graphics g) { //
        g.drawImage(background,0,0,null); // introBackground 를 0,0 좌표에 그려준다.

        if (isMainScreen){
            g.drawImage(selectedImage,340,100,null);
            g.drawImage(titleImage,340,70,null);
        }

        paintComponents(g);// introbackground 를 만들어주는 거 외에도 JLabel 같은거가 생겼을 때 이런걸 그려주는 것
                           // 고정된 버튼이나 바 같은 것은 drawImage가 아니라 paintComponents를 이용해주는것이 좋음
                           // 역동적으로 움직이는 것은 drawImage 써주면 됨
        this.repaint(); // 다시 paint 함수를 불러옴 -> 즉 전체 화면 이미지를 매 순간마다 프로그램 종료되는 순간까지 반복되면서 그려주는 것.
    }

    public void selectTrack(int nowSelected){
        if(selectedMusic != null){
            selectedMusic.close();
        }
        titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);
        selectedMusic.start();
    }

    public void selectLeft(){
        if(nowSelected==0){
            nowSelected = trackList.size()-1; // arraylist에 인자 3개 들어가있으면 사이즈는 3, 인덱스는 0,1,2 부터 시작하니 어후 헷갈려
        }

        else{
            nowSelected--;
        }

        selectTrack(nowSelected);

    }

    public void selectRight(){
        if(nowSelected==trackList.size()-1){
            nowSelected = 0; // arraylist에 인자 3개 들어가있으면 사이즈는 3, 인덱스는 0,1,2 부터 시작하니 어후 헷갈려
        }
        else{
            nowSelected++;
        }
        selectTrack(nowSelected);
    }


}

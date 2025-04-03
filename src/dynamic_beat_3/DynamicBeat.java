package dynamic_beat_3;


import dynamic_beat_2.Main;

import javax.swing.*;
import java.awt.*;

public class DynamicBeat extends JFrame {

    private Image screenImage; // 더블 버퍼링 위한 인스턴스
    private Graphics screenGraphic; // 마찬가지
    private Image introBackground; // 배경 사진

    public DynamicBeat(){
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH,Main.SCREEN_WEIGHT);
        setResizable(false); // 한 번 정해진 사이즈는 사용자가 임의로 수정 불가능
        setLocationRelativeTo(null);// 실행했을 때 우리가 만든 창이 정확히 우리의 정 중앙에 위치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램(게임) 종료시 전체 종료
        setVisible(true);// 기본값은 false인데 true 라고 하면 나중에 실행할 때 화면에 우리가 만든게 보이게 하는거


        introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
        Music introMusic = new Music("introMusic.mp3",true);
        introMusic.start();
    }

    public void paint(Graphics g){ //paint 함수는 JFRAME 을 상속받은 GUI 에서 가장 첫 번 째로 화면을 그려주는 함수, 약속된거라 뷔끼지 않음
        screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_WEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic); // draw 함수를 통해서 그래픽을 그려주는 거임.
        g.drawImage(screenImage, 0, 0,null);
    }

    public void screenDraw(Graphics g) { //
        g.drawImage(introBackground,0,0,null); // introBackground 를 0,0 좌표에 그려준다.
        this.repaint(); // 다시 paint 함수를 불러옴 -> 즉 전체 화면 이미지를 매 순간마다 프로그램 종료되는 순간까지 반복되면서 그려주는 것.

    }


}

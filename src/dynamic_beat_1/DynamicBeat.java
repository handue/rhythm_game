package dynamic_beat_1;

import javax.swing.*;

public class DynamicBeat extends JFrame {

    public DynamicBeat(){
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH,Main.SCREEN_WEIGHT);
        setResizable(false); // 한 번 정해진 사이즈는 사용자가 임의로 수정 불가능
        setLocationRelativeTo(null);// 실행했을 때 우리가 만든 창이 정확히 우리의 정 중앙에 위치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램(게임) 종료시 전체 종료
        setVisible(true);// 기본값은 false인데 true 라고 하면 나중에 실행할 때 화면에 우리가 만든게 보이게 하는거




    }
}

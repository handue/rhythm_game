package dynamic_beat_11;

import javax.swing.*;

public class Main {

    public static final int SCREEN_WIDTH = 1280; // final 은 한 번 선언되면 절대 바뀌지 않음, 한 번 선언되면 바뀌지 않는 변수들은 웬만하면 대문자로 설정함
    public static final int SCREEN_HEIGHT = 720; // static이란 모든 프로젝트 내부에서 공유할 수 있는 하나의 변수를 의미
    public static final int NOTE_SPEED = 5;
    public static final int SLEEP_TIME = 10 ;
    public static final int REACH_TIME = 2;
    public static int score = 0;

    public static void main(String[] args) {
        new DynamicBeat();

    }
}
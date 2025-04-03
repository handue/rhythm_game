package dynamic_beat_8;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Music extends Thread //스레드란 프로그램 내의 작은 프로그램
{

    private Player player; // 이게 jlayer인가 그거였음
    private boolean isloop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public Music(String name, boolean isloop) {
        try {
            this.isloop = isloop;
            file = new File(Main.class.getResource("../music/" + name).toURI());
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public int getTime() // 이거로 노트 떨어트릴 때 음악에 맞춰서 노트를 떨어트릴 떄 겟타임 이용해서 하는거라고 함.
    {
        if (player == null)
            return 0;
        return player.getPosition();
    }

    public void close() // 어떤곡을하다가 재미가 없어서 뒤로가기 했을 때 close 함수 실행
    {
        isloop = false;
        player.close();
        this.interrupt(); // 해당 스레드(게임과 별도로 노래를 들려주는 프로그램이 스레드)를 중지 상태로 만듬.
    }

    @Override
    public void run() //thread 를 상속받으면 run 이라는 함수는 무조건 오버라이딩 해서 사용해야함.
    {
        try{
            do{
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            } while(isloop); // isloop 가 트루값이라면 위에 값 무한루프

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}

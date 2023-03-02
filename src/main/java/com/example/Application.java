package com.example;
import com.example.system.controller.SystemController;
import com.example.wiseSaying.controller.WiseSayingController;

import java.util.*;

public class Application {
    public void run() {
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController(); // 객체 생성
        WiseSayingController wiseSayingController = new WiseSayingController();

        while(true){
            System.out.print("명령) "); // 입력 받기
            String command = Container.getScanner().nextLine().trim();
            Rq rq = new Rq(command);

            if(command.equals("종료")) {
                systemController.exit();
                break;
            }
            else if (command.equals("등록")){
                wiseSayingController.write();
            }
            else if (command.equals("목록")) {
                wiseSayingController.list();
            }
            else if (command.startsWith("삭제")) {
                wiseSayingController.remove(rq);
            }
        }
    }
}
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
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            // trim() : 혹시 있을지 모를 좌우공백 제거된 버전으로 주세요!

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
        }
    }
}
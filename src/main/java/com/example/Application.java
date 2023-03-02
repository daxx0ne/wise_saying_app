package com.example;
import java.util.*;
import io.micronaut.runtime.Micronaut;

public class Application {
    public final Scanner sc;
    public Application(Scanner sc){
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.println("명령) ");
            String command = sc.nextLine().trim();
            // trim() : 혹시 있을지 모를 좌우공백제거된 버전으로 주세요!
            if(command.equals("종료")) {
                break;
            }

        }
    }
}
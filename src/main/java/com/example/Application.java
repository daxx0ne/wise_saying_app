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

        long lastWiseSayingId = 0; // 제일 겉에 있는 곳에 변수를 선언해야지 장기기억!
        List<WiseSaying> wiseSayings = new ArrayList<>(); // wiseSayings 라는 리스트를 만들어준 후 Arraylist 생성

        while(true){
            System.out.print("명령) ");
            String command = sc.nextLine().trim();
            // trim() : 혹시 있을지 모를 좌우공백 제거된 버전으로 주세요!
            if(command.equals("종료")) { // 종료가 입력되면 프로그램 종료
                break;
            }
            else if (command.equals("등록")){
                long id = lastWiseSayingId + 1;
                System.out.print("명언 : "); // #2 명언과 작가 이름을 입력받기
                String content = sc.nextLine().trim();
                System.out.print("작가 : ");
                String authorName = sc.nextLine().trim();

                WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
                wiseSayings.add(wiseSaying); // 등록된 명언들을 WiseSaying 리스트에 저장

                System.out.printf("%d번 명언이 등록되었습니다.\n", id); // #3 등록 문구 띄우기
                lastWiseSayingId = id; // #4 등록할 때마다 번호 증가
            }
            else if (command.equals("목록")) { // #5 등록된 명언의 목록 출력하기
                System.out.println("번호  /  작가  /  명언");
                System.out.println("-".repeat(30)); // -를 30번 반복해서 출력 -------... 랑 같음

                for (int i = wiseSayings.size() - 1; i >= 0; i--){ // 입력의 역순으로 출력 (목록의 1번부터)
                    WiseSaying wiseSaying = wiseSayings.get(i);

                    // '목록번호  작가이름  명언' 을 출력
                    System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(), wiseSaying.getContent());
                }
            }
        }
    }
}
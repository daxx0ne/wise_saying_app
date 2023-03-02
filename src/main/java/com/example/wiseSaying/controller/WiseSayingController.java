package com.example.wiseSaying.controller;

import com.example.wiseSaying.entity.WiseSaying;

import java.util.*;

public class WiseSayingController {
    private final Scanner sc;
    private long lastWiseSayingId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        lastWiseSayingId = 0;
        wiseSayings = new ArrayList<>();
    }
    public void write(){ // #2~4 등록하기
        long id = lastWiseSayingId + 1; // 등록할 때마다 번호 증가
        System.out.print("명언 : "); // 명언과 작가 이름을 입력받기
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String authorName = sc.nextLine().trim();

        WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
        wiseSayings.add(wiseSaying); // 등록된 명언들을 WiseSaying 리스트에 저장

        System.out.printf("%d번 명언이 등록되었습니다.\n", id); // 등록 문구 띄우기
        lastWiseSayingId = id;
    }
    public void list(){ // #5 등록된 명언의 목록 출력하기기
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30)); // -를 30번 반복해서 출력 -------... 랑 같음

        for (int i = wiseSayings.size() - 1; i >= 0; i--) { // 입력의 역순으로 출력 (목록의 1번부터)
            WiseSaying wiseSaying = wiseSayings.get(i);
            // '목록번호  작가이름  명언' 을 출력
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(), wiseSaying.getContent());
        }
    }
}

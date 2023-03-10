package com.example.wiseSaying.controller;

import com.example.Rq;
import com.example.wiseSaying.entity.WiseSaying;
import com.example.Container;
import com.example.wiseSaying.service.WiseSayingService;

import java.util.*;

public class WiseSayingController {
    private  final WiseSayingService wiseSayingService;

    public WiseSayingController() {
        wiseSayingService = new WiseSayingService();
    }

    public void write() { // #2~4 등록하기
        System.out.print("명언 : "); // 명언과 작가 이름을 입력받기
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String authorName = Container.getScanner().nextLine().trim();

        long id = wiseSayingService.write(content, authorName);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id); // 등록 문구 띄우기
    }

    public void list() { // #5 등록된 명언의 목록 출력하기기
        List<WiseSaying> wiseSayings = wiseSayingService.findAll();
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30)); // -를 30번 반복해서 출력 -------... 랑 같음

        for (int i = wiseSayings.size() - 1; i >= 0; i--) { // 입력의 역순으로 출력 (목록의 1번부터)
            WiseSaying wiseSaying = wiseSayings.get(i);
            // '목록번호  작가이름  명언' 을 출력
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(), wiseSaying.getContent());
        }
    }

    public void remove(Rq rq) { // #6 명언 삭제하기

        long id = rq.getLongParam("id", -1); // id 값을 정수화 해서 보내주고, 만약 실패하면 -1을 보내줘!

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }
        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        // 찾은 명언객체를 리스트에서 제거
        wiseSayingService.remove(wiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    public void modify(Rq rq) {
        long id = rq.getLongParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id); // 입력한 id와 일치하는 명언 객체를 찾음

        if (wiseSaying == null) { // 존재하지 않는 명언삭제에 대한 예외처리 (수정할 때도)
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        // #8 명언 수정하기
        System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();

        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthorName());
        System.out.print("작가 : ");
        String authorName = Container.getScanner().nextLine().trim();

        wiseSayingService.modify(wiseSaying, content, authorName);

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }
}
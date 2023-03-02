package com.example;
import java.util.*;
public class main { // Applicaiton이 일하도록 함
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        new Application(sc).run(); // 기본적으로 Scanner를 가지고 있는 Applicaiton
        sc.close();
    }
}
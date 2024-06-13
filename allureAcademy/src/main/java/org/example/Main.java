package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }

    @Test
    @Description("This is a sample test")
    public void sampleTest() {
        step1();
        step2();
    }

    @Step("Step 1")
    public void step1() {
        // Your test code here
    }

    @Step("Step 2")
    public void step2() {
        // Your test code here
    }
}
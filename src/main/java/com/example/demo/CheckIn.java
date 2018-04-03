package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Vector;

@RestController
public class CheckIn {
    private Vector<String> ans;
    private boolean flag = false;
    private WordLadder ladder;

    @RequestMapping("/")
    public Vector<String> getLadder (@RequestParam(value = "begin", defaultValue = "") String begin,
                      @RequestParam(value = "end", defaultValue = "") String end){
        if (!flag){
            try {
                ladder.readFile();
            }
            catch (FileNotFoundException e) {
            }
        }
        ans = ladder.findLadder(begin,end);
        return ans;
    }
}

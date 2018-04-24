package com.tang;

import org.springframework.stereotype.Component;

@Component("resumeService")
public class ResumeService {

    public void storeResume() {
        System.out.println("Storing resume ...");
    }

}
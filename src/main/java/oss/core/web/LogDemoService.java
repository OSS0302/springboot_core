package oss.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import oss.core.common.MyLogger;

@Service
@RequiredArgsConstructor // 의존성 주입
public class LogDemoService {

    private final MyLogger myLogger;


    public void logic(String id){
        myLogger.log("service id = "+id);
    }
}

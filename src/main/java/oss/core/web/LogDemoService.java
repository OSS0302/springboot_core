package oss.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import oss.core.common.MyLogger;

@Service
@RequiredArgsConstructor // 의존성 주입
public class LogDemoService {

    private final MyLogger myLogger; //서비스 도 마찬가지 myLoggerObjectProvider으로 변경해준다.


    public void logic(String id){
        myLogger.log("service id = "+id);
    }
}

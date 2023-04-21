package oss.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import oss.core.common.MyLogger;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerObjectProvider; // myLogger를 주입 받는게 아니라 myLogger를 찾을 수있는 디펜던시 로그가 주입된다.


    @RequestMapping("log-demo")
    @ResponseBody // 문자 그대로 응답을 보낼 수있다.
    public String logDemo(HttpServletRequest request) {
        MyLogger myLogger = myLoggerObjectProvider.getObject();
        String requestURL = request.getRequestURI().toString();
        myLogger.setRequestURL(requestURL); // URL 정보 보내기

        myLogger.log("controller test");
        logDemoService.logic("testId"); // 서비스 호출
        return "OK";
    }
}

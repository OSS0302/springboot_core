package oss.core.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS) //MyLogger의 가짜 프록시 클래스를 만들어두고 HTTP request와 상관 없이 가짜 프록시클래스를 다른 빈에 미리 주입해 둘 수있다.
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
    public void log(String message){
        System.out.println("["+uuid+ "]" +"["+requestURL+"] " + message);
    }
    @PostConstruct //이 빈이 생성되는 시점에 자동으로 @PostConstruct 초기화 메서드를 사용해서 uuid를 생성해서 저장해둔다. 이 빈은 HTTP 요청 당 하나씩 생성되므로, uuid를 저장해두면 다른 HTTP 요청과 구분할 수 있다.
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+ "] request scope bean create :"+this); // 주소 출력

    }
    @PreDestroy//이 빈이 소멸되는 시점에 @PreDestroy 를 사용해서 종료 메시지를 남긴다. requestURL 은 이 빈이 생성되는 시점에는 알 수 없으므로, 외부에서 setter로 입력 받는다.
    public void close(){
        System.out.println("["+uuid+ "] request scope bean close :"+this);
    }

}

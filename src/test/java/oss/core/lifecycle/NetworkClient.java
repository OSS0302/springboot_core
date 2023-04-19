package oss.core.lifecycle;


public class NetworkClient {
    private String url; // url  적기

    public NetworkClient() {
        System.out.println("생성자 호출, url= "+url);

    }
    public void setUrl(String url) {
        this.url = url;
    }
    // 서비스를 시작시 호출
    public void connect(){
        System.out.println("connect= " + url);
    }
    public void call(String message){
        System.out.println("call = " + url+"message"+ message);

    }
    // 서비스 종료시 호출
        public void discount(){
            System.out.println("close"+url);
        }

    @Override
    public void init() throws Exception { //스프링이  의존관계주입이 다  끝나면 호출하겠다.정
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화  연결 메시지");
    }

    @Override
    public void close() throws Exception {
        System.out.println("NetworkClient.destroy");
        discount(); // discount 호출하겠다.
    }
}


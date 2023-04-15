package oss.core.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    // 생성자 주입 선택하기 누락과 불변

    @Test
    void createOrder(){
        OrderServiceImpl orderService =new OrderServiceImpl();
        orderService.createOrder(1L,"itemA",10000);

    }
}
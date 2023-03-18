package oss.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName ,int itemPrice); // 회원 아이디 상품명 상품가격
}

package oss.core.order;

public class Order {
    private Long memberId; // 회원 아이디
    private String itemName;// 상품이름
    private int itemPrice; // 상품가격
    private int discountPrice; // 할인가격

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }
    public int calculatePrice(){
        return itemPrice-discountPrice; // 상품가격- 할인가격을 뺀 가격을 반환 하겠다.
    }
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {this.discountPrice = discountPrice;}

    @Override
    public String toString() { // toString을 하면 쉽게 출력문 확인 하여서 쓴다.
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
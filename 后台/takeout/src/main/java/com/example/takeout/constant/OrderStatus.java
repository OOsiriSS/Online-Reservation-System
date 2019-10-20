package com.example.takeout.constant;

public enum OrderStatus {

/**
 *      0   ： 表示未付款
 *      200 ： 表示已确认订单
 *      300 ： 表示以发货
 *      400 ： 表示刚刚付款但还未发货
 *      500 ： 表示订单已过期
 *      501 ： 表示退订
 *
 *
 */
    UNCONFIRMED(0),
    CONFIRM(200),
    OUT(300),
    WAIT(400),
    OVERDUE(500),
    UNSUBSCRIBE(501);

    public final int value;



    OrderStatus(int value) {
        this.value = value;
    }



}

package com.example.takeout.constant;

public enum PaymentStatus {

    /**
     *      0   : 默认状态,表示还未将尾款打给商家
     *      1   : 已将尾宽打给商家
     *      501 : 退款了
     *
     */

    UNCONFIRMED(0),
    CONFIRM(1),
    REFUND(501);


    public final int value;

    private PaymentStatus(int value){
        this.value=value;
    }

}

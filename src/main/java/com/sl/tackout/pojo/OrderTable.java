package com.sl.tackout.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created by happy on 2019/8/21.
 */
@Data
public class OrderTable {
    private int oid;//订单号
    private String oname;//订单名称（xx的订单）
    private Date ocreatTime;//创建时间
    private String ocustomerName;//顾客名字
    private String ocustomerPhone;//顾客电话
    private String ocustomerAddress;//顾客地址
    private String ogoodsName;//商品名称
    private double ogoodsUnitprice;//商品单价
    private String oremarks;//备注
    private int ostate;//订单状态（0表示订单未完成，1表示客户已下单，2表示商家已接单，3表示订单已完成）

}

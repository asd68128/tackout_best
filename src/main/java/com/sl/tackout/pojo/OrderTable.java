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
    private int ofreight;//订单配送费
    private int olunchbox_price;//订单餐盒费
    private double ototal_price;//订单总价
    private int ototalshare;//订单总商品数
    private String oremarks;//备注
    private Date ocreatTime;//创建时间
    private int ostate;//订单状态（0表示订单未完成，1表示客户已下单，2表示商家已接单，3表示订单已完成）

    public OrderTable() {
    }

    public OrderTable(int oid, String oname, int ofreight, int olunchbox_price, double ototal_price, int ototalshare, String oremarks, Date ocreatTime, int ostate) {

        this.oid = oid;
        this.oname = oname;
        this.ofreight = ofreight;
        this.olunchbox_price = olunchbox_price;
        this.ototal_price = ototal_price;
        this.ototalshare = ototalshare;
        this.oremarks = oremarks;
        this.ocreatTime = ocreatTime;
        this.ostate = ostate;
    }

    public int getOid() {

        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public int getOfreight() {
        return ofreight;
    }

    public void setOfreight(int ofreight) {
        this.ofreight = ofreight;
    }

    public int getOlunchbox_price() {
        return olunchbox_price;
    }

    public void setOlunchbox_price(int olunchbox_price) {
        this.olunchbox_price = olunchbox_price;
    }

    public double getOtotal_price() {
        return ototal_price;
    }

    public void setOtotal_price(double ototal_price) {
        this.ototal_price = ototal_price;
    }

    public int getOtotalshare() {
        return ototalshare;
    }

    public void setOtotalshare(int ototalshare) {
        this.ototalshare = ototalshare;
    }

    public String getOremarks() {
        return oremarks;
    }

    public void setOremarks(String oremarks) {
        this.oremarks = oremarks;
    }

    public Date getOcreatTime() {
        return ocreatTime;
    }

    public void setOcreatTime(Date ocreatTime) {
        this.ocreatTime = ocreatTime;
    }

    public int getOstate() {
        return ostate;
    }

    public void setOstate(int ostate) {
        this.ostate = ostate;
    }

    @Override
    public String toString() {
        return "OrderTable{" +
                "oid=" + oid +
                ", oname='" + oname + '\'' +
                ", ofreight=" + ofreight +
                ", olunchbox_price=" + olunchbox_price +
                ", ototal_price=" + ototal_price +
                ", ototalshare=" + ototalshare +
                ", oremarks='" + oremarks + '\'' +
                ", ocreatTime=" + ocreatTime +
                ", ostate=" + ostate +
                '}';
    }
}

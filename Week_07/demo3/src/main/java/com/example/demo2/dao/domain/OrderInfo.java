package com.example.demo2.dao.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table order_info
 *
 * @mbg.generated do_not_delete_during_merge Wed Dec 02 16:23:25 CST 2020
 */
public class OrderInfo implements Serializable {
    /**
     * Database Column Remarks:
     *   自增主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.id
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   订单编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.order_no
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private String orderNo;

    /**
     * Database Column Remarks:
     *   顾客编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.customer_id
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private String customerId;

    /**
     * Database Column Remarks:
     *   地址id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.shipping_address_id
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private Integer shippingAddressId;

    /**
     * Database Column Remarks:
     *   订单状态
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.order_status
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private Byte orderStatus;

    /**
     * Database Column Remarks:
     *   支付订单号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.pay_info_no
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private String payInfoNo;

    /**
     * Database Column Remarks:
     *   物流订单单号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.logistics_info_no
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private String logisticsInfoNo;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.create_time
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   修改时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.update_time
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   订单价格
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.total_price
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private BigDecimal totalPrice;

    /**
     * Database Column Remarks:
     *   实付价格
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.actual_price
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private BigDecimal actualPrice;

    /**
     * Database Column Remarks:
     *   数据状态，0 正常 ，1 删除
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.status
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_info
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.id
     *
     * @return the value of order_info.id
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.id
     *
     * @param id the value for order_info.id
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.order_no
     *
     * @return the value of order_info.order_no
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.order_no
     *
     * @param orderNo the value for order_info.order_no
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.customer_id
     *
     * @return the value of order_info.customer_id
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.customer_id
     *
     * @param customerId the value for order_info.customer_id
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.shipping_address_id
     *
     * @return the value of order_info.shipping_address_id
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public Integer getShippingAddressId() {
        return shippingAddressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.shipping_address_id
     *
     * @param shippingAddressId the value for order_info.shipping_address_id
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setShippingAddressId(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.order_status
     *
     * @return the value of order_info.order_status
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public Byte getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.order_status
     *
     * @param orderStatus the value for order_info.order_status
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.pay_info_no
     *
     * @return the value of order_info.pay_info_no
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public String getPayInfoNo() {
        return payInfoNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.pay_info_no
     *
     * @param payInfoNo the value for order_info.pay_info_no
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setPayInfoNo(String payInfoNo) {
        this.payInfoNo = payInfoNo == null ? null : payInfoNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.logistics_info_no
     *
     * @return the value of order_info.logistics_info_no
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public String getLogisticsInfoNo() {
        return logisticsInfoNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.logistics_info_no
     *
     * @param logisticsInfoNo the value for order_info.logistics_info_no
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setLogisticsInfoNo(String logisticsInfoNo) {
        this.logisticsInfoNo = logisticsInfoNo == null ? null : logisticsInfoNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.create_time
     *
     * @return the value of order_info.create_time
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.create_time
     *
     * @param createTime the value for order_info.create_time
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.update_time
     *
     * @return the value of order_info.update_time
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.update_time
     *
     * @param updateTime the value for order_info.update_time
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.total_price
     *
     * @return the value of order_info.total_price
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.total_price
     *
     * @param totalPrice the value for order_info.total_price
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.actual_price
     *
     * @return the value of order_info.actual_price
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.actual_price
     *
     * @param actualPrice the value for order_info.actual_price
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.status
     *
     * @return the value of order_info.status
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.status
     *
     * @param status the value for order_info.status
     *
     * @mbg.generated Wed Dec 02 16:23:25 CST 2020
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}
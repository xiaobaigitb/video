package com.zhiyou.video.model;

/**
 * @author Mr.lu
 * @Title: VipModel
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/18:21:00
 */
public class VipModel {

    private Integer id;
    //用户邮箱
    private String email;
    //支付方式
    private String payment;
    //支付钱数
    private Integer totalMoney;
    //用户状态
    private Integer status;

    public VipModel(Integer id, String email, String payment, Integer totalMoney, Integer status) {
        this.id = id;
        this.email = email;
        this.payment = payment;
        this.totalMoney = totalMoney;
        this.status = status;
    }

    @Override
    public String toString() {
        return "VipModel{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", payment=" + payment +
                ", totalMoney=" + totalMoney +
                ", status=" + status +
                '}';
    }

    public VipModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

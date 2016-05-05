package com.nachepin.api.model;

import com.google.common.collect.ImmutableMap;
import com.nachepin.api.model.enums.CustomerState;
import com.nachepin.api.model.enums.CustomerType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @auther huwhy
 * @date 2016/4/26.
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    public static Map<String, String> GOODS_TYPES = ImmutableMap
            .of("cushion", "汽车坐垫", "floorMat", "汽车脚垫", "wheelCover", "方向盘套", "carTrim", "汽车内饰", "other", "其他");

    @Id
    @GeneratedValue
    private int id;
    private String code;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;

    @Enumerated
    private CustomerType type;
    @Enumerated
    private CustomerState state;
    private String shopUrl;
    private String wangwang;
    private String qq;
    private String inGoodsType;
    private String address;
    private String fullAddress;
    private String postCode;
    private String alipayCode;
    private String tenpayCode;
    private String supplierCompany;
    private String artificialPerson;
    private String businessLicence;
    private Boolean isProducer;
    private String brand;
    private String emergencyContact;
    private String emergencyPhone;
    private String outGoodsType;
    private String pickAddress;
    private String pickAreaCode;
    private Date created;
    private String alipayName;
    private String weiXin;
    private String sign;
    private int weighting;
    private String province;
    private String city;
    private String area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public CustomerState getState() {
        return state;
    }

    public void setState(CustomerState state) {
        this.state = state;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getWangwang() {
        return wangwang;
    }

    public void setWangwang(String wangwang) {
        this.wangwang = wangwang;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getInGoodsType() {
        return inGoodsType;
    }

    public void setInGoodsType(String inGoodsType) {
        this.inGoodsType = inGoodsType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAlipayCode() {
        return alipayCode;
    }

    public void setAlipayCode(String alipayCode) {
        this.alipayCode = alipayCode;
    }

    public String getTenpayCode() {
        return tenpayCode;
    }

    public void setTenpayCode(String tenpayCode) {
        this.tenpayCode = tenpayCode;
    }

    public String getSupplierCompany() {
        return supplierCompany;
    }

    public void setSupplierCompany(String supplierCompany) {
        this.supplierCompany = supplierCompany;
    }

    public String getArtificialPerson() {
        return artificialPerson;
    }

    public void setArtificialPerson(String artificialPerson) {
        this.artificialPerson = artificialPerson;
    }

    public String getBusinessLicence() {
        return businessLicence;
    }

    public void setBusinessLicence(String businessLicence) {
        this.businessLicence = businessLicence;
    }

    public Boolean getIsProducer() {
        return isProducer;
    }

    public void setIsProducer(Boolean isProducer) {
        this.isProducer = isProducer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getOutGoodsType() {
        return outGoodsType;
    }

    public void setOutGoodsType(String outGoodsType) {
        this.outGoodsType = outGoodsType;
    }

    public String getPickAddress() {
        return pickAddress;
    }

    public void setPickAddress(String pickAddress) {
        this.pickAddress = pickAddress;
    }

    public String getPickAreaCode() {
        return pickAreaCode;
    }

    public void setPickAreaCode(String pickAreaCode) {
        this.pickAreaCode = pickAreaCode;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAlipayName() {
        return alipayName;
    }

    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName;
    }

    public String getWeiXin() {
        return weiXin;
    }

    public void setWeiXin(String weiXin) {
        this.weiXin = weiXin;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getWeighting() {
        return weighting;
    }

    public void setWeighting(int weighting) {
        this.weighting = weighting;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

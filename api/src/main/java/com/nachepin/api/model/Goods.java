package com.nachepin.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Function;
import com.nachepin.api.dto.EnumVal;
import com.nachepin.api.dto.EnumValType;
import com.nachepin.api.model.enums.GoodsStatus;
import com.nachepin.api.model.enums.GoodsType;

@Entity
@Table(name="goods")
public class Goods implements Serializable{

    public static  final Function<Goods, String> CODE_VALUE = new Function<Goods, String>() {
        @Override
        public String apply(Goods g) {
            return g.getCode();
        }
    };

    @Id
    private int id;
    /**
     * 商品编号
     */
    private String code;
    private String name;
    private String brand;
    /**
     * 货号
     */
    private String itemNo;
    @Enumerated(EnumType.STRING)
    @EnumVal(EnumValType.NAME)
    private GoodsType type;
    private Date created;
    private Date onlineTime;
    private long wholesalePrice;
    private long preferentialPrice;
    private long retailPrice;
    private int weight;
    private String color;
    private String size;
    private String fitCar;
    private int stock;
    private Date arrivalTime;
    private String comment;
    @Enumerated
    @EnumVal(EnumValType.MANUAL)
    private GoodsStatus status;
    private int sellerId;
    private String dataPackageUrl1;
    private String dataPackageUrl2;
    private String dataPackageUrl3;
    private String imgPackageUrl1;
    private String imgPackageUrl2;
    private String imgPackageUrl3;
    private String headImgUrl1;
    private String headImgUrl2;
    private String headImgUrl3;
    private String headImgUrl4;
    private String headImgUrl5;
    private String bodyImgUrl1;
    private String bodyImgUrl2;
    private String bodyImgUrl3;
    private String bodyImgUrl4;
    private String bodyImgUrl5;
    private String bodyImgUrl6;
    private String bodyImgUrl7;
    private String bodyImgUrl8;
    private String bodyImgUrl9;
    private String bodyImgUrl10;
    private String bodyImgUrl11;
    private String bodyImgUrl12;
    private Boolean isSpecial;
    private int pv;
    private int followCnt;
    private String checkRemark;
    private int checkerId;
    private Date checkTime;
    private String producer;
    private String origin;
    private Date offlineTime;
    private String offlineRemark;
    private Date deleted;
    private int weighting;
    private int saleNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public GoodsType getType() {
        return type;
    }

    public void setType(GoodsType type) {
        this.type = type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public long getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(long wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public long getPreferentialPrice() {
        return preferentialPrice;
    }

    public void setPreferentialPrice(long preferentialPrice) {
        this.preferentialPrice = preferentialPrice;
    }

    public long getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(long retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFitCar() {
        return fitCar;
    }

    public void setFitCar(String fitCar) {
        this.fitCar = fitCar;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public GoodsStatus getStatus() {
        return status;
    }

    public void setStatus(GoodsStatus status) {
        this.status = status;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getDataPackageUrl1() {
        return dataPackageUrl1;
    }

    public void setDataPackageUrl1(String dataPackageUrl1) {
        this.dataPackageUrl1 = dataPackageUrl1;
    }

    public String getDataPackageUrl2() {
        return dataPackageUrl2;
    }

    public void setDataPackageUrl2(String dataPackageUrl2) {
        this.dataPackageUrl2 = dataPackageUrl2;
    }

    public String getDataPackageUrl3() {
        return dataPackageUrl3;
    }

    public void setDataPackageUrl3(String dataPackageUrl3) {
        this.dataPackageUrl3 = dataPackageUrl3;
    }

    public String getImgPackageUrl1() {
        return imgPackageUrl1;
    }

    public void setImgPackageUrl1(String imgPackageUrl1) {
        this.imgPackageUrl1 = imgPackageUrl1;
    }

    public String getImgPackageUrl2() {
        return imgPackageUrl2;
    }

    public void setImgPackageUrl2(String imgPackageUrl2) {
        this.imgPackageUrl2 = imgPackageUrl2;
    }

    public String getImgPackageUrl3() {
        return imgPackageUrl3;
    }

    public void setImgPackageUrl3(String imgPackageUrl3) {
        this.imgPackageUrl3 = imgPackageUrl3;
    }

    public String getHeadImgUrl1() {
        return headImgUrl1;
    }

    public void setHeadImgUrl1(String headImgUrl1) {
        this.headImgUrl1 = headImgUrl1;
    }

    public String getHeadImgUrl2() {
        return headImgUrl2;
    }

    public void setHeadImgUrl2(String headImgUrl2) {
        this.headImgUrl2 = headImgUrl2;
    }

    public String getHeadImgUrl3() {
        return headImgUrl3;
    }

    public void setHeadImgUrl3(String headImgUrl3) {
        this.headImgUrl3 = headImgUrl3;
    }

    public String getHeadImgUrl4() {
        return headImgUrl4;
    }

    public void setHeadImgUrl4(String headImgUrl4) {
        this.headImgUrl4 = headImgUrl4;
    }

    public String getHeadImgUrl5() {
        return headImgUrl5;
    }

    public void setHeadImgUrl5(String headImgUrl5) {
        this.headImgUrl5 = headImgUrl5;
    }

    public String getBodyImgUrl1() {
        return bodyImgUrl1;
    }

    public void setBodyImgUrl1(String bodyImgUrl1) {
        this.bodyImgUrl1 = bodyImgUrl1;
    }

    public String getBodyImgUrl2() {
        return bodyImgUrl2;
    }

    public void setBodyImgUrl2(String bodyImgUrl2) {
        this.bodyImgUrl2 = bodyImgUrl2;
    }

    public String getBodyImgUrl3() {
        return bodyImgUrl3;
    }

    public void setBodyImgUrl3(String bodyImgUrl3) {
        this.bodyImgUrl3 = bodyImgUrl3;
    }

    public String getBodyImgUrl4() {
        return bodyImgUrl4;
    }

    public void setBodyImgUrl4(String bodyImgUrl4) {
        this.bodyImgUrl4 = bodyImgUrl4;
    }

    public String getBodyImgUrl5() {
        return bodyImgUrl5;
    }

    public void setBodyImgUrl5(String bodyImgUrl5) {
        this.bodyImgUrl5 = bodyImgUrl5;
    }

    public String getBodyImgUrl6() {
        return bodyImgUrl6;
    }

    public void setBodyImgUrl6(String bodyImgUrl6) {
        this.bodyImgUrl6 = bodyImgUrl6;
    }

    public String getBodyImgUrl7() {
        return bodyImgUrl7;
    }

    public void setBodyImgUrl7(String bodyImgUrl7) {
        this.bodyImgUrl7 = bodyImgUrl7;
    }

    public String getBodyImgUrl8() {
        return bodyImgUrl8;
    }

    public void setBodyImgUrl8(String bodyImgUrl8) {
        this.bodyImgUrl8 = bodyImgUrl8;
    }

    public String getBodyImgUrl9() {
        return bodyImgUrl9;
    }

    public void setBodyImgUrl9(String bodyImgUrl9) {
        this.bodyImgUrl9 = bodyImgUrl9;
    }

    public String getBodyImgUrl10() {
        return bodyImgUrl10;
    }

    public void setBodyImgUrl10(String bodyImgUrl10) {
        this.bodyImgUrl10 = bodyImgUrl10;
    }

    public String getBodyImgUrl11() {
        return bodyImgUrl11;
    }

    public void setBodyImgUrl11(String bodyImgUrl11) {
        this.bodyImgUrl11 = bodyImgUrl11;
    }

    public String getBodyImgUrl12() {
        return bodyImgUrl12;
    }

    public void setBodyImgUrl12(String bodyImgUrl12) {
        this.bodyImgUrl12 = bodyImgUrl12;
    }

    public Boolean getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getFollowCnt() {
        return followCnt;
    }

    public void setFollowCnt(int followCnt) {
        this.followCnt = followCnt;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
    }

    public int getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(int checkerId) {
        this.checkerId = checkerId;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(Date offlineTime) {
        this.offlineTime = offlineTime;
    }

    public String getOfflineRemark() {
        return offlineRemark;
    }

    public void setOfflineRemark(String offlineRemark) {
        this.offlineRemark = offlineRemark;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    public int getWeighting() {
        return weighting;
    }

    public void setWeighting(int weighting) {
        this.weighting = weighting;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

}

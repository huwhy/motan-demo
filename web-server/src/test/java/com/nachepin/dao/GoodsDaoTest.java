package com.nachepin.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nachepin.api.dto.PageList;
import com.nachepin.api.dto.PageParam;
import com.nachepin.api.model.Goods;
import com.nachepin.api.model.enums.GoodsType;

public class GoodsDaoTest extends BaseTest{

    @Autowired
    private GoodsDao goodsDao;

    @Test
    public void testFindGoods() {
        PageList<Goods> goodses = goodsDao.findGoods(GoodsType.carTrim, null, new PageParam(10, 1));

        System.out.println(goodses.getData().size());
    }
}

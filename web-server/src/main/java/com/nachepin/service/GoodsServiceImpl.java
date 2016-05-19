package com.nachepin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nachepin.api.dto.PageList;
import com.nachepin.api.dto.PageParam;
import com.nachepin.api.model.Goods;
import com.nachepin.api.model.enums.GoodsStatus;
import com.nachepin.api.model.enums.GoodsType;
import com.nachepin.api.service.IGoodsService;
import com.nachepin.dao.GoodsDao;

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public PageList<Goods> findGoods(GoodsType type, GoodsStatus status, PageParam pageParam) {
        return goodsDao.findGoods(type, status, pageParam);
    }
}

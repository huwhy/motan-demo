package com.nachepin.api.service;

import com.nachepin.api.dto.PageList;
import com.nachepin.api.dto.PageParam;
import com.nachepin.api.model.Goods;
import com.nachepin.api.model.enums.GoodsStatus;
import com.nachepin.api.model.enums.GoodsType;

public interface IGoodsService {

    public PageList<Goods> findGoods(GoodsType type, GoodsStatus status, PageParam pageParam);
}

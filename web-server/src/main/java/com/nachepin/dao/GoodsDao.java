package com.nachepin.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nachepin.api.dto.PageList;
import com.nachepin.api.dto.PageParam;
import com.nachepin.api.model.Goods;
import com.nachepin.api.model.enums.GoodsStatus;
import com.nachepin.api.model.enums.GoodsType;

@Repository
public class GoodsDao extends GeneralCodeDao<Goods, String>{

    public GoodsDao() {
        super("SP", "seq_goods");
    }

    public PageList<Goods> findGoods(GoodsType type, GoodsStatus status, PageParam pageParam) {
        StringBuilder sql = new StringBuilder();
        List<Object> params = new ArrayList<>();

        sql.append("select g.* from goods g").append(" where 1 = 1 ");

        if (type != null) {
            sql.append(" and g.type = ? ");
            params.add(type.name());
        }
        if (status != null) {
            sql.append(" and g.status = ? ");
            params.add(status.getIntValue());
        }

        return paginate(sql.toString(), pageParam, params.toArray());
    }
}

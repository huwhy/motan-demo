package com.nachepin.dao;

import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class GeneralCodeDao<T, PK extends Serializable> extends BaseDao<T, PK> {

    private static DecimalFormat numberFormat = new DecimalFormat("00000");

    private String codePre;

    private String seqName;

    public GeneralCodeDao(String codePre, String seqName) {
        this.codePre = codePre;
        this.seqName = seqName;
    }

    public String getNextCode() {

        Integer nextVal = jdbcTemplate.queryForObject("select nextval(?)", Integer.class, seqName);
        return codePre + numberFormat.format(nextVal);
    }
}

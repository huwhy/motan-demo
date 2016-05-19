package com.nachepin.api.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.nachepin.common.StrKit;

public class PageParam implements Serializable{
    public static final String ASC = "asc";
    public static final String DESC = "desc";
    private int perSize;
    private int curNo;
    private String key;
    private Object val;
    private String alias;
    private int dic;
    private Map<String, String> orderMap = new HashMap();

    public PageParam(int perSize, int curNo) {
        this.perSize = perSize;
        this.curNo = curNo;
        this.orderMap.clear();
    }

    public PageParam(int perSize, int curNo, String key, Object val) {
        this.perSize = perSize;
        this.curNo = curNo;
        this.key = key;
        this.val = val;
        this.orderMap.clear();
    }

    public PageParam(int perSize, int curNo, String key, Object val, String alias) {
        this.perSize = perSize;
        this.curNo = curNo;
        this.key = key;
        this.val = val;
        this.alias = alias;
        this.orderMap.clear();
    }

    public void putSort(String field, String sort) {
        this.orderMap.put(field, sort);
    }

    public void setSort(String sorts) {
        if(StrKit.notBlank(sorts)) {
            String[] sortArr = sorts.split(" ");
            String[] arr$ = sortArr;
            int len$ = sortArr.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String sort = arr$[i$];
                if(sort.contains("_")) {
                    String[] kv = sort.split("_");
                    if(StrKit.notBlank(kv[1])) {
                        this.orderMap.put(kv[0], kv[1]);
                    }
                }
            }
        }

    }

    public String getSortValue() {
        StringBuilder sb = new StringBuilder();
        Iterator i$ = this.orderMap.entrySet().iterator();

        while(i$.hasNext()) {
            Entry entry = (Entry)i$.next();
            if(StrKit.notBlank((String)entry.getValue())) {
                sb.append((String)entry.getKey()).append("_").append((String)entry.getValue()).append(" ");
            }
        }

        if(this.orderMap.size() > 0) {
            sb = sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public void replaceSortField(String key, String field) {
        String sort = (String)this.orderMap.get(key);
        if(sort != null) {
            this.orderMap.put(field, sort);
            this.orderMap.remove(key);
        }

    }

    public String buildSQL() {
        StringBuilder sql = new StringBuilder(" ");
        if(this.orderMap.size() > 0) {
            sql.append(" order by ");
            String prefix = this.alias != null?this.alias + ".":"";
            Iterator i$ = this.orderMap.entrySet().iterator();

            while(i$.hasNext()) {
                Entry entry = (Entry)i$.next();
                sql.append(prefix).append((String)entry.getKey()).append(" ").append((String)entry.getValue()).append(",");
            }

            sql.deleteCharAt(sql.length() - 1);
        }

        sql.append(" limit ").append(this.perSize * (this.curNo - 1)).append(", ").append(this.perSize);
        return sql.toString();
    }

    public int getPerSize() {
        return this.perSize;
    }

    public void setPerSize(int perSize) {
        this.perSize = perSize;
    }

    public int getCurNo() {
        return this.curNo;
    }

    public void setCurNo(int curNo) {
        this.curNo = curNo;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getVal() {
        return this.val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getDic() {
        return this.dic;
    }

    public void setDic(int dic) {
        this.dic = dic;
    }

    public Map<String, String> getSortMap() {
        return this.orderMap;
    }
}

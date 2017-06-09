package com.xhsmart.ssmcxf.entity_8;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * Ik_16
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2016-3-4 下午2:52:30
 */
@SuppressWarnings("serial")
@Alias("Ik_8")
public class Ik_8 implements Serializable {

    private int id;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }
}

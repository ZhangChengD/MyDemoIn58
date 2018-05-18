package com.zc.testList;

public class listBean {
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof listBean && obj!=null ?
                id.equals(((listBean) obj).id) : false;
    }
}

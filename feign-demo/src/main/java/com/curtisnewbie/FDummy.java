package com.curtisnewbie;

/**
 * @author yongjie.zhuang
 */
public class FDummy {

    private String description;

    private Integer number;

    public FDummy() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FDummy{" +
                "description='" + description + '\'' +
                ", number=" + number +
                '}';
    }
}

package com.wu.tx.Bean;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-17 14:12
 */
public enum OpTypes {
    deposite("deposite", 1), withdraw("withdraw", 2), transfer("transfer", 3);
    private String name;
    private int index;

    OpTypes(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "OpTypes{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

    public String getName() {
        return name;
    }
}

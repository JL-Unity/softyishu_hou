package com.example.hotel.baen;


import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.ArrayList;

@Controller
public class ResultModel<T> implements Serializable{
    private int code;
    private String msg;
    private T data ;
    private ArrayList<T> arrayList;

    public ResultModel() {

    }

    public ResultModel(int errorCode, String msg, T data, ArrayList<T> arrayList) {
        this.code = errorCode;
        this.msg = msg;
        this.data = data;
        this.arrayList = arrayList;
    }

    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

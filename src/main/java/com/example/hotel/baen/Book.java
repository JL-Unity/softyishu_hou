package com.example.hotel.baen;

public class Book {
    private Integer id;

    private String bookinfo;

    private String time;

    private Integer price;

    private Integer reserve;

    private Integer typeid;

    private Integer userid;

    private Integer buyorsell;

    private String bookphone;

    private String bookname;

    private String bookaddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookinfo() {
        return bookinfo;
    }

    public void setBookinfo(String bookinfo) {
        this.bookinfo = bookinfo == null ? null : bookinfo.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBuyorsell() {
        return buyorsell;
    }

    public void setBuyorsell(Integer buyorsell) {
        this.buyorsell = buyorsell;
    }

    public String getBookphone() {
        return bookphone;
    }

    public void setBookphone(String bookphone) {
        this.bookphone = bookphone == null ? null : bookphone.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getBookaddress() {
        return bookaddress;
    }

    public void setBookaddress(String bookaddress) {
        this.bookaddress = bookaddress == null ? null : bookaddress.trim();
    }
}
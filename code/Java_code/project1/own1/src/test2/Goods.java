package test2;
/*
构造一个货物类
* */
public class Goods {
    private int id;
    private String name;
    private int quantity;
    private double money;

    public Goods() {            //无参构造器
    }

    public Goods(int id, String name, int quantity, double money) {           //有参构造器
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.money = money;
    }
/*
    标准 JavaBean 进行程序封装
* */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}

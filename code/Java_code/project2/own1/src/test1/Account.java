package test1;

public class Account {
    private String id;
    private String password;
    private String name;
    private double money;
    private double limitmoney;

    public Account(String id, String password, String name, double limitmoney) {//有参构造器
        this.id = id;
        this.name = name;
        this.limitmoney = limitmoney;
        this.password = password;
    }

    public Account() {//无参构造器
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getLimitmoney() {
        return limitmoney;
    }

    public void setLimitmoner(double limitmoney) {
        this.limitmoney = limitmoney;
    }

}

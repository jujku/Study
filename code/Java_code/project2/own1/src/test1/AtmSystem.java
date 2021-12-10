package test1;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AtmSystem {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<Account>();//创建一个集合存放用户数据
        Scanner sc = new Scanner(System.in);
        choice(accounts, sc);//进入选择方法
    }

    /**
     *用户选择注册或者登录的函数
     * @param sc 让用户选择1注册2登录
     */
    public static void choice(ArrayList<Account> accounts, Scanner sc) {
        while (true) {
            int is;//存放用户输入的指令
            System.out.println("===============ATM首页==============");
            System.out.println("1.登录账户");
            System.out.println("2.注册账户");
            System.out.println("请输入您需要的操作:");
            is = sc.nextInt();
            switch(is) {
                case 1:
                    //用户登录
                    loginAccount(accounts, sc);
                    break;
                case 2:
                    //用户注册
                    addUser(accounts, sc);//注册方法
                    break;
                case 10001:
                    //看用户数据的后台
                    admin(accounts);
                    break;
                case 10005:
                    //看用户密码及余额的后台
                    adminpro(accounts);
                    break;
                default:
                    System.out.println("请输入正确的指令");
            }
        }
    }


//=======================================================注册==========================================================
    /**
     * 新建用户方法
     * @param accounts 账户集合
     * @param sc 调用的扫描器
     */
    public static void addUser(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("=============ATM注册页面============");
        System.out.println("请输入您的姓名：");
        String name = sc.next();
        String password2;
        while (true) {
            System.out.println("请输入您的密码");
            String password1 = sc.next();//第一次的密码
            System.out.println("请再次输入您的密码");
            password2 = sc.next();//第二次输入的密码；
            if (password1.equals(password2)) {
                System.out.println("密码设置成功");
                break;
            }else{
                System.out.println("您两次输入的密码不一致，请重新输入！");
            }
        }

        System.out.println("请输入您每日的取款上限");
        double limitmoney = sc.nextDouble();

        String id = newId(accounts, 8);//新建id方法
        Account T = new Account(id, password2, name, limitmoney);
        accounts.add(T);
        System.out.println("=========注册成功==========");
        System.out.println("您的账户id:" + id);
        System.out.println("您的账户名:" + name);
        System.out.println("您的每日交易上限:" + limitmoney);
        System.out.println("==========================");
    }

    /**
     *新建id方法
     * @param accounts 集合
     * @param n 表示id个数
     * @return 返回的id
     */
    public static String newId(ArrayList<Account> accounts, int n) {
        Random rx = new Random();
        String id = "";
        while (true) {
            for (int i = 0; i < n; i++) {
                id += rx.nextInt(10);
            }
            if (queryId(id, accounts) != null) {//判断id是否重复
                break;
            }

        }
        return id;
    }


    /**
     * 判断新建的id是否和前面重复，重复返回null，不重复返回id
     * @param id 随机产生的id
     * @param accounts 集合
     * @return
     */
    public static String queryId(String id, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(id)) {//将生成的id与其他之前的id进行比对
                id = null;
                return id;
            }
        }
    return id;
    }


//===============================================登录===================================================

    /**
     * 进行登录账户的判断
     * @param accounts 用户对象的集合
     * @param sc 扫描器
     */
    public static void loginAccount(ArrayList<Account> accounts, Scanner sc) {

        while (true) {

            System.out.println("请输入您的卡号");
            String id = sc.next();
            System.out.println("请输入您的密码");
            String password = sc.next();
            int key = queryLoginId(id, accounts);//key为id索引，存在返回索引，不存在返回-1
            //调用判断id方法判断此id是否存在 当id存在返回值为此id所在集合元素的索引不存在返回-1
            if (key != -1) {
                             //有卡号,开始判断密码是否正确
                if (accounts.get(key).getPassword().equals(password)) {//判断索引位置的对象的密码是否为用户输入的密码。
                    //登录成功，开始进入登录页面
                    userPage(accounts, key, sc);//进入登录界面
                }else {
                    System.out.println("卡号或密码错误请重新输入");
                }

            }else {
                System.out.println("卡号或密码错误请重新输入");
            }



        }

    }

    /**
     * 如果accounts中存在此id，则返回值为此id所在集合元素的索引。不存在返回-1
     * @param id 用户输入的id
     * @param accounts 用户信息集合
     * @return 返回值
     */
    public static int queryLoginId(String id, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }


//=======================================用户主页================================================

    /**
     * 登录后的页面
     * @param  accounts 类的集合
     *         key 对象索引
     */
    public static void userPage(ArrayList<Account> accounts, int key, Scanner sc) {
        while (true) {
            System.out.println("====================ATM系统用户操作页面=================");
            System.out.println("1.查询");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出");
            System.out.println("7.注销当前账户");
            int is = sc.nextInt();
            System.out.println("-----------------------------------------------------");
            switch (is) {
                case 1:
                    //查询功能
                    queryAccount(accounts, key);
                    break;
                case 2:
                    //存款功能
                    addMoney(accounts, key, sc);
                    break;
                case 3:
                    //取款功能
                    drawMoney(accounts, key, sc);
                    break;
                case 4:
                    //转账
                    break;
                case 5:
                    //修改密码
                    changePassWord(accounts, key, sc);
                    break;
                case 6:
                    //退出
                    choice(accounts, sc);//进入选择方法
                    break;
                case 7:
                    //注销
                    deleteaccount(accounts, key, sc);
                    break;
                default:
                    System.out.println("您输入的指令有误，请重新输入！");
            }

        }

    }



    /**
     * 查询系统
     * @param accounts 用户对象集合
     * @param key 该用户的索引
     */
    public static void queryAccount(ArrayList<Account> accounts, int key) {
        System.out.println("====================ATM系统用户查询页面=================");
        NumberFormat nf = NumberFormat.getInstance();//禁用科学计数法
        nf.setGroupingUsed(false);//禁用科学计数法
        System.out.println("您的账户信息如下");
        System.out.println("卡号：" + accounts.get(key).getId());
        System.out.println("姓名：" + accounts.get(key).getName());
        System.out.println("余额：" + nf.format(accounts.get(key).getMoney()));
        System.out.println("当此取现额度：" + accounts.get(key).getLimitmoney());
        System.out.println("-----------------------------------------------------");
    }


    /**
     * 存款页面方法
     * @param accounts 用户集合
     * @param key 对象索引
     * @param sc 扫描器
     */
    public static void addMoney(ArrayList<Account> accounts, int key, Scanner sc) {
        System.out.println("====================ATM系统用户存款页面=================");
        System.out.println("请放入您的存款");
        double money = sc.nextDouble();
        accounts.get(key).setMoney(money);
        NumberFormat nf = NumberFormat.getInstance();//禁用科学计数法
        nf.setGroupingUsed(false);//禁用科学计数法
        System.out.println("存款成功，您的当前余额为" + nf.format(accounts.get(key).getMoney()));
        System.out.println("=====================================================");
    }

    /**
     * 取款的方法
     * @param accounts 用户集合
     * @param key 对象索引
     * @param sc 扫描器
     */
    private static void drawMoney(ArrayList<Account> accounts, int key, Scanner sc) {
        System.out.println("====================ATM系统用户取款款页面=================");

        while (true) {
            System.out.println("请输入您要取出的金额");
            double money = sc.nextDouble();//需要取出的金额

            if (money > accounts.get(key).getLimitmoney()) {
                System.out.println("取款失败，本次取款金额超过当此限额");
            }else if (money > accounts.get(key).getMoney()) {
                System.out.println("余额不足");
            }else {
                accounts.get(key).setMoney(accounts.get(key).getMoney() - money);
                System.out.println("取款成功，当前余额为：" + accounts.get(key).getMoney());
                System.out.println("-----------------------------------------------------");
                break;
            }
        }

    }


    /**
     * 修改密码方法
     * @param accounts 对象集合
     * @param key 对象索引
     * @param sc 扫描器
     */
    private static void changePassWord(ArrayList<Account> accounts, int key, Scanner sc) {
        while (true) {
            System.out.println("请输入原密码");
            String beforepasswoed = sc.next();
            String password1;
            String password2;

            if (accounts.get(key).getPassword().equals(beforepasswoed)) {//如果原密码正确，那就检查两次的密码是否一致
                while (true) {

                    System.out.println("请输入修改后的密码");
                    password1 = sc.next();
                    System.out.println("请再次输入修改后的密码");
                    password2 = sc.next();
                    if (password1.equals(password2)) {
                        accounts.get(key).setPassword(password2);
                        System.out.println("修改成功");
                        return;
                    } else {
                        System.out.println("两次密码不一致，请重新输入");
                    }
                }
            }else {
                System.out.println("原密码不正确请重新输入");
            }



        }




    }


    /**
     * 注销账户，并取出余额
     * @param accounts 对象集合
     * @param key 对象索引
     * @param sc 扫描器
     */
    private static void deleteaccount(ArrayList<Account> accounts, int key, Scanner sc) {
        while (true) {
            if (accounts.get(key).getMoney() == 0) {
                System.out.println("您当前账户中余额为0，是否注销（是/否）");
            }else {
                System.out.println("您当前账户中余额为0，是否取出所有的余额并注销（是/否）");
            }
            String is = sc.next();
            if (is.equals( "是")) {
                accounts.remove(key);
                System.out.println("注销成功！");
                choice(accounts, sc);//进入选择方法，该用户不存在了
                return;
            }else if (is.equals("否")){
                return;
            }else {
                System.out.println("输入错误，请重新输入");
            }
        }
    }










    /**
     * 提取用户信息
     * @param accounts
     */
    public static void admin(ArrayList<Account>accounts) {
        if (accounts.size() == 0) {
            System.out.println("暂时没有用户");
        }else {
            System.out.println("==========================================");
            System.out.println("id                 姓名           ");

            for (int i = 0; i < accounts.size(); i++) {

                System.out.println(accounts.get(i).getId() + "            " + accounts.get(i).getName());
            }
        }
        System.out.println("=========================================");

    }

    /**
     * 查看密码的后台
     * @param accounts
     */
    public static void adminpro(ArrayList<Account>accounts) {
        if (accounts.size() == 0) {
            System.out.println("暂时没有用户");
        }else {
            System.out.println("==========================================");
            System.out.println("id                 姓名                      密码                           余额");

            for (int i = 0; i < accounts.size(); i++) {

                System.out.print(accounts.get(i).getId() + "            " + accounts.get(i).getName() + "                 ");
                System.out.println(accounts.get(i).getPassword() + "            " + accounts.get(i).getMoney() + "                 ");
            }
        }
        System.out.println("=========================================");

    }







}

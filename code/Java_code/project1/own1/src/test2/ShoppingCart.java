package test2;

import java.util.Scanner;
public class ShoppingCart {
    public static void main(String[] args) {
        //模拟购物车系统，add(添加商品)， query(查询商品)， modify(修改商品数量)， pay(支付)
        Goods[] shopcar = new Goods[100];
        Scanner sc  = new Scanner(System.in);
        while (true){
            System.out.println("请输入指令:add(添加商品)， query(查询商品)， modify(修改商品数量)， pay(支付)");
            String instructions = sc.next();

            switch (instructions){
                case "add" :
                    addgoods(shopcar, sc);
                break;
                case "query" :
                    querygoods(shopcar, sc);
                break;
                case "modify" :
                    modifygoods(shopcar, sc);
                break;
                case "pay" :
                    paygoofs(shopcar);
                break;
                default:
                    System.out.println("输入指令错误，请重新输入");
            }
        }

    }


    public static void addgoods(Goods[] shopcar, Scanner sc){//添加商品的方法

        Goods T = new Goods();//无参构造器

        for (int i = 0; i < shopcar.length; i++) {
            if (shopcar[i] == null){
                System.out.println("请输入商品id");
                // int id = sc.nextInt();
                T.setId(sc.nextInt());
                System.out.println("请输入商品名称");
                T.setName(sc.next());
                System.out.println("请输入商品购买数量");
                T.setQuantity(sc.nextInt());
                System.out.println("请输入商品单价");
                T.setMoney(sc.nextDouble());
                System.out.println("添加成功！");
                shopcar[i] = T;
                break;
            }

        }

    }



    public static void querygoods(Goods[] shopcar, Scanner sc){  //遍历商品的函数

        System.out.println("商品id\t\t\t商品名称\t\t\t\t\t商品数量\t\t\t\t商品单价\t\t\t\t");
        boolean flag = true;
        for (int i = 0; i < shopcar.length; i++) {
            Goods T = new Goods();
            if (shopcar[i] != null){
                flag = false;
                T = shopcar[i];
                System.out.println(T.getId() + "             " + T.getName() + "               " + T.getQuantity() + "                       " + T.getMoney());
            }

        }

        if (flag == true){
            System.out.println("您还未添加任何商品");
        }else{
            System.out.println("商品查询完毕");
        }

    }


    public static void modifygoods(Goods[] shopcar, Scanner sc){  //修改商品数量的方法

        System.out.println("请输入您要修改的商品id");                    //bug
        int id = sc.nextInt();
        for (int i = 0; i < shopcar.length; i++) {
            Goods T = new Goods();
            T = shopcar[i];
            if (T == null){
                System.out.println("您的购物车中没有此商品");
                break;
            }else if (T.getId() == id){
                System.out.println("请输入修改后的数量");
                T.setQuantity(sc.nextInt());
                shopcar[i] = T;
                System.out.println("修改成功" + T.getName() + "数量当前为" + T.getQuantity());

                break;
            }else{
                System.out.println("您的购物车中没有此商品");
                break;
            }

        }



    }


    public static void paygoofs(Goods[] shopcar){          //支付商品的方法
        double sum = 0;
        Goods T = new Goods();

        for (int i = 0; i < shopcar.length; i++) {
            T = shopcar[i];
            if (T != null){
                sum += (T.getMoney() * T.getQuantity());
            }else if (i == 0){
                System.out.println("您购物车没有任何商品");
                return;
            }
        }
        System.out.println("支付成功，一共" + sum + "元");
    }




}

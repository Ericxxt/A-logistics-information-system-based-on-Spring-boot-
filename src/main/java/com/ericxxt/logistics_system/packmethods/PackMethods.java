package com.ericxxt.logistics_system.packmethods;

import com.ericxxt.logistics_system.entity.Order;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PackMethods {

    public static String time_change(String initial_time){
//        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String initial_one=
        Timestamp ts1=Timestamp.valueOf(initial_time);
        Timestamp ts2=new Timestamp(System.currentTimeMillis());
        long timed=(ts2.getTime()-ts1.getTime())/1000;
        StringBuilder stringBuilder=new StringBuilder();
        if(timed>86400){
            stringBuilder.append(timed/86400+"天");
            timed=timed%86400;
        }
        if(timed>3600){
            stringBuilder.append(timed/3600+"小时");
            timed=timed%3600;
        }
        stringBuilder.append(timed/60+"分钟");
        return stringBuilder.toString();
    }
    //返回已经完成的订单
    public static ArrayList<ArrayList<Order>> user_classed_order(List<Order> orders,int user_id){
        ArrayList<Order> ing_orders=new ArrayList<>();
        ArrayList<Order> sending_orders=new ArrayList<>();
        ArrayList<Order> finished_orders=new ArrayList<>();
        for(Order order:orders){
            if("完成".equals(order.getStatus())){
                order.setLive_time(time_change(order.getInitial_time()));
                finished_orders.add(order);
            }else if(user_id==order.getReceiver_id()){
                ing_orders.add(order);
            }else {
                sending_orders.add(order);
            }
        }
        ArrayList<ArrayList<Order>> user_classed_orders=new ArrayList<>();
        user_classed_orders.add(ing_orders);
        user_classed_orders.add(sending_orders);
        user_classed_orders.add(finished_orders);
        return user_classed_orders;
    }
    public static ArrayList<ArrayList<Order>> manager_classed_order(List<Order> orders){
        ArrayList<Order> unview_orders=new ArrayList<>();
        ArrayList<Order> checked_orders=new ArrayList<>();
        ArrayList<Order> finished_orders=new ArrayList<>();
        for(Order order:orders){
            //"已分配" "配送中"
            if("已删除".equals(order.getStatus())){
                unview_orders.add(order);
            }else if("已分配".equals(order.getStatus())){
                checked_orders.add(order);
            }else{
                if("完成".equals(order.getStatus())){
                    order.setLive_time(time_change(order.getInitial_time()));
                }
                finished_orders.add(order);
            }
        }
        ArrayList<ArrayList<Order>> manager_classed_orders=new ArrayList<>();
        manager_classed_orders.add(unview_orders);
        manager_classed_orders.add(checked_orders);
        manager_classed_orders.add(finished_orders);
        return manager_classed_orders;

    }

    public static ArrayList<ArrayList<Order>> deliver_classed_order(List<Order> orders){
        ArrayList<Order> unhandled_orders=new ArrayList<>();
        ArrayList<Order> checked_orders=new ArrayList<>();
        ArrayList<Order> finished_orders=new ArrayList<>();
        for(Order order:orders){
            //"已分配" "配送中"
            if("配送中".equals(order.getStatus())){
                order.setLive_time(time_change(order.getInitial_time()));
                checked_orders.add(order);
            }else if("完成".equals(order.getStatus())){
                order.setLive_time(time_change(order.getInitial_time()));
                finished_orders.add(order);
            }else{
                unhandled_orders.add(order);
            }
        }
        ArrayList<ArrayList<Order>> deliver_classed_orders=new ArrayList<>();
        deliver_classed_orders.add(unhandled_orders);
        deliver_classed_orders.add(checked_orders);
        deliver_classed_orders.add(finished_orders);
        return deliver_classed_orders;

    }

}

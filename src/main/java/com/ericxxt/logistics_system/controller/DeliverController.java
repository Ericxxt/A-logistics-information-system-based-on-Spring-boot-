package com.ericxxt.logistics_system.controller;


import com.ericxxt.logistics_system.entity.Deliver;
import com.ericxxt.logistics_system.entity.Manager;
import com.ericxxt.logistics_system.entity.Order;
import com.ericxxt.logistics_system.packmethods.PackMethods;
import com.ericxxt.logistics_system.service.DeliverService;
import com.ericxxt.logistics_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/deliver")
public class DeliverController {
    //管理员订单管理页面
    @Autowired
    private OrderService orderService;
    private PackMethods packMethods;

    //跳转至配送员订单管理界面
    @RequestMapping("/to_deliver_order_management")
    public String to_deliver_order_management(HttpServletRequest request, Model model){
        Deliver deliver= (Deliver) request.getSession().getAttribute("deliver");
        System.out.println("manager_id:"+deliver.getDeliver_id());
        List<Order> orders=orderService.deliver_Orders(deliver.getDeliver_id());
        ArrayList<ArrayList<Order>> classed_lists=packMethods.deliver_classed_order(orders);
        model.addAttribute("unhandled_orders",classed_lists.get(0));
        model.addAttribute("checked_orders",classed_lists.get(1));
        model.addAttribute("finished_orders",classed_lists.get(2));
        return "deliver_order_management";
    }

    @Autowired
    private DeliverService deliverService;

    //更新刚接收处理的订单
    @RequestMapping("/handle_order")
    public String handle_order(@RequestParam String unhandled_order_id
            ,@RequestParam String unhandled_status,@RequestParam String unhandled_volume,@RequestParam String unhandled_trans_info){
        deliverService.update_order(Integer.parseInt(unhandled_order_id),unhandled_status,unhandled_volume,unhandled_trans_info);
        return "redirect:/deliver/to_deliver_order_management";
    }

    //更新运输中的订单信息
    @RequestMapping("/update_order")
    public String update_order(@RequestParam String checked_order_id
            ,@RequestParam String checked_status,@RequestParam String checked_initial_time
            , @RequestParam String checked_volume,@RequestParam String checked_trans_info){
        if("完成".equals(checked_status)){
                deliverService.finish_time(Integer.parseInt(checked_order_id),packMethods.time_change(checked_initial_time));
        }
        deliverService.update_order(Integer.parseInt(checked_order_id),checked_status,checked_volume,checked_trans_info);
        return "redirect:/deliver/to_deliver_order_management";
    }

    //log out
    @RequestMapping("/log_out")
    public String log_out(HttpServletRequest request){
        request.getSession().removeAttribute("deliver");
        return "index";
    }

}

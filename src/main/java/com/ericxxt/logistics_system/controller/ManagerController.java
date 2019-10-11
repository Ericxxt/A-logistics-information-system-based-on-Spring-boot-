package com.ericxxt.logistics_system.controller;

import com.ericxxt.logistics_system.entity.Deliver;
import com.ericxxt.logistics_system.entity.Manager;
import com.ericxxt.logistics_system.entity.Order;
import com.ericxxt.logistics_system.entity.User;
import com.ericxxt.logistics_system.packmethods.PackMethods;
import com.ericxxt.logistics_system.service.DeliverService;
import com.ericxxt.logistics_system.service.ManagerService;
import com.ericxxt.logistics_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/manager")
public class ManagerController {
    //管理员订单管理页面
    @Autowired
    private OrderService orderService;

    private PackMethods packMethods;

    //跳转至订单管理界面
    @RequestMapping("/to_manager_order_management")
    public String to_manager_order_management(HttpServletRequest request, Model model){
        Manager manager= (Manager) request.getSession().getAttribute("manager");
        System.out.println("manager_id:"+manager.getManager_id());
        List<Order> orders=orderService.manager_Orders(manager.getManager_id());
        System.out.println("time:"+orders.get(0).getInitial_time());
        ArrayList<ArrayList<Order>> classed_lists=packMethods.manager_classed_order(orders);
        List<String> provinces=managerService.deliver_provinces();
        List<Order> unview_orders=orderService.unview_Orders();
        unview_orders.addAll(classed_lists.get(0));
        model.addAttribute("provinces",provinces);
        model.addAttribute("unview_orders",unview_orders);
        model.addAttribute("checked_orders",classed_lists.get(1));
        model.addAttribute("finished_orders",classed_lists.get(2));
        model.addAttribute("salary",manager.getSalary());
        return "manager_order_management";
    }
    //将待分配订单进行处理
    @Autowired
    private ManagerService managerService;
    @RequestMapping("/deliver_order")
    public String deliver_order(HttpServletRequest request
            ,@RequestParam String order_id,@RequestParam String deliver
            ,@RequestParam String status,@RequestParam String trans_info){
        Manager manager= (Manager) request.getSession().getAttribute("manager");
//        String[] strs=deliver_info.split(",");
//        int deliver_id=Integer.parseInt(strs[0]);
        System.out.println("tans_info:"+trans_info);
        managerService.update_order(Integer.parseInt(order_id),manager.getManager_id()
                ,Integer.parseInt(deliver),status,trans_info);
//        managerService.update_news(deliver_id);
        return "redirect:/manager/to_manager_order_management";

    }
    //
    @RequestMapping("/to_login")
    public String to_login(){
        return "manager_login";
    }
    //log out
    @RequestMapping("/log_out")
    public String log_out(HttpServletRequest request){
        request.getSession().removeAttribute("manager");
        return "index";
    }
    //select_deliver
    @RequestMapping("/select_deliver")
    @ResponseBody
    public List<Deliver> select_deliver(HttpServletRequest request){
        String province=request.getParameter("province");
        List<Deliver> delivers=managerService.select_order_delivers(province);
        return delivers;
    }
    //log VERIFY
    @Autowired
    private DeliverService deliverService;

    @RequestMapping("/login_verify")//登录验证
    public String login_verify(HttpServletRequest request,@RequestParam String username
           ,@RequestParam String identity,@RequestParam String password){
        if("1".equals(identity)){
            Manager login_result=managerService.login_verify(username,password);
            if(login_result!=null){
                request.getSession().setAttribute("manager",login_result);
                return "redirect:/manager/to_manager_order_management";
            }
            return "redirect:/manager/to_login";
        }else {
            Deliver deliver_result = deliverService.login_verify(username, password);
            if (deliver_result != null) {
                request.getSession().setAttribute("deliver", deliver_result);
                return "redirect:/deliver/to_deliver_order_management";
            }
            return "redirect:/manager/to_login";
        }
    }
}

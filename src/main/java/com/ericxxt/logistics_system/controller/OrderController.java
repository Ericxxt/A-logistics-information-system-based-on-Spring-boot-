package com.ericxxt.logistics_system.controller;


import com.ericxxt.logistics_system.entity.Order;
import com.ericxxt.logistics_system.entity.User;
import com.ericxxt.logistics_system.service.OrderService;
import com.ericxxt.logistics_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserService userService;

    @RequestMapping("/to_generate")
    public String to_generate(Model model){
        List<String> provinces=userService.show_provinces();
        model.addAttribute("provinces",provinces);
        return "order_generate";

    }

    @Autowired
    private OrderService orderService;
    //创建订单
    @RequestMapping("/generate")
    public String generate(HttpServletRequest request
            , @RequestParam String order_name,@RequestParam String order_type,@RequestParam String receiver_id
            ,@RequestParam String receiver_name,@RequestParam String receiver_province
            ,@RequestParam String receiver_city,@RequestParam String receiver_area
            ,@RequestParam String receiver_address,@RequestParam String receiver_phone){
        if("".equals(receiver_id)){
            receiver_id="0000";
        }
        User user= (User) request.getSession().getAttribute("user");
        Order order =new Order(order_name,order_type,user.getUser_id(),user.getUsername()
                ,user.getProvince(),user.getCity(),user.getArea(),user.getAddress()
        ,user.getPhoneNum(),Integer.parseInt(receiver_id),receiver_name,receiver_province,receiver_city
        ,receiver_area,receiver_address,receiver_phone);
        int insert_result=orderService.insertOrder(order);
        if(insert_result<1){
            //这里需要session认证
            request.setAttribute("insert_result","订单创建失败！");
            return "order_generate";
        }
        request.setAttribute("insert_result","订单创建成功！");
//        orderService.manager_Orders();
            return "index";

    }

}

package com.ericxxt.logistics_system.controller;


import com.ericxxt.logistics_system.entity.Order;
import com.ericxxt.logistics_system.entity.User;
import com.ericxxt.logistics_system.packmethods.PackMethods;
import com.ericxxt.logistics_system.service.OrderService;
import com.ericxxt.logistics_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //跳转至主页面
    @RequestMapping("/mainpage")
    public String mainpage(HttpServletRequest request){
//        User user=userService.selectAllUsers();
//        request.getSession().setAttribute("user",user);

        return "index";
    }

    //跳转登录界面
    @RequestMapping("/to_login")
    public String to_login(HttpServletRequest request,Model model){
        List<String> provinces=userService.show_provinces();
        model.addAttribute("provinces",provinces);
        if(request.getSession().getAttribute("insert_result")!=null){
            request.getSession().removeAttribute("insert_result");
        }
        return "user_login";
    }

    @RequestMapping("/login_verify")//登录验证
    public String login_verify(HttpServletRequest request,@RequestParam String username,@RequestParam String password){
            User user=userService.login_verify(username,password);
            if (user==null){
                return "to_login";
            }
           request.getSession().setAttribute("user",user);//需要前台验证是否为空决定跳转
            return "index";
    }
    //用户注册
    @RequestMapping("/register")
    public String register(HttpServletRequest request,@RequestParam String username,@RequestParam String password
            ,@RequestParam String province,@RequestParam String city
            ,@RequestParam String area,@RequestParam String address
            ,@RequestParam String sex,@RequestParam String phoneNum){

        User user=new User(username,password,province,city,area,address,sex,phoneNum);
        int insert_result=userService.insertUser(user);
        if(insert_result<1){
            request.getSession().setAttribute("insert_result","注册失败");
        }else {
            request.getSession().setAttribute("insert_result", "注册成功");
        }
        return "redirect:/user/to_login";
    }
    //log out
    @RequestMapping("/log_out")
    public String log_out(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "index";
    }

    //查询订单页面
    @Autowired
    private OrderService orderService;

    @RequestMapping("/to_order_query")
    public String to_order_query(){
        return "user_order";
    }

    @ResponseBody
    @RequestMapping("/order_query")
    public Order order_query(@RequestParam String order_id,Model model){
        Order order=orderService.selectOrder(Integer.parseInt(order_id));
        order.setLive_time(PackMethods.time_change(order.getInitial_time()));
        return order;
    }
    //查询订单页面

    //用户订单管理页面
    private PackMethods packMethods;
    @RequestMapping("/to_user_order_management")
    public String to_user_order_management(HttpServletRequest request,Model model){
        User user= (User) request.getSession().getAttribute("user");
        List<Order> orders=orderService.user_Orders(user.getUser_id());
        ArrayList<ArrayList<Order>> classed_lists=packMethods.user_classed_order(orders,user.getUser_id());
        System.out.println("yemian:"+user.getUser_id());
        model.addAttribute("ing_orders",classed_lists.get(0));
        model.addAttribute("sending_orders",classed_lists.get(1));
        model.addAttribute("finished_orders",classed_lists.get(2));

        return "user_order_management";
    }

    //城市更新

    @RequestMapping("/show_cities")
    @ResponseBody
    public List<String> show_cities(HttpServletRequest request){
        System.out.println("province:"+request.getParameter("province"));
            List<String> cities=userService.show_cities(request.getParameter("province"));
            System.out.println("cities:"+cities);
            return cities;
    }
    //辖区更新
    @RequestMapping("/show_areas")
    @ResponseBody
    public List<String> show_areas(HttpServletRequest request){
        List<String> areas=userService.show_areas(request.getParameter("city"));
        return areas;
    }
    //在订单分配之前删除订单有效
    @RequestMapping("/delete_order")
    public String delete_order(HttpServletRequest request,@RequestParam String order_id){
        int delete_result=orderService.deleteOrder(Integer.parseInt(order_id));
        if (delete_result<1){
           request.getSession().setAttribute("deleteInfo","订单删除失败");
        }
        request.getSession().setAttribute("deleteInfo","订单删除成功");
        return "redirect:/user/to_user_order_management";
    }

    //just a test
    @RequestMapping("/test")
    public String test(){
        return "user_order_management";
    }

}

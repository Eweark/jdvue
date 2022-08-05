package com.cykj.controller;

import com.alibaba.fastjson.JSONArray;
import com.cykj.bean.Tblstaff;
import com.cykj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userList", method = RequestMethod.POST,
            produces="application/json;charset=utf-8")
    public String userList(Model model){
        System.out.println("userList---");
        Map<String, Object> map = userService.selUserList("", "");
        model.addAttribute("StaffList",map.get("staffList"));
        return JSONArray.toJSONString(map);
    }
    @RequestMapping("/selUser")
    public Map<String, Object> userList(Model model, String acc, String name, int pageCurr, int pageSize){
        return userService.selUserList(acc, name);
    }
    @RequestMapping("/delUser")
    public int delUser(int id){
        int i = userService.delUser(id);
        if (i > 0){
            return 1;
        }else {
            return 0;
        }
    }
    @RequestMapping("/insUser")
    public int insertUser(Tblstaff tblstaff){
        int i = userService.insertUser(tblstaff);
        if (i > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @RequestMapping("/updUser")
    public int updateUser(Tblstaff tblstaff){
        int i = userService.updateUser(tblstaff);
        if (i > 0){
            return 1;
        }else {
            return 0;
        }
    }

}

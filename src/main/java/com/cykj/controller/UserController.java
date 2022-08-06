package com.cykj.controller;

import com.alibaba.fastjson.JSONArray;
import com.cykj.bean.Tblstaff;
import com.cykj.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/user")
@Api(value = "接口说明",tags = "用户控制器")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增用户",notes = "获取用户管理集合")
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

    @GetMapping("/insert")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名"),
            @ApiImplicitParam(name = "password",value = "密码")
    })
    public String insert(@RequestParam("username") String Username,@RequestParam("password") String Password) {
        return "插入成功";
    }

}

package com.example.baseproject.modules.jpa.controller;

import com.example.baseproject.common.model.ResultEntity;
import com.example.baseproject.modules.jpa.entity.UserModel;
import com.example.baseproject.modules.elasticsearch.entity.LogsIndex;
import com.example.baseproject.modules.elasticsearch.repository.LogsRepostitory;
import com.example.baseproject.modules.jpa.repository.UserRepostitory;
import com.example.baseproject.modules.jpa.service.UserService;
import com.example.baseproject.common.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created With IDEA.
 *
 * @author dongyaofeng
 * @date 2018/1/2 15:37
 */
@RestController
public class UserController {

    @Autowired
    /*为了方便直接注入 UserRepostitory*/
    private UserRepostitory userRepostitory;

    @Autowired
    private LogsRepostitory logsRepostitory;

    @Autowired
    private UserService userService;

    @PostMapping("users")
    public ResultEntity<UserModel> addUser(UserModel userModel) {
        UserModel user = userService.addUser(userModel);
        return ResultUtil.post(user);
    }

    @DeleteMapping("users/{id}")
    public ResultEntity<UserModel> delUser(@PathVariable(name = "id") Integer id) {
        userRepostitory.delete(id);
        return ResultUtil.del();
    }


    @PutMapping("users/{id}")
    public ResultEntity<UserModel> updateUser(@PathVariable(name = "id", required = true) Integer id, UserModel userModel) {
        userModel.setId(id);
        UserModel user = userRepostitory.save(userModel);
        return ResultUtil.put(user);
    }


    @GetMapping("users/{id}")
    public ResultEntity<UserModel> findUserById(@PathVariable(name = "id") Integer id) {
        LogsIndex logsIndex= new LogsIndex();
        logsIndex.setId(1L);
        logsIndex.setText("中华佛教");
        logsRepostitory.save(logsIndex);
        UserModel one = userRepostitory.findById(id);
        return ResultUtil.success(one);
    }
}
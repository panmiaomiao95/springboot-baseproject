package com.example.baseproject.controller;

import com.example.baseproject.repostitory.PersonRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Company
 * @Discription
 * @Author guoxiaojing
 * @CreateDate 2018/1/25 16:16
 * @Version 1.0
 */
//@RestController
@Controller
public class PersonController {
    @Autowired
    private PersonRepostitory personRepostitory;

}

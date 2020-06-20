package com.apl.inner.sys.controller;


import com.apl.inner.sys.pojo.DeptPo;
import com.apl.inner.sys.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

;

/**
 *
 * @author cy
 * @since 2019-12-19
 */
@RestController
@RequestMapping("/test")
public class UnitController {


    @Autowired
    DeptService deptService;

    @GetMapping("/get")
    public DeptPo getList(Long deptId){

        System.out.println("/test/get");
        return deptService.getDeptById(deptId);
    }




}

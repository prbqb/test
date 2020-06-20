package com.apl.inner.sys.service.impl;

import com.apl.inner.sys.mapper.DeptMapper;
import com.apl.inner.sys.pojo.DeptPo;
import com.apl.inner.sys.service.DeptService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 *  service实现类
 * </p>
 *
 * @author cy
 * @since 2020-06-20
 */
@Service
@Slf4j
public class DeptServiceImpl extends ServiceImpl<DeptMapper, DeptPo> implements DeptService {
    @Override
    public DeptPo getDeptById(Long deptId) {

        return baseMapper.getDeptById(deptId);
    }

//状态code枚举
/*enum DeptServiceCode {

        ;

        private String code;
        private String msg;

        DeptServiceCode(String code, String msg) {
             this.code = code;
             this.msg = msg;
        }
    }*/


        }
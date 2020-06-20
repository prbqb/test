package com.apl.inner.sys.service;


import com.apl.inner.sys.pojo.DeptPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * service接口
 * </p>
 *
 * @author cy
 * @since 2020-06-20
 */
public interface DeptService extends IService<DeptPo> {

    DeptPo getDeptById(Long deptId);

}
package com.apl.inner.sys.mapper;

import com.apl.inner.sys.pojo.DeptPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper extends BaseMapper<DeptPo> {

    DeptPo getDeptById(@Param("deptId") Long deptId);
}

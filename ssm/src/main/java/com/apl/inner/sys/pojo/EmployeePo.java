package com.apl.inner.sys.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *  持久化对象
 * </p>
 *
 * @author cy
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("employee")
public class EmployeePo{


    @TableId(value = "id", type = IdType.UUID)
    private Integer id;

    private String deptName;

    private Integer age;

    private Integer deptId;

    private static final long serialVersionUID=1L;


}

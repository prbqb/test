package com.apl.inner.sys.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

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
@TableName("dept")
public class DeptPo extends Model<DeptPo> {


    @TableId(value = "id", type = IdType.UUID)
    private Integer id;

    private String deptName;


    private List<EmployeePo> employeePos;

    private static final long serialVersionUID=1L;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

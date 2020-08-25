package com.bloom.bloom.com.bloom.guava;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import static com.baomidou.mybatisplus.annotation.IdType.ID_WORKER;

/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/8/23
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/8/23              lishanglei      v1.0.0           Created
 */
@TableName("t_student")
public class Student {

    @TableId(type = ID_WORKER)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("mark")
    private String mark;

    @TableField("age")
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

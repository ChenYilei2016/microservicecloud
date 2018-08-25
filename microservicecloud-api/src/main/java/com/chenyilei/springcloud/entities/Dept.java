package com.chenyilei.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//要实现序列化
@AllArgsConstructor
@NoArgsConstructor
@Data //相当于 @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode的合集
@Accessors(chain = true) ///链式调用 返回this
public class Dept implements Serializable { //orm MySql
    private Long deptno;

    private String dname;

    private String db_source; //哪个数据库

    public Dept(Long deptno, String dname) {
        this.deptno = deptno;
        this.dname = dname;
    }

    public Dept(String dname) {
        this.dname = dname;
    }


}

package com.cy.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests
{
    //自动装配数据库
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads()
    {

    }


    /**
     * 数据库连接池：
     * 1.DBCP
     * 2.C3P0
     * 3.Hikari:号称世界上最快的连接池(springBoot内部自动整合)
     * HikariProxyConnection@1436347886 wrapping com.mysql.cj.jdbc.ConnectionImpl@18371d89
     * @throws SQLException
     */
    @Test
    void getConnection() throws SQLException
    {
        System.out.println(dataSource.getConnection());
    }

}

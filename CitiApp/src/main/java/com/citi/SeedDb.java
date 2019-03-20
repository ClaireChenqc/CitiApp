package com.citi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SeedDb {

	@Autowired
	JdbcTemplate template;
	
	@Autowired
    public SeedDb(DataSource dataSource) {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into Item (description, price) values (?, ?)", new Object[]{"MacBook PRO", 2599.99});
        jdbcTemplate.update("insert into Item (description, price) values (?, ?)", new Object[]{"Ipad Air", 599.99});
        jdbcTemplate.update("insert into Item (description, price) values (?, ?)", new Object[]{"Iphone", 800.50});
        jdbcTemplate.update("insert into Item (description, price) values (?, ?)", new Object[]{"Apple Watch", 1000.99});
        jdbcTemplate.update("insert into Item (description, price) values (?, ?)", new Object[]{"OLED 64in TV", 1599.99});
        jdbcTemplate.update("insert into Item (description, price) values (?, ?)", new Object[]{"Wireless Mouse", 19.99});
        jdbcTemplate.update("insert into Item (description, price) values (?, ?)", new Object[]{"Virtual Reality HeadSet", 299.99});
    }
}

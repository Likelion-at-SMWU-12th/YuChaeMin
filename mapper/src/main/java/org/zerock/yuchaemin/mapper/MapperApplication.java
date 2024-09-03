package org.zerock.yuchaemin.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.zerock.yuchaemin.mapper.post")
public class MapperApplication {
	public static void main(String[] args) {
		SpringApplication.run(MapperApplication.class, args);
	}

}

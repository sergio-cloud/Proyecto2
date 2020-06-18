package com.example.proyecto2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.proyecto2.restcontroller.UserRestController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Demo3ApplicationTests {
	
	@Autowired
	private UserRestController restcontroller;

	 @Test
	    public void contexLoads() throws Exception {
	        assertThat(restcontroller).isNotNull();

}
}
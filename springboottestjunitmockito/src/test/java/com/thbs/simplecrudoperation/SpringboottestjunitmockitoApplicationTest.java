package com.thbs.simplecrudoperation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class SpringboottestjunitmockitoApplicationTest {

	@InjectMocks
	public SpringboottestjunitmockitoApplication sapp;
	
	@Test
	void testMainMethod() {
		
		String[] str= {"kiran","patil"};
		sapp.main(str);
	}

}

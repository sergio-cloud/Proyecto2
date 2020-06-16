package com.example.proyecto2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.proyecto2.DAO.PerfilDAOImp;
import com.example.proyecto2.service.PerfilServiceImp;

/*
 * @author Nino 
 * @version 09/06/2020 
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Demo2ApplicationTests {

		@Autowired
		PerfilServiceImp PerfilServiceImp;
		@Autowired
		PerfilDAOImp PerfilDaoImp;
		
		@Test
		public void ExistePerfilServiceImp() {
			//CONTROLA QUE EL PerfilServiceImp EXISTA
	    	
	    	assertThat(PerfilServiceImp).isNotNull();
		}
		
		@Test
		public void ExistePerfilDAOImp() {
			//CONTROLA QUE EL PerfilDAOImp EXISTA
	    	
	    	assertThat(PerfilServiceImp).isNotNull();
		}
		
	}


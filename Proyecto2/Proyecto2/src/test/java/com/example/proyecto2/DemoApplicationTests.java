package com.example.proyecto2;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.proyecto2.model.Perfil;
import com.example.proyecto2.service.PerfilService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PerfilService PerfilService;
	
	/*@Test
	void contextLoads() throws Exception{
		List<Perfil> aux=PerfilService.findAll();
		PerfilService.addPerfilFalso();
		assertThat(aux.size()+1==PerfilService.findAll().size()).isTrue();
	}*/

	@Test
	void eliminar() throws Exception{
		List<Perfil> aux=PerfilService.findAll();
		PerfilService.delete("Laverne Bednar37");
		assertThat(aux.size()==PerfilService.findAll().size()+1).isTrue();
	}
}

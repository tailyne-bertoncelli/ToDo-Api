package com.example.ToDo;

import com.example.ToDo.dto.PessoaDTO;
import com.example.ToDo.entity.Pessoa;
import com.example.ToDo.repository.PessoaRepository;
import com.example.ToDo.service.PessoaService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ToDoApplicationTests {

	@MockBean
	private PessoaRepository pessoaRepository;
	@Autowired
	private final PessoaService pessoaService = new PessoaService();

	@BeforeEach
	void obj(){
		Optional<Pessoa> pessoa = Optional.of(new Pessoa( 1L, "Tailyne", "tailyne@tr1.com.br"));
		Long id = 1L;
		Mockito.when(pessoaRepository.findById(id)).thenReturn(pessoa);

		List<Pessoa> pessoaList = new ArrayList<>();
		pessoaList.add(new Pessoa(1L, "Maria", "maria@gmail.com"));
		pessoaList.add(new Pessoa(2L, "Alana", "alana@gmail.com"));
		pessoaList.add(new Pessoa(3L, "João", "joao@gmail.com"));
		Mockito.when(pessoaRepository.findAll()).thenReturn(pessoaList);

	}

	@BeforeEach
	void pessoaDto(){
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Tailyne");
		pessoa.setEmail("tailyne@tr1.com.br");

		Mockito.when(pessoaRepository.save(pessoa)).thenReturn(pessoa);
	}

	@Test
	void testFindById () {
		var pessoa = pessoaService.findById(1L);
		Long id = pessoa.getId().longValue();
		Assert.assertEquals(1L, id, 0);
	}

	@Test
	void testInsert(){
		PessoaDTO pessoaDTO = new PessoaDTO(1L, "Tailyne", "tailyne@gmail.com");
		var pessoa = pessoaService.cadastra(pessoaDTO);
		Assert.assertEquals(pessoaDTO, pessoa);
	}

	@Test
	void testUpdate(){
		Pessoa pessoa = new Pessoa(1L, "Tailyne", "tailyne@tr1.com.br");
		PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
		var pessoaAlterada = pessoaService.alterar(pessoa);
		Assert.assertEquals(pessoaDTO.getNome(), pessoaAlterada.getNome());
	}

	@Test
	void testDeleta(){
		Pessoa pessoa = new Pessoa(1L, "Tailyne", "tailyne@tr1.com.br");
		var metodo = pessoaService.deleta(pessoa);
		Assert.assertEquals("Pessoa deletada com sucesso!", metodo);
	}



}

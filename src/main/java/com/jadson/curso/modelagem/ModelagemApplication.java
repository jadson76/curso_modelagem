package com.jadson.curso.modelagem;

import com.jadson.curso.modelagem.domain.*;
import com.jadson.curso.modelagem.domain.enums.TipoCliente;
import com.jadson.curso.modelagem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ModelagemApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ModelagemApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null,"Computador",1000.00);
		Produto p2 = new Produto(null,"Impressora",400.00);
		Produto p3 = new Produto(null, "Mouse", 50.00);

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		Cliente cli1 = new Cliente(null, "Rafael Mendes","rafael@gmail.com","07407411201",TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("2233-4422","98120-2545"));

		Endereco e1 = new Endereco(null,"rua flores","100","casa 4","Uberlandia","25220111",cli1,c1);
		Endereco e2 = new Endereco(null,"Avenida Mattos","13","apt 420","Centro","50212540",cli1,c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));


		Cliente cli2 = new Cliente(null, "Maria Mendes","maria@gmail.com","07407411201",TipoCliente.PESSOA_FISICA);
		cli2.getTelefones().addAll(Arrays.asList("2233-4422","98425-2541"));

		Endereco e3 = new Endereco(null,"Rua das Acacias","10","apt 101","Maria Madelana","50212540",cli2,c2);
		cli2.getEnderecos().addAll(Arrays.asList(e3));


		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3));

	}
}

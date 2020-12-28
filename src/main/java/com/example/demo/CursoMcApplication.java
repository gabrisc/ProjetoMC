package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Endereco;
import com.example.demo.domain.Estado;
import com.example.demo.domain.ItemPedido;
import com.example.demo.domain.Pagamento;
import com.example.demo.domain.PagamentoComBoleto;
import com.example.demo.domain.PagamentoComCartao;
import com.example.demo.domain.Pedido;
import com.example.demo.domain.Produto;
import com.example.demo.domain.enums.EstadoPagamento;
import com.example.demo.repositores.CategoriaRepository;
import com.example.demo.repositores.CidadeRepository;
import com.example.demo.repositores.ClienteRepository;
import com.example.demo.repositores.EnderecoRepository;
import com.example.demo.repositores.EstadoRepository;
import com.example.demo.repositores.ItemPedidoRepository;
import com.example.demo.repositores.PagamentoRepository;
import com.example.demo.repositores.PedidoRepository;
import com.example.demo.repositores.ProdutoRepository;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		Instant inst = Instant.now(); 
		
		Categoria cat1 = new Categoria(null,"informatica");
		Categoria cat2 = new Categoria(null,"escritorio");
		
		Produto p1=new Produto(null,"computador",2000.0);		
		Produto p2=new Produto(null,"impressora",800.0);
		Produto p3=new Produto(null,"mouse",80.0);	

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null,"Minas");
		Estado est2= new Estado(null,"são paulo");
		
		Cidade cid1 = new Cidade(null,"uberlandia",est1);
		Cidade cid2 = new Cidade(null,"Campinas",est2);
		Cidade cid3 = new Cidade(null,"São paulo",est2);
		
		Cliente cliente1= new Cliente(null,"Maria Silva","maria@gmail.com","363735412258445655",100);
		
		Endereco end1 = new Endereco(null,"rua flores", "300","aptp 203" ,"jardim","3822034",cid1,cliente1); 
		Endereco end2 = new Endereco(null,"Avenida matos","105","sala 800", "Centro","38777012",cid3,cliente1);
		
		
		Pedido pedido1 =new Pedido(null,Date.from(inst).toString(),cliente1,end1);
		Pedido pedido2 =new Pedido(null,Date.from(inst).toString(),cliente1,end2);
		Instant inst2 =Instant.parse("10/12/2021");
		
		
		ItemPedido itemPedido1 = new ItemPedido(pedido1,p1,0.0,1,0.0);
		ItemPedido itemPedido2 = new ItemPedido(pedido2,p1,1.4,1,2.0);
		ItemPedido itemPedido3 = new ItemPedido(pedido2,p1,2.0,1,3.0);
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
		
	}
	
}

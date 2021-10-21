import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;


public class PizzariaView extends JFrame {
	
	private JPanel painelTitulo,painelPedidos,painelBotoes;
	private JLabel titulo,logo,labSabor,labTamanho,labExtras,pedidoImg,labPedidos;
	private JLabel labDetalhes, saborEscolhido,tamanhoEscolhido,extrasEscolhidos;
	private JLabel pricePizza,priceTotal,descTotal;
	private JList<String> extras;
	private DefaultListModel<String> model = new DefaultListModel<>();
	private ImageIcon img,imgPedido;
	private JRadioButton saborPepperoni,saborMussarela,saborSupreme;
	private JRadioButton tIndividual,tRegular,tFamilia;
	private ButtonGroup saborPizza,tamanhos;
	private JCheckBox bacon, cebola, champignon,tomate,catupiry,presunto;
	private JButton btConfirmar, btLimparPedidos;
	private JTextArea pedidos;
	private ArrayList<String> listaPedidos =  new ArrayList<>();
	
	public PizzariaView() {
		
		this.setTitle("Pizzaria");
		this.setSize(740,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(255, 191, 0));
		painelTitulo.setSize(740,50);
		painelTitulo.setLayout(null);
		
		painelPedidos = new JPanel();
		painelPedidos.setBackground(new Color(255, 234, 150));
		painelPedidos.setBounds(0,50,740,350);
		painelPedidos.setLayout(null);
		
		painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(255, 118, 13));
		painelBotoes.setBounds(0, 400, 740, 100);
		painelBotoes.setLayout(null);
		
		this.add(painelTitulo);
		this.add(painelPedidos);
		this.add(painelBotoes);
		
		//Painel titulo;
		img = new ImageIcon(getClass().getResource("/images/pizza.png"));
		logo = new JLabel();
		logo.setBounds(50,0,50,50);
		logo.setIcon(img);
		painelTitulo.add(logo);
		
		titulo = new JLabel("Pizzaria Pixel");
		titulo.setFont(new Font("Verdana",Font.ITALIC,24));
		titulo.setForeground(Color.WHITE);
		titulo.setBounds(140,8,300,36);
		painelTitulo.add(titulo);
		
		//Painel Pedidos
		labSabor = new JLabel("Selecione um sabor: ");
		labSabor.setFont(new Font("Verdana",Font.BOLD,12));
		labSabor.setForeground(new Color(255, 118, 13));
		labSabor.setBounds(50,20,150,12);
		painelPedidos.add(labSabor);
		
		saborPepperoni = new JRadioButton("Pepperoni");
		saborPepperoni.setActionCommand("saborPepperoni");
		saborPepperoni.setBackground(new Color(255, 234, 150));
		saborPepperoni.setFont(new Font("Verdana",Font.BOLD,12));
		saborPepperoni.setForeground(new Color(255, 118, 13));
		saborPepperoni.setBounds(50,40,100,12);
		painelPedidos.add(saborPepperoni);
		
		saborMussarela = new JRadioButton("Mussarela");
		saborMussarela.setActionCommand("saborMussarela");
		saborMussarela.setBackground(new Color(255, 234, 150));
		saborMussarela.setFont(new Font("Verdana",Font.BOLD,12));
		saborMussarela.setForeground(new Color(255, 118, 13));
		saborMussarela.setBounds(50,60,100,12);
		painelPedidos.add(saborMussarela);
		
		saborSupreme = new JRadioButton("Supreme");
		saborSupreme.setActionCommand("saborSupreme");
		saborSupreme.setBackground(new Color(255, 234, 150));
		saborSupreme.setFont(new Font("Verdana",Font.BOLD,12));
		saborSupreme.setForeground(new Color(255, 118, 13));
		saborSupreme.setBounds(50,80,100,12);
		painelPedidos.add(saborSupreme);
		
		saborPizza = new ButtonGroup();
		saborPizza.add(saborPepperoni);
		saborPizza.add(saborMussarela);
		saborPizza.add(saborSupreme);
		
		labTamanho = new JLabel("Selecione o tamanho: ");
		labTamanho.setFont(new Font("Verdana",Font.BOLD,12));
		labTamanho.setForeground(new Color(255, 118, 13));
		labTamanho.setBounds(50,110,150,12);
		painelPedidos.add(labTamanho);
		
		tIndividual = new JRadioButton("Individual");
		tIndividual.setActionCommand("individual");
		tIndividual.setBackground(new Color(255, 234, 150));
		tIndividual.setFont(new Font("Verdana",Font.BOLD,12));
		tIndividual.setForeground(new Color(255, 118, 13));
		tIndividual.setBounds(50,130,100,12);
		painelPedidos.add(tIndividual);
		
		tRegular = new JRadioButton("Regular");
		tRegular.setActionCommand("regular");
		tRegular.setBackground(new Color(255, 234, 150));
		tRegular.setFont(new Font("Verdana",Font.BOLD,12));
		tRegular.setForeground(new Color(255, 118, 13));
		tRegular.setBounds(50,150,100,12);
		painelPedidos.add(tRegular);
		
		tFamilia = new JRadioButton("Família");
		tFamilia.setActionCommand("familia");
		tFamilia.setBackground(new Color(255, 234, 150));
		tFamilia.setFont(new Font("Verdana",Font.BOLD,12));
		tFamilia.setForeground(new Color(255, 118, 13));
		tFamilia.setBounds(50,170,100,12);
		painelPedidos.add(tFamilia);
		
		tamanhos = new ButtonGroup();
		tamanhos.add(tIndividual);
		tamanhos.add(tRegular);
		tamanhos.add(tFamilia);
		
		labExtras = new JLabel("Cobertura extras: ");
		labExtras.setFont(new Font("Verdana",Font.BOLD,12));
		labExtras.setForeground(new Color(255, 118, 13));
		labExtras.setBounds(50,200,150,12);
		painelPedidos.add(labExtras);
		
		bacon = new JCheckBox("Bacon            R$2,00");
		bacon.setActionCommand("bacon");
		bacon.setFont(new Font("Verdana",Font.BOLD,12));
		bacon.setForeground(new Color(255, 118, 13));
		bacon.setBackground(new Color(255, 234, 150));
		bacon.setBounds(50,220,180,12);
		painelPedidos.add(bacon);
		
		cebola = new JCheckBox("Cebola           R$1,50");
		cebola.setActionCommand("cebola");
		cebola.setFont(new Font("Verdana",Font.BOLD,12));
		cebola.setForeground(new Color(255, 118, 13));
		cebola.setBackground(new Color(255, 234, 150));
		cebola.setBounds(50,240,180,12);
		painelPedidos.add(cebola);
		
		champignon = new JCheckBox("Champignon  R$2,50");
		champignon.setActionCommand("champignon");
		champignon.setFont(new Font("Verdana",Font.BOLD,12));
		champignon.setForeground(new Color(255, 118, 13));
		champignon.setBackground(new Color(255, 234, 150));
		champignon.setBounds(50,260,180,12);
		painelPedidos.add(champignon);
		
		tomate = new JCheckBox("Tomate          R$1,00");
		tomate.setActionCommand("tomate");
		tomate.setFont(new Font("Verdana",Font.BOLD,12));
		tomate.setForeground(new Color(255, 118, 13));
		tomate.setBackground(new Color(255, 234, 150));
		tomate.setBounds(50,280,180,12);
		painelPedidos.add(tomate);
		
		catupiry = new JCheckBox("Catupiry        R$3,00");
		catupiry.setActionCommand("catupiry");
		catupiry.setFont(new Font("Verdana",Font.BOLD,12));
		catupiry.setForeground(new Color(255, 118, 13));
		catupiry.setBackground(new Color(255, 234, 150));
		catupiry.setBounds(50,300,180,12);
		painelPedidos.add(catupiry);
		
		
		presunto = new JCheckBox("Presunto       R$2,50");
		presunto.setActionCommand("presunto");
		presunto.setFont(new Font("Verdana",Font.BOLD,12));
		presunto.setForeground(new Color(255, 118, 13));
		presunto.setBackground(new Color(255, 234, 150));
		presunto.setBounds(50,320,180,12);
		painelPedidos.add(presunto);
		
		
		//Painel Pedidos - segunda coluna
		labDetalhes = new JLabel("Detalhes do pedido: ");
		labDetalhes.setFont(new Font("Verdana",Font.BOLD,12));
		labDetalhes.setForeground(new Color(255, 118, 13));
		labDetalhes.setBounds(250,20,150,12);
		painelPedidos.add(labDetalhes);
		
		
		saborEscolhido = new JLabel("Sabor: ");
		saborEscolhido.setFont(new Font("Verdana",Font.BOLD,12));
		saborEscolhido.setForeground(new Color(255, 118, 13));
		saborEscolhido.setBounds(250,40,150,12);
		painelPedidos.add(saborEscolhido);
		
		
		tamanhoEscolhido = new JLabel("Tamanho: ");
		tamanhoEscolhido.setFont(new Font("Verdana",Font.BOLD,12));
		tamanhoEscolhido.setForeground(new Color(255, 118, 13));
		tamanhoEscolhido.setBounds(250,60,150,12);
		painelPedidos.add(tamanhoEscolhido);
		
		pricePizza = new JLabel("Valor da pizza: R$0,00");
		pricePizza.setFont(new Font("Verdana",Font.BOLD,12));
		pricePizza.setForeground(new Color(255, 118, 13));
		pricePizza.setBounds(250,80,200,12);
		painelPedidos.add(pricePizza);
		
		//Painel Pedidos - Extras
		extrasEscolhidos = new JLabel("Extras: ");
		extrasEscolhidos.setFont(new Font("Verdana",Font.BOLD,12));
		extrasEscolhidos.setForeground(new Color(255, 118, 13));
		extrasEscolhidos.setBounds(250,100,150,12);
		painelPedidos.add(extrasEscolhidos);
		
		extras = new JList<>(model);
		extras.setBounds(250,120,210,150);
		extras.setFont(new Font("Verdana",Font.BOLD,12));
		extras.setForeground(new Color(255, 118, 13));
		extras.setBackground(new Color(255, 234, 150));
		painelPedidos.add(extras);
		
		descTotal = new JLabel("Preço total: ");
		descTotal.setFont(new Font("Verdana",Font.BOLD,12));
		descTotal.setForeground(new Color(255, 118, 12));
		descTotal.setBounds(250,305,150,12);
		painelPedidos.add(descTotal);
		
		priceTotal = new JLabel("R$0,00");
		priceTotal.setFont(new Font("Verdana",Font.BOLD,16));
		priceTotal.setForeground(new Color(255, 118, 16));
		priceTotal.setBounds(250,320,150,16);
		painelPedidos.add(priceTotal);
		
		
		//Painel Pedidos - Terceira coluna
		imgPedido = new ImageIcon(getClass().getResource("/images/forno.png"));
		pedidoImg = new JLabel();
		pedidoImg.setBounds(510, 0, 180,127);
		pedidoImg.setIcon(imgPedido);
		painelPedidos.add(pedidoImg);
		
		labPedidos = new JLabel("Pedidos: ");
		labPedidos.setFont(new Font("Verdana",Font.BOLD,12));
		labPedidos.setForeground(new Color(255, 118, 13));
		labPedidos.setBounds(480,126,150,12);
		painelPedidos.add(labPedidos);
		
		pedidos = new JTextArea();
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(pedidos);
		scroll.setBounds(480,140,230,200);
		pedidos.setBackground(new Color(255, 167, 99));
		pedidos.setFont(new Font("Verdana",Font.PLAIN,12));
		pedidos.setForeground(Color.WHITE);
		pedidos.setEditable(false);
		painelPedidos.add(scroll);
		
		//Painel Botoes
		btConfirmar = new JButton("Confirmar Pedido");
		btConfirmar.setActionCommand("confirmar");
		btConfirmar.setBounds(50, 10, 180, 40);
		painelBotoes.add(btConfirmar);
		
		btLimparPedidos = new JButton("Apagar Pedidos");
		btLimparPedidos.setActionCommand("limpar");
		btLimparPedidos.setBounds(480,10,220,40);
		painelBotoes.add(btLimparPedidos);
		
	}
	
	public void limpaCampos() {
		saborPizza.clearSelection();
		tamanhos.clearSelection();
		bacon.setSelected(false);
		cebola.setSelected(false);
		champignon.setSelected(false);
		tomate.setSelected(false);
		catupiry.setSelected(false);
		presunto.setSelected(false);
		
		saborEscolhido.setText("Sabor: ");
		tamanhoEscolhido.setText("Tamanho: ");
		pricePizza.setText("Valor da pizza: R$0,00");
	}
	
	public void setTextArea(String msg) {
		pedidos.setText(msg);
	}
	
	public void setTotal(double valor) {
		DecimalFormat df = new DecimalFormat("#0.00");
		priceTotal.setText("R$"+df.format(valor));
	}
	
	public void preencheLista(ArrayList<String> extra) {
		model.removeAllElements();
		
		for(int i=0;i<extra.size();i++) {
			model.addElement(extra.get(i));
		}
	}
	
	public boolean getBacon() {
		return bacon.isSelected();
	}
	
	public boolean getCebola() {
		return cebola.isSelected();
	}
	public boolean getChampignon() {
		return champignon.isSelected();
	}
	
	public boolean getTomate() {
		return tomate.isSelected();
	}
	
	public boolean getCatupiry() {
		return catupiry.isSelected();
	}

	public boolean getPresunto() {
		return presunto.isSelected();
	}
	
	public void setSaborPizza(String sabor) {
		this.saborEscolhido.setText("Sabor: "+sabor);
	}
	
	public void setTamanhoPizza(String tamanho) {
		this.tamanhoEscolhido.setText("Tamanho: "+tamanho);
	}
	
	public void setPrecoPizza(double valor) {
		DecimalFormat f = new DecimalFormat("#0.00");
		this.pricePizza.setText("Valor da pizza: R$"+f.format(valor));
	}
	
	public boolean isSelecionado() {
		boolean sabor, tamanho;
		sabor = saborPepperoni.isSelected()||saborMussarela.isSelected()||saborSupreme.isSelected();
		tamanho = tIndividual.isSelected()||tRegular.isSelected()||tFamilia.isSelected();
		
		return sabor&&tamanho;
	}
	
	public String getTamanhoSelected() {
		return tamanhos.getSelection().getActionCommand();
	}
	
	public String getSaborSelected() {
		return saborPizza.getSelection().getActionCommand();
	}
	
	public void addPedido(String pedido) {
		listaPedidos.add(pedido);
	}
	
	public String getPedidos(){
		String msg="";
		
		for(int i=0;i<listaPedidos.size();i++) {
			msg+="PEDIDO "+(i+1)+"\n";
			msg+=listaPedidos.get(i);
		}
		return msg;
	}
	
	public void limpaLista() {
		listaPedidos.clear();
		pedidos.setText("");
	}
	
	
	public void addPizzariaListener(ActionListener listenActions) {
		btConfirmar.addActionListener(listenActions);
		btLimparPedidos.addActionListener(listenActions);
		saborPepperoni.addActionListener(listenActions);
		saborMussarela.addActionListener(listenActions);
		saborSupreme.addActionListener(listenActions);
		tIndividual.addActionListener(listenActions);
		tRegular.addActionListener(listenActions);
		tFamilia.addActionListener(listenActions);
		
		//CheckBox
		bacon.addActionListener(listenActions);
		cebola.addActionListener(listenActions);
		champignon.addActionListener(listenActions);
		tomate.addActionListener(listenActions);
		catupiry.addActionListener(listenActions);
		presunto.addActionListener(listenActions);
		
	}
	
		
}

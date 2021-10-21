import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

public class PizzariaController {

	private PizzariaView pizzaView;
	private PizzariaModel pizzaModel;
	
	public PizzariaController(PizzariaView view, PizzariaModel model) {
		this.pizzaView = view;
		this.pizzaModel = model;
		
		this.pizzaView.addPizzariaListener(new PizzaListener());
	}
	
	class PizzaListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String op = e.getActionCommand();
			
			if(op=="confirmar") {
				if(pizzaView.isSelecionado()) {
					pizzaView.addPedido(pizzaModel.pedidoFinal());
					pizzaView.setTextArea(pizzaView.getPedidos());
					pizzaView.limpaCampos();
					pizzaModel.zerarDados();
					pizzaView.preencheLista(pizzaModel.getExtras());
				}else {
					JOptionPane.showMessageDialog(null, "Campos preenchidos incorretamente ou vazios");
				}
			}else if(op=="limpar") {
				pizzaView.limpaLista();
			}
			if(pizzaView.isSelecionado()) {
	
				pizzaModel.setValorItem(pizzaView.getSaborSelected(), pizzaView.getTamanhoSelected());
				pizzaView.setSaborPizza(pizzaModel.getSabor());
				pizzaView.setTamanhoPizza(pizzaModel.getTamanho());
				pizzaView.setPrecoPizza(pizzaModel.getPrecoPizza());
			} 
			
			if(op=="bacon") {
				if(pizzaView.getBacon()) {
					pizzaModel.addExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}else {
					pizzaModel.removeExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}
			}else if(op=="cebola") {
				if(pizzaView.getCebola()) {
					pizzaModel.addExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}else {
					pizzaModel.removeExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}
			}else if(op=="champignon") {
				if(pizzaView.getChampignon()) {
					pizzaModel.addExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}else {
					pizzaModel.removeExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}
			}else if(op=="tomate") {
				if(pizzaView.getTomate()) {
					pizzaModel.addExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}else {
					pizzaModel.removeExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}
			}else if(op=="catupiry") {
				if(pizzaView.getCatupiry()) {
					pizzaModel.addExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}else {
					pizzaModel.removeExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}
				
			}else if(op=="presunto") {
				if(pizzaView.getPresunto()) {
					pizzaModel.addExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}else {
					pizzaModel.removeExtra(op);
					pizzaView.preencheLista(pizzaModel.getExtras());
				}
			}
			pizzaView.setTotal(pizzaModel.getValorTotal());
		}
	}
	

}

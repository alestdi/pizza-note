import java.text.DecimalFormat;
import java.util.ArrayList;

public class PizzariaModel {
	
	private String sabor,tamanho;
	private double precoPizza=0;
	private ArrayList<Extras> extras = new ArrayList<>();
	
	public String getSabor() {
		return sabor;
	}
	
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public double getPrecoPizza() {
		return precoPizza;
	}
	
	public void setPrecoPizza(double preco) {
		this.precoPizza = preco;
	}
	
	public ArrayList<String> getExtras() {
		ArrayList<String> lista = new ArrayList<>();
		
		for(int i=0;i<extras.size();i++) {
			lista.add(extras.get(i).info());
		}
		
		return lista;
	}
	
	public void setValorItem(String sabor,String tamanho) {
		if(sabor=="saborPepperoni") {
			this.sabor ="Pepperoni";
			if(tamanho=="individual") {
				this.tamanho="Individual";
				this.precoPizza = 15 ;
			}else if(tamanho=="regular") {
				this.tamanho="Regular";
				this.precoPizza = 27;
			}else if(tamanho=="familia") {
				this.tamanho="Familia";
				this.precoPizza = 33;
			}
		}else if(sabor=="saborMussarela") {
			this.sabor ="Mussarela";
			if(tamanho=="individual") {
				this.tamanho="Individual";
				this.precoPizza = 12;
			}else if(tamanho=="regular") {
				this.tamanho="Regular";
				this.precoPizza = 21.60;
			}else if(tamanho=="familia") {
				this.tamanho="Familia";
				this.precoPizza = 26.40;
			}
		}else if(sabor=="saborSupreme") {
			this.sabor ="Supreme";
			if(tamanho=="individual") {
				this.tamanho="Individual";
				this.precoPizza = 17;
			}else if(tamanho=="regular") {
				this.tamanho="Regular";
				this.precoPizza = 30.60;
			}else if(tamanho=="familia") {
				this.tamanho="Familia";
				this.precoPizza = 37.40;
			}			
		}
	}
	
	public void addExtra(String extra) {
		
		if(extra=="bacon") {
			extras.add(new Extras("bacon",2));
		}else if(extra=="cebola") {
			extras.add(new Extras("cebola",1.5));
		}else if(extra=="champignon") {
			extras.add(new Extras("champignon",2.5));
		}else if(extra=="tomate") {
			extras.add(new Extras("tomate",1));
		}else if(extra=="catupiry") {
			extras.add(new Extras("catupiry",3));
		}else if(extra=="presunto") {
			extras.add(new Extras("presunto",2.5));
		}
	}
	
	public void removeExtra(String var) {
		
		for(int i=0;i<extras.size();i++) {
			if(var==extras.get(i).nome) {
				int indice = extras.indexOf(extras.get(i));
				extras.remove(indice);
			}
		}
		
	}
	
	public double getValorTotal() {
		double soma=0;
		soma+=precoPizza;
		for(int i=0;i<extras.size();i++) {
			soma+=extras.get(i).valor;
		}
		
		return soma;
	}
	
	public String pedidoFinal() {
		String msg = "";
		DecimalFormat df = new DecimalFormat("#0.00");
		
		msg+="Sabor: "+this.sabor+"\n";
		msg+="Tamanho: "+this.tamanho+"\n";
		msg+="Extras: \n";
		if(extras.size()==0) {
			msg+=" - Sem extras\n";
		}
		
		for(int i=0;i<extras.size();i++) {
			msg+=" "+extras.get(i).info()+"\n";
		}
		
		msg+="VALOR TOTAL: R$"+df.format(getValorTotal());
		msg+="\n----------------------------------\n";
		
		return msg;
	}
	
	public void zerarDados() {
		this.sabor="";
		this.tamanho="";
		this.precoPizza=0;
		this.extras.clear();
	}
	
	class Extras {
		
		String nome;
		double valor;
		
		Extras(String nome,double valor) {
			this.nome = nome;
			this.valor = valor;
		}
		
		public String info() {
			DecimalFormat df = new DecimalFormat("#0.##");
			return "- "+this.nome+"   R$"+df.format(this.valor);
		}
		
	}
	
	
}

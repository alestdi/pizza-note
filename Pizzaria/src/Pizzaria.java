public class Pizzaria {

	public static void main(String[] args) {
		PizzariaView view = new PizzariaView();
		PizzariaModel model = new PizzariaModel();
		PizzariaController controller = new PizzariaController(view,model);
		view.setVisible(true);

	}

}

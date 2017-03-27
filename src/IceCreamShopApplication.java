import javax.swing.JFrame;

public class IceCreamShopApplication {

	public static void main(String[] args) {
		JFrame iceCreamFrame = new JFrame();
		iceCreamFrame.setTitle("Xijie's ice cream shop");
		
		iceCreamFrame.setSize(800, 700);
		
		iceCreamFrame.add(new IceCreamShop());
		
		iceCreamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iceCreamFrame.setVisible(true);
	}
}

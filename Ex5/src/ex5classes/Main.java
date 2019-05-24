package ex5classes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;
import javax.swing.JFrame;


public class Main {
	private static final int FRAME_SIZE_vertical = 700;
	private static final int FRAME_SIZE_horizontal = 1200;
	/**
	 * @param args
	 * @throws Exception 
	 */
	//@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("Universe.txt"));
		if(!sc.hasNext()){
			throw new Exception();
		}
		int stars_num=sc.nextInt();
		double radus = sc.nextDouble();
		Galaxy jewels=new Galaxy(new Dimension(FRAME_SIZE_horizontal,FRAME_SIZE_vertical),radus,0.25);
		for (int i = 0; i < stars_num; i++) {
			double x=sc.nextDouble();
			double y=sc.nextDouble();
			double vx=sc.nextDouble();
			double vy=sc.nextDouble();
			double mass=sc.nextDouble();
			String image=sc.next();
			jewels.addplanet(new StarAndLocation(x,y,vx,vy,mass,image));
		}
		JFrame frame= new JFrame("unprecedented galaxy jewels");
		frame.add(jewels);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		boolean go = true;
		while(go){
    	jewels.movementStars();
    	jewels.repaint();
		}
	}

}

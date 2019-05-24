package ex5classes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Galaxy extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private double radus;
	private double deltaT;
	private ArrayList<StarAndLocation> stars;


	public Galaxy(Dimension size, double radus, double deltaT) {
		this.radus = radus;
		this.deltaT = deltaT;
		setPreferredSize(size);
		setLocation(100, 30);
		stars= new ArrayList<>();
	}

	public void addplanet(StarAndLocation p){
		stars.add(p);
	}

	public void movementStars(){
		for(int i = 0; i < stars.size(); i++){
			stars.get(i).Reset_momentum();
			for(int j = 0; j < stars.size(); j++){
				if(i!=j)
					stars.get(i).sum_of_momentum(stars.get(j));
			}
			stars.get(i).Starlocation(deltaT);
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(Color.black);
		for (int i=0 ;i< stars.size();i++){
			stars.get(i).print(g, radus);		
		}
	}

}

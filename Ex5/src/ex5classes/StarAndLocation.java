package ex5classes;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

public class StarAndLocation  {
	private static final double G = 6.67E-11;
	private double x;
	private double y;
	private double vx;
	private double vy;
	private final double mass;
	private BufferedImage image;
	private double ax;
	private double ay;


	public StarAndLocation(double x,double y,double vx,double vy,double mass,String image) throws IOException{
		this.x=x;
		this.y=y;
		this.vx=vx;
		this.vy=vy;
		this.mass=mass;
		this.ax=0;
		this.ay=0;
		try {
				this.image=ImageIO.read(new File(image));
				
			} catch (IOException e) {
				System.err.println("can't find the image "+image);
				System.exit(1);
			}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getVelocityX() {
		return vx;
	}

	public double getVelocityY() {
		return vy;
	}

	public double getMass() {
		return mass;
	}

	public BufferedImage getImg() {
		return image;
	}
	public void Reset_momentum(){
		this.ax = 0;
		this.ay = 0;
	}
	public void sum_of_momentum(StarAndLocation p)
	{
		double dx = p.getX()-this.x;
		double dy = p.getY()-this.y;
		double r = Math.sqrt((dx*dx)+(dy*dy));
		double fource =(G*this.mass*p.getMass())/(r*r);
		double fx = fource*(dx/r);
		double fy = fource*(dy/r);
		this.ax = this.ax +(fx/this.mass);
		this.ay = this.ay +(fy/this.mass);
	}
	public void print(Graphics g,double radus) {
		double h = g.getClipBounds().height;
		double w = g.getClipBounds().width;
		double pixelWorth = (radus*2)/h;
		int gx = (int)((w/2) + x/pixelWorth);
		int gy = (int) ((h / 2) + y/pixelWorth);
		g.drawImage(image,(int)((gx-image.getWidth()/2)),(int)(gy-image.getHeight()/2),null);
	}
	public void Starlocation(double deltaT){
		this.vx += (deltaT*ax);
		this.vy += (deltaT*ay);
		this.x = this.x + (deltaT*this.vx);
		this.y = this.y + (deltaT*this.vy);
	}
}

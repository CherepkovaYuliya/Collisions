package etu.chmi.collision.model;

public class Ball {
	
	private Double x0; 
	private Double y0; 
	private Double curX; 
	private Double curY;
	private final Double rad; 
	private Double v; 
	private Double angle;
	
	/**
     * Constructor
     */	
	public Ball(Double x0, Double y0, Double rad, Double v, Double angle) {
		this.x0 = new Double(x0);
		this.y0 = new Double(y0);
		this.curX = new Double(0.0);
		this.curY = new Double(0.0);
		this.rad = new Double(rad); 
		this.v = new Double(v);
		this.angle = new Double(angle);
	}

	public Double getCurX() {
		return curX;
	}

	public void setCurX(Double curX) {
		this.curX = curX;
	}

	public Double getCurY() {
		return curY;
	}

	public void setCurY(Double curY) {
		this.curY = curY;
	}

	public Double getV() {
		return v;
	}

	public void setV(Double v) {
		this.v = v;
	}

	public Double getAngle() {
		return angle;
	}

	public void setAngle(Double angle) {
		this.angle = angle;
	}

	public Double getRad() {
		return rad;
	}
	
	public Double getX0() {
		return x0;
	}

	public void setX0(Double x0) {
		this.x0 = x0;
	}

	public Double getY0() {
		return y0;
	}

	public void setY0(Double y0) {
		this.y0 = y0;
	}
		
}

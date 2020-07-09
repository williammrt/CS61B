import java.math.*;
public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;

	}
	public Planet(Planet p){
		xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;

	}
	public double calcDistance(Planet other){
		double xDiff=this.xxPos-other.xxPos;
		double yDiff=this.yyPos-other.yyPos;
		return Math.sqrt(xDiff*xDiff + yDiff*yDiff);

	}
	public double calcForceExertedBy(Planet other){
		double gravitationForce = 6.67e-11;
		return gravitationForce*this.mass*other.mass/(this.calcDistance(other)*this.calcDistance(other));
	}
	public double calcForceExertedByX(Planet other){
		double xDiff=other.xxPos-this.xxPos;
		return this.calcForceExertedBy(other)*xDiff/this.calcDistance(other);
	}
	public double calcForceExertedByY(Planet other){
		double yDiff=other.yyPos-this.yyPos;
		return this.calcForceExertedBy(other)*yDiff/this.calcDistance(other);


	}
	public double calcNetForceExertedByX(Planet others[]){
		double netForceX=0;
		for (Planet p :others){
			if (this.equals(p)){
				continue;
			}
			netForceX+= this.calcForceExertedByX(p);
		}
		return netForceX;

	}
	public double calcNetForceExertedByY(Planet others[]){
		double netForceY=0;
		for (Planet p :others){
			if (this.equals(p)){
				continue;
			}
			netForceY+= this.calcForceExertedByY(p);
		}
		return netForceY;
		
	}
	public void update(double dt, double fX, double fY){
		double aX= fX/this.mass;
		double aY= fY/this.mass;
		this.xxVel+= dt*aX;
		this.yyVel+= dt*aY;
		this.xxPos+= dt*this.xxVel;
		this.yyPos+= dt*this.yyVel;


	}
	public void draw(){
		StdDraw.picture(this.xxPos/2.50e+11*256,this.yyPos/2.50e+11*256,"images/"+imgFileName);
	}

}
public class NBody{
	public static double readRadius(String fileName){
		In in = new In(fileName);
		int numOfPlanet = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String fileName){
		In in = new In(fileName);
		int numOfPlanet = in.readInt();
		double radius = in.readDouble();
		Planet arrayPlanets[] = new Planet[numOfPlanet]; 
		double temp1,temp2,temp3,temp4,temp5;
		String temp6;

		for (int i=0;i<numOfPlanet;i++){
			
			temp1= in.readDouble();
			temp2= in.readDouble();
			temp3= in.readDouble();
			temp4= in.readDouble();
			temp5= in.readDouble();
			temp6= in.readString();
			arrayPlanets[i]=new Planet(temp1,temp2,temp3,temp4,temp5,temp6);

		}
		return arrayPlanets;
	}
	public static void main(String[] args) {
		double T= Double.parseDouble(args[0]);
		double dT= Double.parseDouble(args[1]);
		String filename= args[2];
		double radius=readRadius(filename);
		Planet[] arrayPlanets= readPlanets(filename);
		

		StdDraw.setScale(-256, 256);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for (Planet p: arrayPlanets){
			p.draw();
		}
		StdDraw.show();
		StdDraw.enableDoubleBuffering();
		double time =0;
		
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
   			 StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
             planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
             planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
	}
}
package seeingComputer;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class mapinfo {
	private Point mappnt=new Point(200,200);
	private GetImage imgcon;
	private Point shipPoint= new Point(getMappnt().x+120,getMappnt().y+80);
	private Rectangle mapsize;
	
	private int n;
	public Point petpnt;
	public mapinfo( GetImage i) {
		imgcon=i;
		
	}
	public boolean[] petnearShip1(int smradius,int bgradius){
		int searchsize=bgradius+10;
		Point shpnt = new Point(shipPoint.x-(searchsize),
				shipPoint.y-(searchsize));
		Point mspnt = new Point(shpnt.x+searchsize*2
				,shpnt.y+searchsize*2);
	int mx = 0;
	if(mspnt.x>imgcon.scwidth){
		mx=mspnt.x-imgcon.scwidth;
	}
		BufferedImage shimg = imgcon.screanImage(shpnt.x,
				shpnt.y, searchsize-mx, searchsize-mx);
		boolean[] petlogic={false,false,false,false};
		for (int y =0;y<shimg.getHeight(); y++){
			for (int x =0;x<shimg.getWidth(); x++){
				if(imgcon.pointEcolor(shimg, x, y, 204, 129, 0)){
					petlogic[2]=true;
					petpnt=new Point(shpnt.x+x,shpnt.y+y);
					int spnt = imgcon.findHipotinus(petpnt,shipPoint);
					if(spnt<4){
						petlogic[3]=true;
					}
					if(spnt<smradius&&spnt>4){
						petpnt=new Point((shpnt.x+x)-mappnt.x,(shpnt.y+y)-mappnt.y);
						petlogic[0]=true;
					}
					if(spnt>bgradius){
						petpnt=new Point((shpnt.x+x)-mappnt.x,(shpnt.y+y)-mappnt.y);
						petlogic[1]=true;
					}
				}
			}	
		}
		if(!petlogic[2]){
			petlogic[1]=false;
		}
		return petlogic;
	}
	
	public boolean petnearShip(int width, int hight){
		BufferedImage shimg = imgcon.screanImage(shipPoint.x-(width),
				shipPoint.y-(hight)
				, width*2, hight*2);
		for (int y =0;y<shimg.getHeight(); y++){
			for (int x =0;x<shimg.getWidth(); x++){
				if(imgcon.pointEcolor(shimg, x, y, 204, 129, 0)){
					
					return true;
				}
			}	
		}
		return false;
	}
	public boolean moving(){
		Point mpnt1 = new Point(mappnt.x+96,mappnt.y-10);
		
		return imgcon.pointEcolor(mpnt1, 255,255,255);
		
	}
	public Point findShip() {
		int yLocation = getMappnt().y+18;
		int xLocation = getMappnt().x+120;
	
		BufferedImage mapImage;
		Point searchPoint = new Point(getMappnt().x+10,getMappnt().y+10);
			mapImage=imgcon.screanImage(searchPoint, 360, 221);
			for (int i =0;i<mapImage.getWidth(); i++){
				if(imgcon.pointsevinty(mapImage,i,0)&&
						imgcon.pointsevinty(mapImage,i,100)||
						imgcon.pointsevinty(mapImage,i,4)&&
						imgcon.pointsevinty(mapImage,i,110)){
				xLocation=searchPoint.x+i;
				//System.out.println(i+10);
				break;
				}
			}
			for(int i =0;i<mapImage.getHeight();i++){
				if(imgcon.pointsevinty(mapImage,200,i)){
					yLocation=searchPoint.y+i;
					//System.out.println(i+10);
					break;
				}
			}
			
			shipPoint=new Point(xLocation,yLocation);
			
			return shipPoint;
	}
	
	public Point[] findgates(){
		Point[] gatepnt =new Point[8];
		
		Point searchPoint = new Point(mappnt.x+10,mappnt.y+10);
		BufferedImage mapImage;
			mapImage=imgcon.screanImage(searchPoint, 360, 221);
			
			for (int y =0;y<mapImage.getHeight()-4; y++){
				//System.out.println(y);
			for (int x =0;x<mapImage.getWidth()-4; x++){
				//System.out.println(x);
				if(imgcon.pointEcolor(mapImage,x,y, 204,204,204)){
					
				gatepnt[n]=new Point(x,y);
				System.out.println(gatepnt[n]);
				}
			}
			}
			
			
			
			return gatepnt;
	}
	
	public Point keapshipLock(){
		// this uses the old location to the ship to find where it moves
		// then if the cowardinants are not found the it trys to find the ship agan threw the hol map
		 boolean xlocat = false;
		 boolean ylocat = false;
		 int xLocation=0;
		 int yLocation=0;
		BufferedImage shipimg;
		Point lastLocation = new Point(shipPoint.x-35,shipPoint.y-35);
		//this.comcon.moveCursor(lastLocation);
		shipimg=imgcon.screanImage(lastLocation, 70, 70);
		
					for (int k = 0; k < shipimg.getWidth(); k++) {
						if(imgcon.pointsevinty(shipimg,k,68)){
							xLocation=lastLocation.x+k;
							xlocat=true;
							break;
						}
					if(imgcon.pointsevinty(shipimg,k,1)){
						xLocation=lastLocation.x+k;
						xlocat=true;
						break;
					}
					
					}
				
					for (int k = 0; k < shipimg.getHeight(); k++) {	
					if(imgcon.pointsevinty(shipimg,1,k)){
						yLocation=lastLocation.y+k;
						ylocat=true;
						break;
					}
					}
		if(!xlocat||!ylocat){
			findShip();
			
			return shipPoint;
		}else{
		shipPoint=new Point(xLocation,yLocation);
		
		return shipPoint;
		}
	}
	public Point getMappnt() {
		return mappnt;
	}
	public void setMappnt(Point mappnt) {
		this.mappnt = mappnt;
		setMapsize(new Rectangle(mappnt.x,mappnt.y,350,210));
	}
	public Rectangle getMapsize() {
		return mapsize;
	}
	public void setMapsize(Rectangle mapsize) {
		this.mapsize = mapsize;
	}

}

package workingFinder;

import java.util.Timer;
import java.util.TimerTask;

import seeingComputer.MainObjects;

public class colectingTimers {
	protected Timer timer= new Timer();
	private MainObjects mObjects=new MainObjects();
	private boolean st;
	private boolean fst=true;
public void colect(){
	mObjects.search();
	mObjects.cargo.cbox.mouse.moveCursor(mObjects.shipPet.mapPoint);
	mObjects.shipPet.moving();
	mObjects.cargo.findCargo1();
	st=!st;
	
	if(fst){
		fst=false;
	timer.scheduleAtFixedRate (
		
		    new TimerTask() {
				@Override
				public void run() {
					if(st){
					mObjects.cargo.findCargo();
					}
				}
		    }, 0, 1);
	}
}
public void colect2(){
	mObjects.search();
	mObjects.cargo.cbox.mouse.moveCursor(mObjects.shipPet.mapPoint);
	mObjects.shipPet.moving();
	mObjects.cargo.findCargo1();
	st=!st;
	while(st){
		mObjects.cargo.findCargo();
	}
	
}
public void colectT(){
	mObjects.search();
	//Point shippnt = mObjects.shipPet.findShip();
	//cbox.rightclick(new Point(shippnt.x+5,shippnt.y));
	mObjects.cargo.findCargo1();
	
}
}

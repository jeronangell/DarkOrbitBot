package takeAction;

import java.awt.Point;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cargoSight.bonesBoxsearch;
=======
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import cargoSight.bonesBoxsearch;
import cargoSight.boxes;
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
import seeingComputer.StaticInfo;

public class Timers {
	private StaticInfo stc=new StaticInfo();
	protected Timer timer= new Timer();
	private boolean begin=true;
	private CursorControl robUI = new CursorControl(stc);
	private NormalColect colect = new NormalColect(robUI,stc);
<<<<<<< HEAD
	public bonesBoxsearch bonesBox = new bonesBoxsearch();
	public RunFromeEnimy runf=
			new RunFromeEnimy(robUI,stc.map,stc.flylocate);
	private boolean colecting;
	private int lht;
	private boolean petshotat;
	private boolean on1_1;
	private boolean runing;
	private Point shipPoint;
	private boolean bclick=false;
	private boolean shipHit;
	private boolean run;
	private Point mapPnt;
	private Travel travel=new Travel(stc.flylocate,runf);
	public void startSeeing(){
		stc.search();
		shipPoint=stc.map.keapshipLock();
		colect.colect(shipPoint);
		colect.stmove();
		mapPnt=stc.map.getMappnt();
		runf.setMapPnt(mapPnt);
		travel.seeAthome();
		System.out.println(travel.onHomescreen);
		if(begin){
			//stc.petSt.petColecting();
		timer.scheduleAtFixedRate (
			    new TimerTask() {
					public void run() {
						if(!shipHit){
						travel.flytoPvp();
						
						}
						
						travel.seeAthome();
						if(travel.onHomescreen){
							run=false;
							runf.setRun(false);
						}
						
						if(!run&&!travel.traveling&&!travel.onHomescreen){
								System.out.println("trying to colect");
						colectingsetup();
						bonesBox.findBonesBox(5, 20);
						bonesBox.Cargoonship(1, 1);
						bclick=bonesBox.click;
						shipPoint=stc.map.keapshipLock();
						if(bclick){
=======
	public bonesBoxsearch bonesBox = stc.bBColect;
	public boxes box= stc.bBColect2;
	public RunFromeEnimy runf=
			new RunFromeEnimy(robUI,stc.map,stc.flylocate);
	public JLabel lblShipHit = new JLabel("ship hit");
	public JLabel lblPetNotRepared = new JLabel("pet");
	public JLabel lblOnMap = new JLabel("on map #");
	public JLabel lblRedyToRun = new JLabel("redy to run=");
	public JLabel lblAbleToTravel = new JLabel("able to travel");
	private boolean colecting;
	private int lht=0;
	private boolean petneadReper=false;
	private Point shipPoint;
	private boolean bclick=false;
	private boolean shipHit;
	private boolean run=false;
	private Point mapPnt;
	private Travel travel=new Travel(stc.flylocate,runf);
	private boolean stop;
	public int searcharea=0;
	private int longwate=0;
	public JLabel lblWateTime;
	public boolean moving=false;
	public JLabel lblCt;
	public int psh=5;
	public int psw=7;
	private int nm=0;
	public void startSeeing(){
		stc.search();
		shipPoint=stc.map.keapshipLock();
		travel.timeserch=30;
		travel.seeAthome();
		mapPnt=stc.map.getMappnt();
		runf.setMapPnt(mapPnt);
		if(travel.onHomescreen){
			travel.traveling=true;
			System.out.println("moving to 4-1");
		}
		colect.colectst(shipPoint,searcharea);
		colect.stmove();
		stop=false;
		longwate=0;
		//System.out.println(stc.flylocate.on1_1());
		
		
		//begin=false;
		if(begin){
		timer.scheduleAtFixedRate (
			    new TimerTask() {
					private int longsit;
					
					public void run() {
						PrintStream pr = System.out;
						if(!stop){
						if(!shipHit&&!petneadReper){
						travel.flytoPvp();
						}
						moving=stc.map.moving();
						runf.movingc=moving;
						travel.seeAthome();
						stc.flylocate.moving=moving;
						if(travel.onHomescreen){
							if(run){
							runf.resetRuning();
							}
							run=false;
						}
						
						colectingsetup();
						
						if(redytoColect()){
							lblCt.setText("ct ="+bonesBox.getCt()+
									"cargoNotClose ="+bonesBox.getCargoNotClose()+"losit ="+longsit);
						boolean petnship = stc.map.petnearShip(psw,psh);
						//pr.println(psw);
						if(!petnship){
							//bonesBox
						bonesBox.cargo(moving,colect);
						bonesBox.Cargoonship(1, 1);
						}else{
							//3System.out.println("petfound");
							if(bonesBox.cargoFound){
							bonesBox.cargoFound=false;
							colect.hmove();
							}
							if(!moving){
								colect.hmove();
								nm=(0);
							}
						}
						bclick=bonesBox.click;
						shipPoint=stc.map.keapshipLock();
						robUI.keepToolActive(0);
						robUI.keepToolActive(7);
						if(moving){
							longsit=0;
						}else{
							if(longsit>3){
								colect.stmove();
								longsit=0;
							}
							longsit++;
						}
						if(bclick){
							longsit=0;
							longwate=0;
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
							robUI.rightclick(bonesBox.clickpoint);
							bonesBox.click=false;
						}
						colecting=true;
						}else{
							colecting=false;
							if(run){
<<<<<<< HEAD
							runf.setShipPoint(shipPoint);
							runf.run();
							}
							
						}
			        	}}, 0, 1);
		timer.scheduleAtFixedRate (
			    new TimerTask() {
					private int nm=0;
					private boolean petHit;
					public void run() {
						stc.petSt.petmoniter();
						if(!run&&!travel.traveling&&!travel.onHomescreen){
						if(!bonesBox.cargoFound){
							colect.colect(shipPoint);
							
						
					
							if(nm==5){
								colect.hmove();
=======
							runf.run4_1(shipPoint);
							}
							
						}
						}
			        	}}, 0, 1);
		timer.scheduleAtFixedRate (
			    new TimerTask() {
					
					public void run() {
						if(!stop){
						stc.petSt.petmoniter();
						if(redytoColect()){
						if(!bonesBox.cargoFound){
							colect.colect(shipPoint,searcharea);
							if(nm==5){
								if(!moving){
								colect.hmove();
								}
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
							}
							if(nm==14){
								colect.stmove();
							}
<<<<<<< HEAD
							if(nm!=20){
							nm++;
							}
						
=======
							if(moving){
							if(nm==180){
								colect.stmove();
							}
							if(nm==260){
								colect.stmove();
							}
							}
							nm++;
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
						}else{
							nm=0;
						}
						}
<<<<<<< HEAD
					}}, 0, 1);
		
			timer.scheduleAtFixedRate (
			new TimerTask() {
				private int tl;
				private int dn;
				
				

				public void run() {
					
					if(colecting){
					colect.startPet();
					colect.keepPetColoecting();
					}else{
						if(!petshotat){
						colect.stopPet();
						}
					}
					if(stc.shipstat.shipDead()){
						if(tl==4){
							robUI.rightclick(stc.shipstat.repbtn);
						}
						if(tl>100){
							tl=2;
						}
						if(tl==0){
							dn++;
							System.out.println("died "+dn+"time");
						}
						tl++;
					}else{
						tl=0;
					}
					 shipHit = stc.shipstat.shipHit();
					if(!travel.onHomescreen&&!travel.traveling){
					
					
					boolean petHit=stc.petSt.petLesSH;
					if(shipHit||petHit){
					runf.setRun(true);
					
					}
					shipPoint=stc.map.keapshipLock();
					//System.out.println(runf.isRun());
					run=runf.isRun();
			if(run){
				
				runf.setShipPoint(shipPoint);
			}
		        	}
				}
				}, 0, 1);
		begin=false;
		
		//shipPoint=stc.map.keapshipLock();
		
		
		
		
		}
		
	}
	private void colectingsetup(){
		shipPoint=stc.map.keapshipLock();
		if(on1_1){
			if(petshotat){
			colect.startPet();
			keepRepPet();
			}else{
			stopPet();
			}
		}else{
			if(runing){
			runAway();
			}else{
		colect.colect(shipPoint);
			}
=======
						}
					}}, 0, 1);
		
		timer.scheduleAtFixedRate (
			new TimerTask() {
				private int tl;
				private int rnum;
				private boolean resetwate;
				private void keepPetColect(){
					 if(runf.rnum==1){
						 resetwate=true;
					 }else{
						if(resetwate){
							longwate=0;
							resetwate=false;
						}
					 }
					 if(longwate>10000){
						 stop=true;
					 }
					 if(longwate==4000||longwate==6000
							 ||longwate==8000){
						 
						 stc.search();
						 colecting=true;
						 if(stc.mapf&&stc.petstf&&
								 stc.toolBarF&&stc.shipstf){
							mapPnt=stc.map.getMappnt();
							runf.setMapPnt(mapPnt);
							colect.stmove();
					 run=false;
						runf.resetRuning();
						 }else{
							 run=false;
							runf.resetRuning();
							 stop=true;
						 }
						 }
					
					 longwate++;
				}
				private void defenceP4_1(){
					 if(colecting){
							colect.startPet();
							colect.keepPetColoecting();
							}else{
								if(!travel.onHomescreen){
								colect.stopPet();
								}
							}
							if(stc.shipstat.shipDead()){
								
								if(tl==4){
									robUI.rightclick(stc.shipstat.repbtn);
									travel.onHomescreen=true;
								}
								if(tl>100){
									
									tl=2;
								}
								tl++;
							}else{
								tl=0;
							}
							shipHit = stc.shipstat.shipHit();
							if(!travel.onHomescreen){
								if(stc.toolbar.toolredy(9)&&runf.nothear){
							boolean petHit=stc.petSt.petLesSH;
							if(shipHit&&stc.shipstat.enimyonscreen()){
							run=true;
							colecting=false;
							}
							
							if(petHit){
								petneadReper=true;
								run=true;
								colecting=false;
							}
								}
							}
				}
				private void setlbls(){
					lblPetNotRepared.setText("pet need repared = "+petneadReper);
					 lblOnMap.setText("on home screen = "+travel.onHomescreen);
					 lblAbleToTravel.setText("able to travel = "+(!shipHit&&!petneadReper&&travel.onHomescreen));
					 lblRedyToRun.setText("redy to run = "+ run);
					 lblWateTime.setText("wate time= "+ longwate);
					
				}
				public void run() {
					lblShipHit.setText("ship hit = " +shipHit+" stop ="+ stop);
					if(!stop){
						//lblShipHit.setText("ship hit = " +shipHit);
						
						setlbls();
						 keepPetColect();
						 defenceP4_1();
					shipPoint=stc.map.keapshipLock();
					//System.out.println(runf.isRun());
		        	}
					}
				
				}, 0, 1);
		begin=false;
		//shipPoint=stc.map.keapshipLock();
		}
		
	}
	
	private void colectingsetup(){
		shipPoint=stc.map.keapshipLock();
		if(travel.onHomescreen){
			if(petneadReper){
			colect.startPet();
			keepRepPet();
			}else{
				colect.stopPet();
			}
			robUI.keepToolActive(6);
			robUI.keepToolActive(7);
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
		}
		
		
	}
<<<<<<< HEAD
	
	private void runAway() {
		
	}
	public void stopPet() {
		// TODO Auto-generated method stub
		stc.search();
		stc.map.findgates();
		
=======
	public void stopPet() {
		// TODO Auto-generated method stub
		stop=true;
		run=false;
		runf.resetRuning();
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
		
		/*if(stc.petSt.petup){
			if(n==1){
			robUI.rightclick(stc.petSt.petControlPoints[0]);
			}
			if(n>20){
				n=0;
			}
			System.out.println(n);
			n++;
		}*/
	}
<<<<<<< HEAD
	
	private void keepRepPet(){
		if(stc.petSt.petLesSH){
			petshotat=true;
			runing=true;
		}
		if(stc.petSt.petup&&stc.petSt.petLesHP){
			if(lht>7){
			if(lht==9){
				robUI.rightclick(stc.petSt.petControlPoints[1]);
				
=======
	private boolean redytoColect(){
		return !run&&!travel.traveling&&!travel.onHomescreen;
	}
	private void keepRepPet(){
		
		if(stc.petSt.petup&&stc.petSt.petLesHP&&stc.petSt.petLesSH){
			if(lht>7){
			if(lht==9){
				robUI.rightclick(stc.petSt.petControlPoints[1]);
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
				}
			if(lht>14){
				if(stc.petSt.dropdownShown()){
					robUI.rightclick(stc.petSt.petControlPoints[3]);
					
				}
				}
			if(lht>90){
				lht=6;
				}
				}
			lht++;
			}else{
<<<<<<< HEAD
			
			petshotat=false;
			runing=false;
			lht=0;
			}
=======
			if(stc.petSt.petup){
			petneadReper=false;
			lht=0;
			}
			}
>>>>>>> 50a73e1ff4a29e8fafe043d87a4b4f8904ae7201
		}
	
}

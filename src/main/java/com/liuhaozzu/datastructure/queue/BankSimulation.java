package com.liuhaozzu.datastructure.queue;
/**
 * 
 * TODO calculate the average time for each customer staying in the back
 * @author liuhaozzu
 * @date   Apr 6, 2018-11:09:48 PM
 *
 */

import java.util.Calendar;
import java.util.Date;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class BankSimulation {
	
	private long nextArrivalTime = System.currentTimeMillis();

	// TODO: 
	private long closeTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	
	public BankSimulation() {
		for(int i=0;i<eventQueues.length;i++) {
			eventQueues[i]=new LinkedBlockingQueue<>();
		}
	}
	public void customerArrived() {
		Event en = new Event(System.currentTimeMillis(),0);
		++customerNum;
		Random random = new Random();
		long duration = random.nextLong();
		long intertime = random.nextLong();
		nextArrivalTime = en.getOccurTime()+intertime;
		if(nextArrivalTime<closeTime ) {
			ev.add(en);
		}
		Queue<QElemType> minQueue=getMinQueue(eventQueues);
	}

	public void customerDeparture() {
		
	}
	
	private Queue<QElemType> getMinQueue(Queue<QElemType>[] eventQueues2) {
		// TODO Auto-generated method stub
		return null;
	}

	private Queue<QElemType>[] eventQueues= new LinkedBlockingQueue[4];
	private Queue<Event> ev= new LinkedBlockingQueue<>();
	private QElemType customer;
	private int totalTime;
	private int customerNum;
	private class Event{
		private long occurTime;
		private int Type;//0 means arriving, 1~4 means departure from different windows
		
		public Event(long occurTime, int type) {
			super();
			this.occurTime = occurTime;
			Type = type;
		}
		public long getOccurTime() {
			return occurTime;
		}
		public void setOccurTime(long occurTime) {
			this.occurTime = occurTime;
		}
		public int getType() {
			return Type;
		}
		public void setType(int type) {
			Type = type;
		}
		
	}
	private class QElemType{
		private long arrivalTime;
		private long duration;
		public long getArrivalTime() {
			return arrivalTime;
		}
		public void setArrivalTime(long arrivalTime) {
			this.arrivalTime = arrivalTime;
		}
		public long getDuration() {
			return duration;
		}
		public void setDuration(long duration) {
			this.duration = duration;
		}
	}
}

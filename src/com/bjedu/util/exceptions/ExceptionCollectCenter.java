package com.bjedu.util.exceptions;

import java.util.PriorityQueue;
import java.util.Queue;

public class ExceptionCollectCenter {
	private static Queue<ExceptionModel> queue = new PriorityQueue<ExceptionModel>(10);
	
	public static void add(ExceptionModel e){
		synchronized (queue) {
			fullscan(e);
			if(queue.size()==15){
				queue.remove();
			}
			queue.add(e);
		}
	}

	private static void fullscan(ExceptionModel e) {
//		Iterator<ExceptionModel> it = queue.iterator();
//		while(it.hasNext()){
//			Exception ex = it.next().getE();
//			if(e.getE().getMessage().equals(ex.getMessage())){
//				queue.remove(ex);
//			}
//		}
	}

	public static Queue<ExceptionModel> getQueue() {
		return queue;
	}
	
	public static void remove(){
		queue.removeAll(queue);
	}
}

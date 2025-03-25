package com.base;

public class Utilities extends BaseClass{
     protected void sleeps(long millsec) {
    	 try {
    		 Thread.sleep(millsec);
    	 }
    	 catch(InterruptedException e){
    		 e.printStackTrace();
    	 }
     }
}

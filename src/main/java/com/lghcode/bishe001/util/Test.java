package com.lghcode.bishe001.util;

public class Test {
	public static void main(String[] args) throws Exception {
		
		for(int i= 0;i<1000;i++) {
			String l = Utils.getL();
			String[] split = l.split("[|]");
			String string = split[6].substring(0, 4);
			int parseInt = Integer.parseInt(string,16);
			System.out.println("光照强度 :"+parseInt);
			if(parseInt<150) {
				BoxUtils.sendMssage(DateUtils.showOpenParlourLight("0004"));
			}if(parseInt>200) {
				BoxUtils.sendMssage(DateUtils.showOpenParlourLight("0005"));
			}
			Thread.sleep(1000);
		}
	}
}

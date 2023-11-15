package com.baxxy.springboot.app.utils.paginator;

public class PageItem {
	private int numberPage;
	private boolean currentP;
	public PageItem(int numberPage, boolean currentP) {
		this.numberPage = numberPage;
		this.currentP = currentP;
	}
	public int getNumberPage() {
		return numberPage;
	}
	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}
	public boolean isCurrentPage() {
		return currentP;
	}
	public void setCurrentPage(boolean currentP) {
		this.currentP = currentP;
	}
	
	
}

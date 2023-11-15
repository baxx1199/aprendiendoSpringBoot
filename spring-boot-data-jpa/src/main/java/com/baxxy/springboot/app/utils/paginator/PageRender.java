package com.baxxy.springboot.app.utils.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	private String url;
	private Page<T> page;
	
	private List<PageItem> pages;
	private int totalPages;
	private int numberElmentsByPage;
	private int currentPage;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<PageItem>();
		
		currentPage=page.getNumber()+1;
		numberElmentsByPage = page.getSize();
		totalPages = page.getTotalPages();
		
		int from, at;
		if(totalPages <= numberElmentsByPage) {
			from=  1;
			at = totalPages;
		}else {
			if(currentPage <= numberElmentsByPage/2) {
				from= 1;
				at = numberElmentsByPage;
			}else if(currentPage >= totalPages-numberElmentsByPage/2){
				from = totalPages - numberElmentsByPage +1;
				at = numberElmentsByPage;
			}else {
				from = currentPage- numberElmentsByPage/2;
				at = numberElmentsByPage;
			}
		}
		for(int i =0 ; i<at; i++) {
			pages.add(new PageItem(from+i, currentPage ==from+i));
		}
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<PageItem> getPages() {
		return pages;
	}

	public void setPages(List<PageItem> pages) {
		this.pages = pages;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	public boolean isLast() {
		return page.isLast();
	}
	public boolean isHasNext() {
		return page.hasNext();
	}
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
}

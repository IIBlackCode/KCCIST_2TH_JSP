package com.company.board.DTO;

//import org.slf4j.Logger;

public class PageMaker {
	
//	private static final Logger logger = LoggerFactory.getLogger(PageMaker.class);
	
	private int totalCount;
	private int startPage;
	private int endPage;
	public boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;
	
	private Criteria criteria;
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcDate();
		
	}
	
	private void calcDate() {
		endPage = (int) (Math.ceil(criteria.getPage() /(double) displayPageNum) * displayPageNum);
	
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount /(double) criteria.getPerPageNum()));
		
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage ==1 ? false : true;
		
		next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
		
		System.out.println("[endPage] :"+endPage);
		System.out.println("[tempEndPage] :"+tempEndPage);
		System.out.println("[startPage] :"+startPage);
	}
	
	/*public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
//		.path("/board/read")
		.queryParam("page", page)
		.queryParam("perPageNum", criteria.getPerPageNum())
		.build();
		return uriComponents.toString();
	}*/

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public int getTotalCount() {
		return totalCount;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", criteria=" + criteria + "]";
	}
	
}

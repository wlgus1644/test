package com.study.springrest.domain;

public class PageMaker {
	
	int totalArticles;
	int startPage;
	int endPage;
	
	int pagePerBlock = 10;
	
	boolean next = false;
	boolean prev = false;
	
	Criteria criteria;
	
	public PageMaker(Criteria cri, int total){
		criteria=cri;
		totalArticles = total;
		process();
		
	}
	
	private void process(){
		//��ü ������ ����
		int totalPages = (int)Math.ceil(totalArticles /(double) pagePerBlock);
				//18							175	 / 10
		
		//��û�� ������
		int currentPage =  criteria.getPage(); //11
		
		//������ ��ȣ�� ������ ����		
		endPage = (int)(Math.ceil(currentPage/ (double)pagePerBlock) * pagePerBlock);	//10,20(totalPages)
						//1			10		=0.1 �ø� 1	10
						//5			10		=0.5 �ø� 1	10
						//11		10		=1.1 �ø� 2	20
						//17		10		=1.7 �ø� 2	20
		
		//������ ��ȣ�� ���۵Ǵ� ����
		startPage = (endPage - pagePerBlock	+1);	//1, 11,21,31
					//20			10 			11
					//10			 0			 1
		
		if(endPage>totalPages)
			endPage=totalPages;
		
		
		//���� ������ �� ��ư ����
		if(startPage > 1)
			prev=true;
		
		//���� ������ �� ��ư ���� 10 next=true 	11 next=false 	total =18
		if(endPage < totalPages)
			next=true;
	}
	
	public int getTotalArticles() {
		return totalArticles;
	}


	public void setTotalArticles(int totalArticles) {
		this.totalArticles = totalArticles;
	}


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


	public int getPagePerBlock() {
		return pagePerBlock;
	}


	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public Criteria getCriteria() {
		return criteria;
	}


	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	

}

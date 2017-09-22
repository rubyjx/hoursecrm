package com.zxxz.crm.vo;

import java.util.List;

public class PageBean<T> {
   /*
    * 1.当前页 码      pagecount pc
    * 2.上一页  下一页  
    * 3.总页数         allpage   ap;
    * 4.每页显示的条目数         itemcount  ic
    * 5.总条目数                      allitem     ai
    * 6.每页的所有xinxi pagebean     
    */
	private int pc;//当前页
//	private int ap;//总页数
	private int ic;//每页的条目数量
	private int ai;//总条目数 
	private List<T> beanlist;  //当前页的信息
	private String url;   //页面跳转的地址
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getAp() {
		return ai%ic==0?ai/ic:ai/ic+1;
	}
	//public void setAp(int ap) {
	//	this.ap = ap;
	//}
	public int getIc() {
		return ic;
	}
	public void setIc(int ic) {
		this.ic = ic;
	}
	public int getAi() {
		return ai;
	}
	public void setAi(int ai) {
		this.ai = ai;
	}
 
	public List<T> getBeanlist() {
		return beanlist;
	}
	public void setBeanlist(List<T> beanlist) {
		this.beanlist = beanlist;
	}
	@Override
	public String toString() {
		return "PageBean [pc=" + pc + ", ap=" + ", ic=" + ic + ", ai=" + ai + ", pagebean=" + beanlist + "]";
	}

	
}

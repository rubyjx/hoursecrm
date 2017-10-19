package com.zxxz.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.LinkManDao;
import com.zxxz.crm.vo.LinkManInfo;
import com.zxxz.crm.vo.LinkRecordInfo;
/**
 * linkmanDao层封装查询方法
 * @author leaves
 *
 */
public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {
    //显示所有顾客信息
	@Override
	public List<LinkManInfo> findAllLinkMan(String linkmanInput, String queryType) {
		List<LinkManInfo> find =null;
		StringBuilder hql =new StringBuilder("select 	l from LinkManInfo l ,CustomerInfo b where  l.customerId=b.customerId and l.isUsed=1");
		if (linkmanInput != null && !"".equals(linkmanInput.trim())&& "1".equals(queryType)) {
			hql.append("  and  l.linkmanName  like ?");
			find=(List<LinkManInfo>) this.getHibernateTemplate().find(hql.toString(),"%"+linkmanInput+"%");
		}else if (linkmanInput != null && !"".equals(linkmanInput.trim())&& "2".equals(queryType)) {
			hql.append("  and  b.customerName like ?");
			find=(List<LinkManInfo>) this.getHibernateTemplate().find(hql.toString(),"%"+linkmanInput+"%");
		}else {
			find=(List<LinkManInfo>) this.getHibernateTemplate().find(hql.toString());
			
		}
		return find;
		
		
	}
    //根据id查询LinkMan
	@Override
	public LinkManInfo findLinkManBYLinkManId(int linkmanId) {
         
		return this.getHibernateTemplate().get(LinkManInfo.class, linkmanId);
	}
   //增加LinkMan信息
	@Override
	public void addLinkMan(LinkManInfo linkManInfo) {
		
		this.getHibernateTemplate().save(linkManInfo);
	}
	//修改linkMan信息
	@Override
	public void updateLinkMan(LinkManInfo linkManInfo) {
		this.getHibernateTemplate().update(linkManInfo);
	}

	

}

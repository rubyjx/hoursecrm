package com.zxxz.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.CustomerLinkRecordDao;
import com.zxxz.crm.vo.LinkRecordInfo;
/**
 * 联系记录dao层
 * @author leaves
 *
 */
public class CustomerLinkRecordDaoImpl extends HibernateDaoSupport implements CustomerLinkRecordDao {
   //查询符合条件的记录
	@Override
	public List<LinkRecordInfo> findAllRecordList(String whoLinkInput, String queryType) {
		List<LinkRecordInfo> find =null;
		StringBuilder hql =new StringBuilder("select 	l from LinkRecordInfo l ,CustomerInfo b where  l.customerId=b.customerId and l.isUsed=1");
		if (whoLinkInput != null && !"".equals(whoLinkInput.trim())&& "1".equals(queryType)) {
			hql.append("  and  b.customerName  like ?");
			find=(List<LinkRecordInfo>) this.getHibernateTemplate().find(hql.toString(),"%"+whoLinkInput+"%");
		}else if (whoLinkInput != null && !"".equals(whoLinkInput.trim())&& "2".equals(queryType)) {
			hql.append("  and  l.linkTheme  like ?");
			find=(List<LinkRecordInfo>) this.getHibernateTemplate().find(hql.toString(),"%"+whoLinkInput+"%");
		}else if (whoLinkInput != null && !"".equals(whoLinkInput.trim())&& "3".equals(queryType)) {
			hql.append("  and  l.linkType  like ?");
			find=(List<LinkRecordInfo>) this.getHibernateTemplate().find(hql.toString(),"%"+whoLinkInput+"%");
		}else {
			find=(List<LinkRecordInfo>) this.getHibernateTemplate().find(hql.toString());
			
		}
		return find;
		
		
		
	}
    //根据id查询LinkRecordInfo
	@Override
	public LinkRecordInfo findRecordByRecordId(int recordId) {
		LinkRecordInfo linkRecordInfo = this.getHibernateTemplate().get(LinkRecordInfo.class,recordId);
		return linkRecordInfo;
	}
    //根据id修改数据
	@Override
	public void updateRecordByRecordId(LinkRecordInfo linkRecord) {
		this.getHibernateTemplate().update(linkRecord);
	}
	//增加顾客联系记录
	@Override
	public void addCustomerRecord(LinkRecordInfo linkRecordInfo) {
		this.getHibernateTemplate().save(linkRecordInfo);
		
	}
    
	
     
}

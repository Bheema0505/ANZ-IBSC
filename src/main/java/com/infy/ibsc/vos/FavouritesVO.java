package com.infy.ibsc.vos;

import com.infy.ibsc.util.SQLUtil;
import com.infy.ibsc.util.StrUtil;

public class FavouritesVO extends VO {

	private String id = null;
	private String title = null;
	private String link = null;
	private String type = null;
	private String emp_id=null;

	
	
	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	
	

	@Override
	public String toString() {
		return "FavouritesVO [Id=" + id + ", Title=" + title + ", link=" + link + ", type="
				+ type + "]";
	}

	@Override
	public String getLine() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.id);
		buf.append("\t");
		buf.append(this.title);
		buf.append("\t");
		buf.append(this.link);
		buf.append("\t");

		return buf.toString();
	}

	/*@Override
	public String getTitle() {
		//return "#EmpID	Passwd	FirstName	LastName	Email-id	Q NO.	Ans.	ob_status.	Pending_trainings.	Total_trainings";
	}*/

	@Override
	public VO create(String line) {
		// ID Passwd FirstName LastName
		String[] arr = line.split("\t");

		FavouritesVO vo = new FavouritesVO();
		vo.setId(arr[1]);
		vo.setTitle(arr[2]);
		vo.setLink(arr[3]);
		return vo;
	}

	@Override
	public String insertQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("INSERT INTO IBSC_Favourites (Emp_Id,ID,Title,Link,Type)");
		buf.append(" VALUES( ").append(emp_id).append(",");
		buf.append("NEXT VALUE FOR seq1,");
		buf.append("'").append(title).append("',");
		buf.append("'").append(link).append("',");
		buf.append("'").append(type).append("')");

		return buf.toString();
	}

	
	@Override
	public String updateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("DELETE FROM IBSC_Favourites WHERE ID=").append(id); 
		
		return buf.toString();
	}

	@Override
	public String selectQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * from IBSC_Favourites ");
		String criteria = "";
		criteria  += SQLUtil.getFilterCriteria(criteria, "Emp_Id", emp_id);
		criteria  += SQLUtil.getFilterCriteria(criteria, "ID", id);
		criteria  += SQLUtil.getFilterCriteria(criteria, "Title",title);
		criteria  += SQLUtil.getFilterCriteria(criteria, "Link", link);
		criteria  += SQLUtil.getFilterCriteria(criteria, "Type", type);
	
		
		if(!StrUtil.isNullOrBlank(criteria.trim())) {
			buf.append("WHERE ").append(criteria);
		}

		return buf.toString();
	}

	/*@Override
	public String updateQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append(" UPDATE IBSC_Documents SET  ");
		buf.append(" SELECT ").append(document_id).append(",");
		buf.append("'").append(pass).append("',");
		return buf.toString();
	}

	@Override
	public String deleteQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("DELETE FROM IBSC_USER WHERE Emp_Id=").append(empId); 
		
		return buf.toString();
	}

	@Override
	public String selectQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * from IBSC_USER ");
		String criteria = "";
		criteria  += SQLUtil.getFilterCriteria(criteria, "Emp_Id", empId);
		criteria  += SQLUtil.getFilterCriteria(criteria, "Pswd", pass);
		criteria  += SQLUtil.getFilterCriteria(criteria, "firstName", firstName);
		criteria  += SQLUtil.getFilterCriteria(criteria, "LastName", lastName);
		criteria  += SQLUtil.getFilterCriteria(criteria, "Email_Id", email);
		criteria  += SQLUtil.getFilterCriteria(criteria, " CQ", cqno);
		criteria  += SQLUtil.getFilterCriteria(criteria, "  Ob_Status",Ob_Status);
		criteria  += SQLUtil.getFilterCriteria(criteria, " Ob_Status",  Ob_Status);
		
		if(!StrUtil.isNullOrBlank(criteria.trim())) {
			buf.append("WHERE ").append(criteria);
		}

		return buf.toString();
	}*/

}

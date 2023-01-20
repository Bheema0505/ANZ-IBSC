package com.infy.ibsc.vos;

import com.infy.ibsc.util.SQLUtil;
import com.infy.ibsc.util.StrUtil;

public class DocumentVO extends VO {

	private String document_id = null;
	private String topic_name = null;
	private String link = null;
	private String type = null;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDocument_id() {
		return document_id;
	}

	public void setDocument_id(String document_id) {
		this.document_id = document_id;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "DocumentVO [document_id=" + document_id + ", topic_name=" + topic_name + ", link=" + link + ", type="
				+ type + "]";
	}

	@Override
	public String getLine() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.document_id);
		buf.append("\t");
		buf.append(this.topic_name);
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

		DocumentVO vo = new DocumentVO();
		vo.setDocument_id(arr[1]);
		vo.setTopic_name(arr[2]);
		vo.setLink(arr[3]);
		return vo;
	}

	@Override
	public String insertQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("INSERT INTO IBSC_Documents (Document_ID,Topic_Name,Link)");
		buf.append(" SELECT ").append(document_id).append(",");
		buf.append("'").append(topic_name).append("',");
		buf.append("'").append(link).append("'");

		return buf.toString();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * from IBSC_DOCUMENTS ");
		String criteria = "";
		criteria  += SQLUtil.getFilterCriteria(criteria, "Document_ID", document_id);
		criteria  += SQLUtil.getFilterCriteria(criteria, "Topic_Name",topic_name);
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

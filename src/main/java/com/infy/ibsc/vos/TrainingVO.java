package com.infy.ibsc.vos;

import com.infy.ibsc.util.SQLUtil;

import com.infy.ibsc.util.StrUtil;

public class TrainingVO extends VO {

	private String tr_id = null;
	private String name = null;
	private String type = null;
	private String duration = null;
	private String reference = null;

	public String getTr_id() {
		return tr_id;
	}

	public void setTr_id(String tr_id) {
		this.tr_id = tr_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "TrainingVO [tr_id=" + tr_id + ", name=" + name + ", type=" + type + ", duration=" + duration
				+ ", reference=" + reference + "]";
	}

	@Override
	public String getLine() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.tr_id);
		buf.append("\t");
		buf.append(this.name);
		buf.append("\t");
		buf.append(this.type);
		buf.append("\t");
		buf.append(this.duration);
		buf.append("\t");
		buf.append(this.reference);
		buf.append("\t");

		return buf.toString();
	}

	

	@Override
	public String insertQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("INSERT INTO IBSC_Training (Tr_ID,Name,Type,Duration,Reference)");
		buf.append(" SELECT '").append(tr_id).append("',");
		buf.append("'").append(name).append("',");
		buf.append("'").append(type).append("',");
		buf.append("'").append(duration).append("',");
		buf.append("'").append(reference).append("'");

		return buf.toString();
	}

	@Override
	public String updateQuery() {
		
			
		return null;
	}

	@Override
	public String deleteQuery() {
		return null;
	}

	@Override
	public String selectQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * from IBSC_Training ");
		String criteria = "";
		criteria += SQLUtil.getFilterCriteria(criteria, "Tr_ID", tr_id);
		criteria += SQLUtil.getFilterCriteria(criteria, "Name", name);
		criteria += SQLUtil.getFilterCriteria(criteria, "Type", type);
		criteria += SQLUtil.getFilterCriteria(criteria, "Duration", duration);
		criteria += SQLUtil.getFilterCriteria(criteria, "Reference", reference);

		if (!StrUtil.isNullOrBlank(criteria.trim())) {
			buf.append("WHERE ").append(criteria);
		}

		return buf.toString();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}

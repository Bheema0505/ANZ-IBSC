package com.infy.ibsc.daos.file;

import java.util.ArrayList;
import java.util.Iterator;

import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.FileUtil;
import com.infy.ibsc.vos.VO;

public class FileDAO extends DAO {

	@Override
	public int add(VO vo) {int rowsInserted = 0;
		ArrayList list = this.find(vo); // get all records
		list.add(vo);
		FileUtil.writeDataFile(IBConstants.PATH_DATA_FILES + vo.fileName, list);
		rowsInserted++;
		
		return rowsInserted;
	}

	@Override
	public int edit(VO vo) {
		int rowsUpdated = 0;
		ArrayList list = this.find(vo); int idx = 0;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			VO vo2 = (VO) iterator.next();
			if(vo2.key.equals(vo.key)) {
				rowsUpdated++;
				break;
			}
			idx++;
		}
		if(rowsUpdated == 1) {
			list.remove(idx);
			list.add(vo);
			FileUtil.writeDataFile(IBConstants.PATH_DATA_FILES + vo.fileName, list);
		}
		return rowsUpdated;
	}

	@Override
	public ArrayList find(VO vo) {
		ArrayList list = new ArrayList();
		String filename = IBConstants.PATH_DATA_FILES + vo.fileName;
		ArrayList list2 = FileUtil.readFile(filename);
		for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
			String line = (String) iterator.next();
			if (line.startsWith("#")) {
				// do nothing, skip this line
			} else {
				VO vo2 = vo.create(line);
				list.add(vo2);
			}
		}
		if(!vo.findAll) {
			list = filter(list, vo);
		}
		return list; // returning list of all records from file.

	}

	protected ArrayList filter(ArrayList list, VO vo) {
		ArrayList filtered = new ArrayList();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			try {
				VO emp = (VO) iterator.next();
				if (this.isMatching(emp, vo)) {
					filtered.add(emp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return filtered;
	}
	
	protected boolean isMatching(VO vo, VO VoSrch) {
		return true; // by default matching all
	}

	protected boolean match(int val, int srchVal) {
		if (srchVal == 0 || srchVal == val) {
			return true;
		} else {
			return false;
		}
	}
	protected boolean match(long val, long srchVal) {
		if (srchVal == 0 || srchVal == val) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean match(String val, String srchVal) {
		if (srchVal == null || srchVal.trim().equals("")) {
			return true;
		} else {
			if (srchVal.contains("%")) {
				String nVal = srchVal.replaceAll("%", "");
				if (val.contains(nVal)) {
					return true;
				}
			} else {
				if (val.equals(srchVal)) {
					return true;
				}
			}
			return false;
		}
	}
	
	protected boolean match(float val, float srchVal) {
		if (srchVal == 0.0 || srchVal == val) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int delete(VO vo) {
		int rowsUpdated = 0;
		ArrayList list = this.find(vo); int idx = 0;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			VO vo2 = (VO) iterator.next();
			if(vo2.key.equals(vo.key)) {
				rowsUpdated++;
				break;
			}
			idx++;
		}
		
		if(rowsUpdated == 1) {
			list.remove(idx);
			FileUtil.writeDataFile(IBConstants.PATH_DATA_FILES + vo.fileName, list);
		}
		
		return rowsUpdated;
	}

}
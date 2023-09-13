package project.teamtwo.service;

import java.util.List;
import project.teamtwo.component.BorderDTO;

public interface BorderService {

	public List<BorderDTO> borderall(int startRow, int endRow);
	
	public int count();
	
	public void insert(BorderDTO dto);
	
	public BorderDTO borderselect(int num);
	
	public void borderUpdate(BorderDTO dto);
	
	public void borderdelete(int num);
}

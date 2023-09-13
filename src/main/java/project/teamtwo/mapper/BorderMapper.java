package project.teamtwo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import project.teamtwo.component.BorderDTO;

public interface BorderMapper {
	public List<BorderDTO> borderList(@Param("startRow") int startRow, @Param("endRow") int endRow);
	
	public int count();
	
	public void insert(BorderDTO dto);
	
	public BorderDTO borderselect(int num);
	
	public void borderUpdate(BorderDTO dto);
	
	public void borderdelete(int num);
}

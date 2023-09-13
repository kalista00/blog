package project.teamtwo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import project.teamtwo.component.*;

public interface OnlyimageMapper {

	public void insert(OnlyimageDTO dto); 
	
	public List<OnlyimageDTO> select(@Param("startRow") int startRow,@Param("endRow") int endRow);
	
	public OnlyimageDTO content(int num);
	
	public void delete(int num);
	
	public void update(OnlyimageDTO dto);
	
	public int count();
}

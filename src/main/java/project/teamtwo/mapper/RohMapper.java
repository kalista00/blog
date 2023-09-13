package project.teamtwo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import project.teamtwo.component.RohDTO;

public interface RohMapper {
	
	public List<RohDTO> getList(@Param("startRow")int startRow, @Param("endRow")int endRow);
	public void insertContent(RohDTO dto);
	public RohDTO getContent(RohDTO dto);
	public void deleteContent(RohDTO dto);
	public void updateContent(RohDTO dto);
	public void updateReadCount(RohDTO dto);
	public int countContent();
	
}
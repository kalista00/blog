package project.teamtwo.service;

import java.util.List;

import project.teamtwo.component.RohDTO;

public interface RohService {
	
	public List<RohDTO> getList(int startRow, int endRow);
	public void insertContent(RohDTO dto);
	public RohDTO getContent(RohDTO dto);
	public void deleteContent(RohDTO dto);
	public void updateContent(RohDTO dto);
	public void updateReadCount(RohDTO dto);
	public int countContent();
}

package project.teamtwo.service;

import java.util.List;

import project.teamtwo.component.OnlyimageDTO;

public interface OnlyimageService {

	public void insert(OnlyimageDTO dto);
	
	public List<OnlyimageDTO> select(int startRow,int endRow);
	
	public OnlyimageDTO content(int num);
	
	public void delete(int num);
	
	public void update(OnlyimageDTO dto);
	
	public int count();
}

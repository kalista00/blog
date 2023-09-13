package project.teamtwo.service;

import java.util.List;
import project.teamtwo.component.PictureDTO;

public interface BoardService {
	public List<PictureDTO> list();

	public List<PictureDTO> boardAll(PictureDTO dto);

	public void insert(PictureDTO dto);
	
	public void modify(PictureDTO dto);
	
	public PictureDTO read2(int num);

	public void delete(int num);
}
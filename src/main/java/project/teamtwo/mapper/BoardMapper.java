package project.teamtwo.mapper;

import java.util.List;
import project.teamtwo.component.PictureDTO;

public interface BoardMapper {
	public List<PictureDTO> list();

	public List<PictureDTO> boardAll(PictureDTO dto);

	public void insert(PictureDTO dto);
	
	public PictureDTO read2(int num);
	
	public void modify(PictureDTO dto);

	public void delete(int num);
}

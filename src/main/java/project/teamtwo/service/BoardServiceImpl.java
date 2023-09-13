package project.teamtwo.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.teamtwo.component.PictureDTO;
import project.teamtwo.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper; 

	@Override
	public List<PictureDTO> list() {
		return mapper.list();
	}

	@Override
	public List<PictureDTO> boardAll(PictureDTO dto) {
		return mapper.boardAll(dto);
	}

	@Override
	public void insert(PictureDTO dto) {
		mapper.insert(dto);
	}


	@Override
	public void modify(PictureDTO dto) {
		mapper.modify(dto);
	}

	@Override
	public PictureDTO read2(int num) {
		return mapper.read2(num);
	}

	@Override
	public void delete(int num) {
		mapper.delete(num);
		
	}
}

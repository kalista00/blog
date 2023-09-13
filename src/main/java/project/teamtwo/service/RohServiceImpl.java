package project.teamtwo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.teamtwo.component.RohDTO;
import project.teamtwo.mapper.RohMapper;

@Service
public class RohServiceImpl implements RohService {

	@Autowired
	private RohMapper mapper;
	
	@Override
	public List<RohDTO> getList(int startRow, int endRow) {
		return mapper.getList(startRow, endRow);
	}

	@Override
	public void insertContent(RohDTO dto) {
		mapper.insertContent(dto);
	}

	@Override
	public RohDTO getContent(RohDTO dto) {
		return mapper.getContent(dto);
	}

	@Override
	public void deleteContent(RohDTO dto) {
		mapper.deleteContent(dto);
	}

	@Override
	public void updateContent(RohDTO dto) {
		mapper.updateContent(dto);
	}

	@Override
	public void updateReadCount(RohDTO dto) {
		mapper.updateReadCount(dto);
	}

	@Override
	public int countContent() {
		return mapper.countContent();
	}

}
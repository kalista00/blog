package project.teamtwo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.teamtwo.component.BorderDTO;
import project.teamtwo.mapper.BorderMapper;

@Service
public class BorderServiceImpl implements BorderService{
	@Autowired
	private BorderMapper mapper;
	
	@Override
	public List<BorderDTO> borderall(int startRow, int endRow){
		return mapper.borderList(startRow, endRow);
	}
	
	@Override
	public int count() {
		return mapper.count();
	}
	
	@Override
	public void insert(BorderDTO dto) {
		mapper.insert(dto);
	}
	
	@Override
	public BorderDTO borderselect(int num) {
		return mapper.borderselect(num);
	}
	
	@Override
	public void borderUpdate(BorderDTO dto) {
		mapper.borderUpdate(dto);
	}
	
	@Override
	public void borderdelete(int num) {
		mapper.borderdelete(num);
	}
}

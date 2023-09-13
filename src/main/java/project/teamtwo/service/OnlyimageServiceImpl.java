package project.teamtwo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.teamtwo.component.OnlyimageDTO;
import project.teamtwo.mapper.OnlyimageMapper;

@Service
public class OnlyimageServiceImpl implements OnlyimageService{

	@Autowired
	private OnlyimageMapper mapper;
	
	@Override
	public void insert(OnlyimageDTO dto) {
		mapper.insert(dto);
	}
	
	@Override
	public List<OnlyimageDTO> select(int startRow,int endRow) {
		return mapper.select(startRow,endRow);
	}
	@Override
	public OnlyimageDTO content(int num) {
		return mapper.content(num);
	}
	
	@Override
	public void delete(int num) {
		mapper.delete(num);
	}
	@Override
	public void update(OnlyimageDTO dto) {
		mapper.update(dto);
	}
	@Override
	public int count() {
		return mapper.count();
	}
}

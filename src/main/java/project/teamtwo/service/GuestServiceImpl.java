package project.teamtwo.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.teamtwo.component.GuestDTO;
import project.teamtwo.mapper.GuestMapper;

@Service
public class GuestServiceImpl implements GuestService{
	
	@Autowired
	private GuestMapper mapper;
	
	@Override
	public void insert(GuestDTO dto) {
		mapper.insert(dto);
		
	}

	@Override
	public List<String> list() {
		
		return mapper.list();
	}

	@Override
	public List<GuestDTO> all() {
		
		return mapper.guestList();
	}

	@Override
	public void delete(int num) {
		
		mapper.delete(num);
		
	}

	@Override
	public void updateguest(GuestDTO dto) {
		
		mapper.updateguest(dto);
	}






	
	
	



	
}

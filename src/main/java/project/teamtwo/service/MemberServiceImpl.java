package project.teamtwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.teamtwo.component.MemberDTO;
import project.teamtwo.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public int check(String id) {
		return mapper.check(id);
	}

	@Override
	public void regist(MemberDTO dto) {
		mapper.regist(dto);
	}

	@Override
	public int loginCheck(MemberDTO dto) {
		return mapper.loginCheck(dto);
	}

	@Override
	public void deleteMember(MemberDTO dto) {
		mapper.deleteMember(dto);
	}

	@Override
	public MemberDTO getMember(String id) {
		mapper.getMember(id);
		return null;
	}

	@Override
	public void updateMember(MemberDTO dto) {
		mapper.updateMember(dto);

	}
}
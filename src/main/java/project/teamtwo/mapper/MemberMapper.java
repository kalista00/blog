package project.teamtwo.mapper;


import project.teamtwo.component.MemberDTO;

public interface MemberMapper {
	//xml의 아이디를 매서드이름으로 쓰면됨 //xml의 sql문의 id와 같은 매소드가 실행됨
	
	public int check(String id);
	
	public void regist(MemberDTO dto);
	
	public int loginCheck(MemberDTO dto);
	
	public void deleteMember(MemberDTO dto);
	
	public MemberDTO getMember(String id);
	
	public void updateMember(MemberDTO dto);

}

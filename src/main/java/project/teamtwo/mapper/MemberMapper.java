package project.teamtwo.mapper;


import project.teamtwo.component.MemberDTO;

public interface MemberMapper {
	//xml�� ���̵� �ż����̸����� ����� //xml�� sql���� id�� ���� �żҵ尡 �����
	
	public int check(String id);
	
	public void regist(MemberDTO dto);
	
	public int loginCheck(MemberDTO dto);
	
	public void deleteMember(MemberDTO dto);
	
	public MemberDTO getMember(String id);
	
	public void updateMember(MemberDTO dto);

}

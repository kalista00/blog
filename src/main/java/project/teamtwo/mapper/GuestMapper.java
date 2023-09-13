package project.teamtwo.mapper;

import java.util.List;

import project.teamtwo.component.GuestDTO;

public interface GuestMapper {

	public void insert(GuestDTO dto);
	public List<String> list();
	public List<GuestDTO> guestList();
	public void delete(int num);
	public void updateguest(GuestDTO dto);
}

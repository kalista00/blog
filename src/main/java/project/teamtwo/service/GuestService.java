package project.teamtwo.service;

import java.util.List;

import project.teamtwo.component.GuestDTO;

public interface GuestService {
		
	public void insert(GuestDTO dto);
	public List<String> list();
	public List<GuestDTO> all();
	public void delete(int num);
	public void updateguest(GuestDTO dto);

}

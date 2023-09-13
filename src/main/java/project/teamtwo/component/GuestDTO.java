package project.teamtwo.component;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class GuestDTO {
	private int num;
	private String writer;
	private String content;
	private Timestamp writeday;
}

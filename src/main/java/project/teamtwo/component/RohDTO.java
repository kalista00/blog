package project.teamtwo.component;

import java.io.File;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RohDTO {

	private int num;
	private String id;
	private String pw;
	private String name;
	private String title;
	private String content;
	private int readCount;
	private String img;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date reg_date;
}

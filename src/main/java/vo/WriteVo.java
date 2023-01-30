package vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 	id number(4) primary key,
    subject varchar2(500) not null,
    user_id number(4) not null,
    content clob not null,
    viewcnt number(4) default 0 check (viewcnt >= 0),
    regdate timestamp default sysdate
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WriteVo {
	private int id;
	private String subject;
	private UserVo user;
	private String content;
	private int viewcnt;
	private Timestamp regdate;
}

package vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
	id number(4) primary key,
    username varchar2(500) unique,
    password varchar2(500) not null,
    name varchar2(500) not null,
    authorities varchar2(500) default 'ROLE_MEMBER',
    regdate timestamp default sysdate
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo {
	private int id;
	private String username;
	private String password;
	private String name;
	private String authorities;
	private Timestamp regdate;
}

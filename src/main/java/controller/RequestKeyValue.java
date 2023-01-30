package controller;

import java.util.Map;

import javax.servlet.annotation.WebInitParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestKeyValue {
	private String url;
	private String method;
}

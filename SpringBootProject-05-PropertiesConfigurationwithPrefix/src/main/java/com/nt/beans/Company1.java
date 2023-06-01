package com.nt.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("company1")
@ConfigurationProperties(prefix = "org.nit")
@Data
public class Company1 {
private String tittle;
private String name;
private String location;
@Override
public String toString() {
	return "Company1 [tittel=" + tittle + ", name=" + name + ", location=" + location + "]";
}

}

package com.woobs.wbpt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "champion_list")
public class Champion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer champNum;
	
	private String champName;
	
	private String champImage;
	
	private String champNickname;

}

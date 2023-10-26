package com.woobs.wbpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woobs.wbpt.entity.Champion;

public interface ChampionRepository extends JpaRepository<Champion, Integer>{

	Champion findByChampName(String champName);
	
}

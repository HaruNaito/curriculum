package com.example.demo;

	

	//CrudRepositoryをJpaRepositoryに変更しても使える
	public interface DiaryRepository extends CrudRepository<Diary, Integer> {
	}


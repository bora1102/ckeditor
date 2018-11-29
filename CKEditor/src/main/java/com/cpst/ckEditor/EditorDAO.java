package com.cpst.ckEditor;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EditorDAO {
	@Autowired
	SqlSessionTemplate myBatis;
	
	public void insert(EditorDTO editorDTO) {
		myBatis.insert("editorSQL.insert", editorDTO);
	}
}

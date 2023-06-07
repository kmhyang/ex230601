package com.yedam.app.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("aService") //Bean으로 등록해야 동작을 함.
public class AaaServiceImpl implements AaaService {

	@Autowired
	AaaMapper aaaMapper;
	
	//-> 101은 원래 insert됐는데 두 sql을 결합하니깐 둘다 실행 안함. 전체 롤백됨.
	@Transactional //여러개 sql 같이 동작하도록 결합 
	@Override
	public void insert() { //번호 앞에 화살표 : around로 묶여있다?고 알려주는 표시
		aaaMapper.insert("101");
		aaaMapper.insert("102");
//		aaaMapper.insert("a102"); AaaMapper에서는 String, db table에서는 number형식이라서 이 구문은 실행 오류남.
	}
}

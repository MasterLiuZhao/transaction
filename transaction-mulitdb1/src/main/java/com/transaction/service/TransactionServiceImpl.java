package com.transaction.service;

import com.transaction.dao1.Transaction1Dao;
import com.transaction.dao2.Transaction2Dao;
import com.transaction.pojo.TempA;
import com.transaction.pojo.TempB;
import com.transaction.pojo.TestA;
import com.transaction.pojo.TestB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
//@Transactional
public class TransactionServiceImpl implements TransactionServiceInterface {

	@Autowired
	private Transaction1Dao transaction1Dao;

	@Autowired
	private Transaction2Dao transaction2Dao;

	public List<TestA> getTestA() {
		List<TestA> results = transaction1Dao.getTestA();
		return results;
	}

	public List<TestB> getTestB() {
		List<TestB> results = transaction1Dao.getTestB();
		return results;
	}

	@Transactional(transactionManager = "transactionManager1")
	public Integer insertTestA(TestA testA) {
		Integer count = transaction1Dao.insertTestA(testA);

		TestB testB = new TestB();
		testB.setApplyBillID(UUID.randomUUID().toString());
		testB.setBillStauts(1);
		testB.setGetUser("MyTest");
		this.insertTestB(testB);
		return count;
	}

	@Transactional(transactionManager = "transactionManager1")
	public Integer insertTestB(TestB testB) {
		Integer count = transaction1Dao.insertTestB(testB);
		if (true) {
			//throw new NullPointerException();
		}
		return count;
	}

	public List<TempA> getTempA() {
		List<TempA> results = transaction2Dao.getTempA();
		return results;
	}

	public List<TempB> getTempB() {
		List<TempB> results = transaction2Dao.getTempB();
		return results;
	}

	@Transactional(transactionManager = "transactionManager2")
	public Integer insertTempA(TempA tempA) {
		Integer count = transaction2Dao.insertTempA(tempA);

		TempB tempB = new TempB();
		tempB.setId(UUID.randomUUID().toString());
		tempB.setCompany("company1111");
		tempB.setPosition("position1111");
		this.insertTempB(tempB);
		return count;
	}

	@Transactional(transactionManager = "transactionManager2")
	public Integer insertTempB(TempB tempB) {
		Integer count = transaction2Dao.insertTempB(tempB);
		if (true) {
			//throw new NullPointerException();
		}
		return count;
	}


}

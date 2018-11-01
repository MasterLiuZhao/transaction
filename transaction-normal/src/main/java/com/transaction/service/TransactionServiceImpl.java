package com.transaction.service;

import com.transaction.dao1.TransactionDao;
import com.transaction.pojo.TestA;
import com.transaction.pojo.TestB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionServiceInterface {

	@Autowired
	private TransactionDao transactionDao;

	public List<TestA> getTestA() {
		List<TestA> results = transactionDao.getTestA();
		return results;
	}

	public List<TestB> getTestB() {
		List<TestB> results = transactionDao.getTestB();
		return results;
	}

	//@Transactional(propagation = Propagation.SUPPORTS)
	public Integer insertTestA(TestA testA) {
		Integer count = transactionDao.insertTestA(testA);

		TestB testB = new TestB();
		testB.setApplyBillID(UUID.randomUUID().toString());
		testB.setBillStauts(1);
		testB.setGetUser("MyTest");
		this.insertTestB(testB);
		return count;
	}

	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Integer insertTestB(TestB testB) {
		Integer count = transactionDao.insertTestB(testB);
		if (true) {
			throw new NullPointerException();
		}
		return count;
	}


}

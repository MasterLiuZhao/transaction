package com.transaction.service;

import com.transaction.dao.Transaction1Dao;
import com.transaction.dao.Transaction2Dao;
import com.transaction.datasource.DataSourceKeyHolder;
import com.transaction.datasource.SetDataSourceByKey;
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

	public Integer insertTestA(TestA testA) {
		System.out.println("执行 insertTestA() 方法");

		Integer count = transaction1Dao.insertTestA(testA);

		TestB testB = new TestB();
		testB.setApplyBillID(UUID.randomUUID().toString());
		testB.setBillStauts(1);
		testB.setGetUser("MyTest");
		this.insertTestB(testB);
//
//		TempA tempA = new TempA();
//		tempA.setId(UUID.randomUUID().toString());
//		tempA.setName("name111");
//		tempA.setSchool("school111");
//		this.insertTempA(tempA);

		return count;
	}

	public Integer insertTestB(TestB testB) {
		System.out.println("执行 insertTestB() 方法");

		Integer count = transaction1Dao.insertTestB(testB);
		if (true) {
			throw new NullPointerException();
		}
		return count;
	}

	@SetDataSourceByKey("data_source_2")
	public List<TempA> getTempA() {
		List<TempA> results = transaction2Dao.getTempA();
		return results;
	}

	@SetDataSourceByKey("data_source_2")
	public List<TempB> getTempB() {
		List<TempB> results = transaction2Dao.getTempB();
		return results;
	}

	@SetDataSourceByKey("data_source_2")
	public Integer insertTempA(TempA tempA) {
		System.out.println("执行 insertTempA() 方法");

//		System.out.println("set data source to data_source_2");
//		DataSourceKeyHolder.setDataSourceKey("data_source_2");

		Integer count = transaction2Dao.insertTempA(tempA);

		TempB tempB = new TempB();
		tempB.setId(UUID.randomUUID().toString());
		tempB.setCompany("company1111");
		tempB.setPosition("position1111");
		this.insertTempB(tempB);
		return count;
	}

	@SetDataSourceByKey("data_source_2")
	public Integer insertTempB(TempB tempB) {
		System.out.println("执行 insertTempB() 方法");

		Integer count = transaction2Dao.insertTempB(tempB);
		if (true) {
			//throw new NullPointerException();
		}
		return count;
	}


}

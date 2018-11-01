package com.transaction.service;

import com.transaction.pojo.TempA;
import com.transaction.pojo.TempB;
import com.transaction.pojo.TestA;
import com.transaction.pojo.TestB;

import java.util.List;

public interface TransactionServiceInterface {

	public List<TestA> getTestA();

	public List<TestB> getTestB();

	public Integer insertTestA(TestA testA);

	public Integer insertTestB(TestB testB);

	public List<TempA> getTempA();

	public List<TempB> getTempB();

	public Integer insertTempA(TempA tempA);

	public Integer insertTempB(TempB tempB);

}

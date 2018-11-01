package com.transaction.dao1;

import com.transaction.pojo.TestA;
import com.transaction.pojo.TestB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDao {

	public List<TestA> getTestA();

	public List<TestB> getTestB();

	public Integer insertTestA(TestA testA);

	public Integer insertTestB(TestB testB);

}

package com.transaction.dao;

import com.transaction.pojo.TempA;
import com.transaction.pojo.TempB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Transaction2Dao {

	public List<TempA> getTempA();

	public List<TempB> getTempB();

	public Integer insertTempA(TempA tempA);

	public Integer insertTempB(TempB tempB);

}

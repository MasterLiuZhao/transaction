package com.transaction.controller;

import com.transaction.pojo.TestA;
import com.transaction.pojo.TestB;
import com.transaction.service.TransactionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends BaseController {

	@Autowired
	private TransactionServiceInterface transactionService;

	@RequestMapping("/diffScheme")
	public String diffScheme() {

		TestA testA = new TestA();
		testA.setCustomerID(UUID.randomUUID().toString());
		testA.setCustomerNM("MyTest");
		testA.setSex("Male");
		testA.setAge(25);
		testA.setAa("1");
		transactionService.insertTestA(testA);

//		TestB testB = new TestB();
//		testB.setApplyBillID(UUID.randomUUID().toString());
//		testB.setBillStauts(1);
//		testB.setGetUser("MyTest");
//		transactionService.insertTestB(testB);

		List<TestA> listA = transactionService.getTestA();
		System.out.println("listA.size()=" + listA.size());
		for (TestA temp : listA) {
			System.out.println(temp.getCustomerID() + ", " + temp.getCustomerNM() + ", " + temp.getAge() + ", " + temp.getSex() + ", " + temp.getAa());
		}

		List<TestB> listB = transactionService.getTestB();
		System.out.println("listB.size()=" + listB.size());
		for (TestB temp : listB) {
			System.out.println(temp.getApplyBillID() + ", " + temp.getBillStauts() + ", " + temp.getGetUser());
		}

		return "Success";
	}

}

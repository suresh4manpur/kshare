package com.kshare;

import com.kshare.dao.PersonDao;
import com.kshare.entity.Person;

public class MyTest {
public static void main(String[] args) {
	PersonDao dao = new PersonDao();
	Person per = dao.getPersonById(1);
}
}

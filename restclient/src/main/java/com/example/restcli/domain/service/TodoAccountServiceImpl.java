package com.example.restcli.domain.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.restcli.domain.model.Todo;

@Service
public class TodoAccountServiceImpl implements TodoAccountService {

	@Inject
    RestTemplate restTemplate;

	@Override
	public String findAll() {

		String resource = restTemplate.getForObject(
			"http://localhost:8080/td170noormth/api/v1/todos",
			 String.class);

	    System.out.println(resource);

		return resource;
	}

	@Override
	public Todo findOne(String todoId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String findByTodoTitle(String todoTitle) {

		System.out.println(todoTitle + "で検索される");

		String resource = restTemplate.getForObject(
				"http://localhost:8080/td170noormth/api/v1/todo/" + todoTitle ,
				 String.class);

		System.out.println(resource);
		System.out.println("上の値を外部から取得");

		return resource;
	}

}

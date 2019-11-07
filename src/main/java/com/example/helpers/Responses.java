package com.example.helpers;

import org.springframework.stereotype.Service;

import com.example.models.ResponseApi;

@Service
public class Responses<T> {

	public ResponseApi<T> sendResponseOkData(T data) {

		ResponseApi<T> response = new ResponseApi<>();

		response.setCode("OK");
		response.setMessage("");
		response.setData(data);
		return response;
	}

	public ResponseApi<T> sendResponseError(String error) {

		ResponseApi<T> response = new ResponseApi<>();

		response.setCode("ERROR");
		response.setMessage(error);

		return response;
	}

}

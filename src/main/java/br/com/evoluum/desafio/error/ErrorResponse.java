package br.com.evoluum.desafio.error;

import static  com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static lombok.AccessLevel.PRIVATE;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@JsonAutoDetect(fieldVisibility = ANY )
@RequiredArgsConstructor( access = PRIVATE)
public class ErrorResponse {

	private final int statusCode;
	private final List<ApiError> erros;
	
	static ErrorResponse of( HttpStatus status, List<ApiError> errors ) {
		return new ErrorResponse(status.value(), errors);
		
	}
	
	@JsonAutoDetect(fieldVisibility = ANY )
	@RequiredArgsConstructor( access = PRIVATE)
	static class ApiError {
		private final String code;
		private final String message;
	}
}

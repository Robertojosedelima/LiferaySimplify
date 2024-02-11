package br.com.LiferaySimplify.ToDoList.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
		String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
		return ResponseEntity.badRequest().body(errorMessage);
	}

	@ExceptionHandler(IllegalAccessException.class)
	public ResponseEntity<String> handleIllegalAccessException(IllegalAccessException ex) {
		// Tratamento específico para IllegalAccessException
		// Pode imprimir uma mensagem de log, notificar o usuário, etc.
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro 500: " + ex.getMessage());
	}

}

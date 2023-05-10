package com.mensajeria.ServicioMensajeria.Exception;

import com.mensajeria.ServicioMensajeria.Dto.ApiException;
import com.mensajeria.ServicioMensajeria.Exception.ExcepcionCustomer;
import com.mensajeria.ServicioMensajeria.Exception.ExcepcionEmployee;
import com.mensajeria.ServicioMensajeria.Exception.ExcepcionPackage;
import com.mensajeria.ServicioMensajeria.Exception.ExceptionSendPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandle {


    @ExceptionHandler(  value={ ExcepcionCustomer.class, ExceptionSendPackage.class, ExcepcionEmployee.class, ExcepcionPackage.class , RuntimeException.class  })
    public ResponseEntity<Object> handleDataNotFoundException(Exception ex  ) {

        ApiException apiException = new ApiException(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))

        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value={AccessDeniedException.class, AuthenticationException.class})
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex) {
        ApiException apiException = new ApiException(
                ex.getMessage(),
                HttpStatus.UNAUTHORIZED,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, HttpStatus.UNAUTHORIZED);
    }

}

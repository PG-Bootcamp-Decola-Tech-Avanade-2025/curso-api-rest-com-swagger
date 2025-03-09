package pg.decola_tech_avanade_2025.cursos.api_rest_com_swagger.controller;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.procedure.ParameterTypeException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.badRequest().body(String.format(
            "Tipo inválido fornecido para parâmetro %s. Esperado: %s.",
            StringUtils.capitalize(e.getName()),
            e.getParameter().getParameterType().getSimpleName()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
}

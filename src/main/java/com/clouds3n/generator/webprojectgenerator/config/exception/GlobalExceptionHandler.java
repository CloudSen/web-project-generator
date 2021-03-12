package com.clouds3n.generator.webprojectgenerator.config.exception;

import com.clouds3n.generator.webprojectgenerator.common.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author clouds3n
 * @time 2020-11 20:12
 */
@Slf4j
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String SERVER_ERROR = "服务端错误";

    @ExceptionHandler(BusinessException.class)
    public Res businessExceptionHandler(BusinessException e, WebRequest request) {
        return commonHandle(e, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Res validationExceptionHandler(MethodArgumentNotValidException e) {
        log.error(ExceptionUtils.getStackTrace(e));
        StringBuilder msg = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(error -> {
            Arrays.stream(Objects.requireNonNull(error.getArguments()))
                .filter(o -> o instanceof DefaultMessageSourceResolvable)
                .forEach(
                    o -> msg.append(((DefaultMessageSourceResolvable) o).getDefaultMessage()).append(" => ")
                );
            msg.append(error.getDefaultMessage()).append(" | ");
        });
        return Res.error(
            StringUtils.isBlank(msg.toString())
                ? SERVER_ERROR
                : msg.substring(0, msg.toString().length() - 1)
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Res illegalArgumentExceptionHandler(IllegalArgumentException e, WebRequest request) {
        return commonHandle(e, request);
    }


    @ExceptionHandler(Exception.class)
    public Res otherExceptionHandler(Exception e) {
        log.error(ExceptionUtils.getStackTrace(e));
        String msg = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        if (StringUtils.isBlank(msg)) {
            msg = SERVER_ERROR;
        }
        return Res.error(msg);
    }

    private Res commonHandle(Exception e, WebRequest request) {
        log.error(request.getContextPath());
        log.error(ExceptionUtils.getStackTrace(e));
        return Res.error(StringUtils.isBlank(e.getMessage()) ? SERVER_ERROR : e.getMessage());
    }
}

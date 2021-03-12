package com.clouds3n.generator.webprojectgenerator.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author clouds3n
 * @time 2020-11 17:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Res implements Serializable {

    private static final long serialVersionUID = -298371413141055235L;
    private Boolean success;
    private Integer code;
    private String msg;
    private Object data;

    public static Res ok() {
        return new Res(
            Boolean.TRUE,
            HttpStatus.OK.value(),
            Constants.OPT_SUCCESS,
            null
        );
    }

    public static Res ok(Object data) {
        return ok().setData(data);
    }

    public static Res error() {
        return new Res(
            Boolean.FALSE,
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            Constants.OPT_FAILED,
            null
        );
    }

    public static Res error(String reason) {
        return error().setMsg(reason);
    }

    public static Res error(String reason, Object data) {
        return error().setMsg(reason).setData(data);
    }

    public static Res error(Integer code, String reason, Object data) {
        return error().setCode(code).setMsg(reason).setData(data);
    }
}

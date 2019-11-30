package top.wale.rw.im.server.entity;

/**
 * Function:
 *
 * @author wale
 * @date 2019/11/29
 */
public class BaseResponse {

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

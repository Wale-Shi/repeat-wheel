package top.wale.rw.im.server.entity;

/**
 * Function:
 *
 * @author wale
 * @date 2019/11/29
 */
public class MessageRequest extends BaseRequest {

    private Long userId;

    private String message;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

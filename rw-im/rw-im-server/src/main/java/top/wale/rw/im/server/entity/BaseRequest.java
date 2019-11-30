package top.wale.rw.im.server.entity;

/**
 * Function:
 *
 * @author wale
 * @date 2019/11/29
 */
public class BaseRequest {

    private String seqNo;

    private Long timestamp;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}

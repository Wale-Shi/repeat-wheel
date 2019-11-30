package top.wale.rw.im.server.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wale.rw.im.server.entity.BaseResponse;
import top.wale.rw.im.server.entity.MessageRequest;

/**
 * Function:
 *
 * @author wale
 * @date 2019/11/29
 */
@Controller("message")
public class MessageController {

    @RequestMapping("/sendMsg")
    public BaseResponse sendMsg(MessageRequest req) {
        return new BaseResponse();
    }

}

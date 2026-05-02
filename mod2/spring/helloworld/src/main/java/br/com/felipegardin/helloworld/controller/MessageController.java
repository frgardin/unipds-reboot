package br.com.felipegardin.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipegardin.helloworld.service.IMessageService;

@RestController
@RequestMapping("api")
public class MessageController {

    private final IMessageService messageServiceV1;
    private final IMessageService messageServiceV2;

    public MessageController(
        @Autowired @Qualifier("v1") IMessageService messageServicev1,
        @Autowired @Qualifier("v2") IMessageService messageServicev2
    ) {
        this.messageServiceV1 = messageServicev1;
        this.messageServiceV2 = messageServicev2;
    }

    @PostMapping("/v1/messages")
    public String getV1(@RequestBody String message) {
        return messageServiceV1.sayCustomMessage(message);
    }


    @PostMapping("/v2/messages")
    public String getV2(@RequestBody String message) {
        return messageServiceV2.sayCustomMessage(message);
    }
}

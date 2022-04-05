package com.amr.project.webapp.controller;

import com.amr.project.converter.MessageMapper;
import com.amr.project.model.dto.MessageDto;
import com.amr.project.model.entity.Message;
import com.amr.project.service.abstracts.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @GetMapping
    public ResponseEntity<List<MessageDto>> getAll() {
        List<Message> messageList = messageService.findAll();
        return ResponseEntity.ok(messageMapper.toDtoList(messageList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> getById(@PathVariable Long id) {
        Message messageGet = messageService.findById(id);
        return ResponseEntity.ok(messageMapper.toDto(messageGet));
    }

    @PutMapping()
    public ResponseEntity<MessageDto> edit(@RequestBody MessageDto messageDto) {
        Message message = messageMapper.toEntity(messageDto);
        messageService.update(message);
        Message messageUpdate = messageService.findById(message.getId());
        return ResponseEntity.ok(messageMapper.toDto(messageUpdate));
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        messageService.deleteByIdCascadeEnable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @MessageMapping("/chat")
    @SendTo("/topic/public")
    public MessageDto send(MessageDto messageDto) {
        Message message = messageMapper.toEntity(messageDto);
        Message messageSend = messageService.persist(message);
        return messageMapper.toDto(messageSend);
    }
}

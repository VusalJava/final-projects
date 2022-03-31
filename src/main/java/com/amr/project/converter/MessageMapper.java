package com.amr.project.converter;

import com.amr.project.model.dto.MessageDto;
import com.amr.project.model.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ChatMapper.class})
public interface MessageMapper extends MapperInterface<MessageDto, Message> {
    @Mapping(target = "chatId", source = "chat.id")
    @Override
    MessageDto toDto(Message entity);
}

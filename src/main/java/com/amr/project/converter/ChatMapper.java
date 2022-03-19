package com.amr.project.converter;

import com.amr.project.model.dto.ChatDto;
import com.amr.project.model.entity.Chat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MessageMapper.class, UserMapper.class})
public interface ChatMapper extends MapperInterface<ChatDto, Chat> {
}

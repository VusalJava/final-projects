package com.amr.project.converter;

import com.amr.project.model.dto.UserInfoDto;
import com.amr.project.model.entity.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface UserInfoMapper extends MapperInterface<UserInfoDto, UserInfo> {
}
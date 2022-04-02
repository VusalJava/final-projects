package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Message;
import com.amr.project.service.abstracts.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ReadWriteServiceImpl<Message, Long> implements MessageService {

    public MessageServiceImpl(ReadWriteDao<Message, Long> dao) {
        super(dao);
    }
}

package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.MessageReadWriteDao;
import com.amr.project.model.entity.Message;
import org.springframework.stereotype.Repository;

@Repository
public class MessageReadWriteDaoImpl extends ReadWriteDaoImpl<Message, Long> implements MessageReadWriteDao {
}

package com.compurent.compurent.service;

import java.util.List;
import java.util.Optional;

import com.compurent.compurent.model.Message;
import com.compurent.compurent.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message>getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message>getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }
        else{
            Optional<Message> consult=messageRepository.getMessage(message.getIdMessage());
            if(consult.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> consult=messageRepository.getMessage(message.getIdMessage());
            if(!consult.isEmpty()) {
                if(message.getMessageText()!=null){
                    consult.get().setMessageText(message.getMessageText());
                }
                // if(message.getInsertDateTime()!=null){
                //     consult.get().setInsertDateTime(message.getInsertDateTime());
                // }
                // if(message.getReaded()!=null){
                //     consult.get().setReaded(message.getReaded());
                // }
                return messageRepository.save(consult.get());
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean deleteMessage(int idMessage){
        Optional<Message> consult=messageRepository.getMessage(idMessage);
        if(!consult.isEmpty()){
            messageRepository.delete(consult.get());

            return true;
        }
        return false;
    }
}

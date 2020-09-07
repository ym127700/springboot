package cn.bdqn.service;

import cn.bdqn.entity.Type;
import cn.bdqn.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

            public Type getType(Integer tid){
                return typeRepository.findById(tid).get();
            }


}

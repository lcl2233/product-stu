package org.bomb.duapp.mp.service.impl;

import org.bomb.duapp.mp.entity.OpusOutAmount;
import org.bomb.duapp.mp.mapper.OpusOutAmountMapper;
import org.bomb.duapp.mp.service.IOpusOutAmountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bomb
 * @since 2020-01-20
 */
@Service
public class OpusOutAmountServiceImpl extends ServiceImpl<OpusOutAmountMapper, OpusOutAmount> implements IOpusOutAmountService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Transactional
    @Override
    public Boolean save(OpusOutAmount source, OpusOutAmount target) {
        this.save(source);
        this.save(target);
        return true;
    }

    @Override
    public Boolean saveByTransactionTemplate(OpusOutAmount source, OpusOutAmount target) {
        transactionTemplate.execute(action -> {
            this.save(source);
            this.save(target);
            return true;
        });
        return null;
    }


}

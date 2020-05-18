package org.bomb.duapp.mp.service;

import org.bomb.duapp.mp.entity.OpusOutAmount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bomb
 * @since 2020-01-20
 */
public interface IOpusOutAmountService extends IService<OpusOutAmount> {

    Boolean save(OpusOutAmount source, OpusOutAmount target);

    Boolean saveByTransactionTemplate(OpusOutAmount source, OpusOutAmount target);

}

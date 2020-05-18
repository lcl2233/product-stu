package org.bomb.duapp.mp.controller;


import org.bomb.duapp.mp.entity.OpusOutAmount;
import org.bomb.duapp.mp.model.OpusModel;
import org.bomb.duapp.mp.service.IOpusOutAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bomb
 * @since 2020-01-20
 */
@RestController
@RequestMapping("/opus-out-amount")
public class OpusOutAmountController {

    @Autowired
    private IOpusOutAmountService iOpusOutAmountService;

    @GetMapping("/list")
    public List<OpusOutAmount> list(){
        return iOpusOutAmountService.list();
    }

    @PostMapping("/insert")
    public Boolean insert(@RequestBody OpusOutAmount opusOutAmount) {
        return iOpusOutAmountService.save(opusOutAmount);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody OpusOutAmount opusOutAmount) {
        return iOpusOutAmountService.updateById(opusOutAmount);
    }

    @PostMapping("/save")
    public Boolean save(@RequestBody OpusModel model) {
        return iOpusOutAmountService.save(model.getSource(), model.getTarget());
    }

}


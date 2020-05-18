package org.bomb.duapp.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author bomb
 * @since 2020-01-20
 */
public class OpusOutAmount implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账户
     */
    private Long account;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 0-出账
     */
    private Integer opusType;

    /**
     * 金额
     */
    private Long amount;

    /**
     * 操作时间
     */
    private Date opusTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getOpusType() {
        return opusType;
    }

    public void setOpusType(Integer opusType) {
        this.opusType = opusType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getOpusTime() {
        return opusTime;
    }

    public void setOpusTime(Date opusTime) {
        this.opusTime = opusTime;
    }

    @Override
    public String toString() {
        return "OpusOutAmount{" +
        "id=" + id +
        ", account=" + account +
        ", userId=" + userId +
        ", opusType=" + opusType +
        ", amount=" + amount +
        ", opusTime=" + opusTime +
        "}";
    }
}

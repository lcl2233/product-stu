package org.bomb.duapp.mp.model;

import org.bomb.duapp.mp.entity.OpusOutAmount;

public class OpusModel {
    private OpusOutAmount source;

    private OpusOutAmount target;

    public OpusOutAmount getSource() {
        return source;
    }

    public void setSource(OpusOutAmount source) {
        this.source = source;
    }

    public OpusOutAmount getTarget() {
        return target;
    }

    public void setTarget(OpusOutAmount target) {
        this.target = target;
    }
}

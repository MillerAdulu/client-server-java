package app.models;

import java.io.Serializable;

public class ToyMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Batch1 batch1;
    private Batch2 batch2;
    private Batch3 batch3;

    public Batch1 getBatch1() {
        return batch1;
    }

    public Batch3 getBatch3() {
        return batch3;
    }

    public void setBatch3(Batch3 batch3) {
        this.batch3 = batch3;
    }

    public Batch2 getBatch2() {
        return batch2;
    }

    public void setBatch2(Batch2 batch2) {
        this.batch2 = batch2;
    }

    public void setBatch1(Batch1 batch1) {
        this.batch1 = batch1;
    }

}
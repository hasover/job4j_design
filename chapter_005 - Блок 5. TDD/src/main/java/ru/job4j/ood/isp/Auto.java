package ru.job4j.ood.isp;

//электромобили не используют бензин, а обычные - электроэнергию
public interface Auto {
    void move();
    void stop();
    void speedUp();
    void fuel();
    void charge();
}

class BMW implements Auto {

    @Override
    public void move() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void speedUp() {

    }

    @Override
    public void fuel() {

    }

    @Override
    public void charge() {
        throw new UnsupportedOperationException("BMW uses fuel!!");

    }
}

class Tesla implements Auto {

    @Override
    public void move() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void speedUp() {

    }

    @Override
    public void fuel() {
        throw new UnsupportedOperationException("Tesla uses electricity!");

    }

    @Override
    public void charge() {

    }
}

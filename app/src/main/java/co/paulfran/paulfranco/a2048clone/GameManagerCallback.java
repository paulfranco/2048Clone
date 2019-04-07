package co.paulfran.paulfranco.a2048clone;

public interface GameManagerCallback {

    void gameOver();
    void updateScore(int delta);
    void reached2048();

}

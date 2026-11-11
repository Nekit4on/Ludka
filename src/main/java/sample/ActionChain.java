package sample;

import java.util.Random;

public class ActionChain {

    Handler chain;
    public static int SUCCESS = PositiveHandler.SUCCESS;
    public static int CHANCE = ChanceHandler.CHANCE;
    public static int LOSS = NegativeHandler.LOSS;

    Random generate;
    final int NUMHANDLER = 4;
    final int NUMMAX = 7;

    public ActionChain() {
        generate = new Random();
        buildChain();
    }

    private void buildChain() {
        chain = new NegativeHandler(
                new PositiveHandler(
                        new ChanceHandler(null)
                )
        );
    }

    public boolean process() {
        int type = generate.nextInt(NUMHANDLER);
        return process(type);
    }

    public boolean process(Integer a) {
        int itog = 1 + a % NUMHANDLER;
        return chain.process(itog);
    }

    public int getVyigryshSumma() {
        return PositiveHandler.vyigryshSumma;
    }
}

package hu.me.iit.webalk.springConsoleApp.impl;

import hu.me.iit.webalk.springConsoleApp.Engine;

public class CombustionEngine implements Engine {

    private final int bhp;
    private final int cc;

    public CombustionEngine(int bhp, int cc) {
        this.bhp = bhp;
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "bhp=" + bhp +
                ", cc=" + cc +
                '}';
    }
}

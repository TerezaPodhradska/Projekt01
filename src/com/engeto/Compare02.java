package com.engeto;

import java.util.Comparator;

public class Compare02 implements Comparator<State02> {
    @Override
    public int compare(State02 first, State02 second) {
        return Double.compare(second.getFullTAxValue(), first.getFullTAxValue());
    }
}

package com.engeto;

import java.util.Comparator;

public class Compare implements Comparator<State> {
    @Override
    public int compare(State first, State second) {
        return Double.compare(second.getFullTAxValue(), first.getFullTAxValue());
    }
}

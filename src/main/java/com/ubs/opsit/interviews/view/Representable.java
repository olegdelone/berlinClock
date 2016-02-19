package com.ubs.opsit.interviews.view;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public interface Representable<T, I> {
    T represent(Iterable<I> iterable);
}

package com.tencent.wstt.gt.actors;

/**
 * Created by ChenGong on 23/10/2017
 */

public interface Actor {
    void initialize();

    boolean isInitialized();

    boolean act();

    boolean isActed();

    void dispose();

    boolean isDisposed();
}

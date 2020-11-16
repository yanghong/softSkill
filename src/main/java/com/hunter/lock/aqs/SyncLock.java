package com.hunter.lock.aqs;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * @description:
 * @author: hunter.yang
 * @date: 20201112 9:42
 */
public class SyncLock {

    private final Sync sync;

    public SyncLock() {
        sync = new Sync();
    }

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    private static class Sync extends AbstractQueuedLongSynchronizer {

        @Override
        protected boolean tryAcquire(long arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(long arg) {
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

    }
}

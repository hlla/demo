package com.tencent.wstt.gt.actors;

import android.content.Context;

import com.tencent.wstt.gt.GTApp;
import com.tencent.wstt.gt.utils.ToastUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by ChenGong on 23/10/2017
 */

public class BaseActor implements Actor {
    private AtomicBoolean mIsInitialized = new AtomicBoolean(false);
    private AtomicBoolean mActed = new AtomicBoolean(false);
    private AtomicBoolean mDisposed = new AtomicBoolean(false);
    protected Context mContext;
    protected ExecutorService mExecutor;
    protected final String TAG;

    public BaseActor(Context mContext) {
        this.mContext = mContext;
        TAG = this.getClass().getSimpleName();
    }

    @Override
    public void initialize() {
        mIsInitialized.set(true);
        mExecutor = GTApp.getsExecutor();
    }

    @Override
    public boolean isInitialized() {
        return mIsInitialized.get();
    }

    @Override
    public boolean act() {
        mActed.set(true);
        return false;
    }

    @Override
    public boolean isActed() {
        return mActed.get();
    }

    @Override
    public void dispose() {
        mIsInitialized.set(false);
        mActed.set(false);
        mDisposed.set(true);
    }

    @Override
    public boolean isDisposed() {
        return mDisposed.get();
    }

    protected void toast(final Context context, final String text) {
        toast(context, text, true);
    }

    protected void toast(final Context context, final String text, boolean longOrShort) {
        System.out.println(TAG + "  " + text);
        if (longOrShort) {
            ToastUtil.ShowLongToast(context, text);
        } else {
            ToastUtil.ShowShortToast(context, text);
        }
    }
}

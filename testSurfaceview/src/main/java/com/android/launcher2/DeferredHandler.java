package com.android.launcher2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import java.util.LinkedList;

public class DeferredHandler
{
  private Impl mHandler = new Impl(null);
  private MessageQueue mMessageQueue = Looper.myQueue();
  private LinkedList<Runnable> mQueue = new LinkedList();
  
  public void cancel()
  {
    synchronized (this.mQueue)
    {
      this.mQueue.clear();
      return;
    }
  }
  
  public void cancelRunnable(Runnable paramRunnable)
  {
    synchronized (this.mQueue)
    {
      while (this.mQueue.remove(paramRunnable)) {}
      return;
    }
  }
  
  public void post(Runnable paramRunnable)
  {
    synchronized (this.mQueue)
    {
      this.mQueue.add(paramRunnable);
      if (this.mQueue.size() == 1) {
        scheduleNextLocked();
      }
      return;
    }
  }
  
  public void postIdle(Runnable paramRunnable)
  {
    post(new IdleRunnable(paramRunnable));
  }
  
  void scheduleNextLocked()
  {
    if (this.mQueue.size() > 0)
    {
      if (((Runnable)this.mQueue.getFirst() instanceof IdleRunnable)) {
        this.mMessageQueue.addIdleHandler(this.mHandler);
      }
    }
    else {
      return;
    }
    this.mHandler.sendEmptyMessage(1);
  }
  
  private class IdleRunnable
    implements Runnable
  {
    Runnable mRunnable;
    
    IdleRunnable(Runnable paramRunnable)
    {
      this.mRunnable = paramRunnable;
    }
    
    public void run()
    {
      this.mRunnable.run();
    }
  }
  
  private class Impl
    extends Handler
    implements MessageQueue.IdleHandler
  {
    private Impl() {}
    
    public void handleMessage(Message arg1)
    {
      synchronized (DeferredHandler.this.mQueue)
      {
        if (DeferredHandler.this.mQueue.size() == 0) {
          return;
        }
        Runnable localRunnable = (Runnable)DeferredHandler.this.mQueue.removeFirst();
        localRunnable.run();
        synchronized (DeferredHandler.this.mQueue)
        {
          DeferredHandler.this.scheduleNextLocked();
          return;
        }
      }
    }
    
    public boolean queueIdle()
    {
      handleMessage(null);
      return false;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/DeferredHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
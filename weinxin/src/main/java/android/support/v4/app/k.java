package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class k<E>
  extends i
{
  final Context mContext;
  final Handler mHandler;
  boolean pA;
  final m pg = new m();
  t py;
  boolean pz;
  final Activity qb;
  final int qc;
  android.support.v4.e.i<String, s> qd;
  boolean qe;
  
  private k(Activity paramActivity, Context paramContext, Handler paramHandler)
  {
    this.qb = paramActivity;
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.qc = 0;
  }
  
  k(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, paramFragmentActivity.mHandler);
  }
  
  final t a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.qd == null) {
      this.qd = new android.support.v4.e.i();
    }
    t localt = (t)this.qd.get(paramString);
    if (localt == null)
    {
      if (paramBoolean2)
      {
        localt = new t(paramString, this, paramBoolean1);
        this.qd.put(paramString, localt);
      }
      return localt;
    }
    localt.ph = this;
    return localt;
  }
  
  public void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public boolean aS()
  {
    return true;
  }
  
  public void aT() {}
  
  final android.support.v4.e.i<String, s> aU()
  {
    int j = 0;
    int k;
    if (this.qd != null)
    {
      int m = this.qd.size();
      t[] arrayOft = new t[m];
      int i = m - 1;
      while (i >= 0)
      {
        arrayOft[i] = ((t)this.qd.valueAt(i));
        i -= 1;
      }
      i = 0;
      k = i;
      if (j < m)
      {
        t localt = arrayOft[j];
        if (localt.pp) {
          i = 1;
        }
        for (;;)
        {
          j += 1;
          break;
          localt.bi();
          this.qd.remove(localt.oV);
        }
      }
    }
    else
    {
      k = 0;
    }
    if (k != 0) {
      return this.qd;
    }
    return null;
  }
  
  public void b(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt != -1) {
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    this.mContext.startActivity(paramIntent);
  }
  
  final void j(String paramString)
  {
    if (this.qd != null)
    {
      t localt = (t)this.qd.get(paramString);
      if ((localt != null) && (!localt.pp))
      {
        localt.bi();
        this.qd.remove(paramString);
      }
    }
  }
  
  public View onFindViewById(int paramInt)
  {
    return null;
  }
  
  public LayoutInflater onGetLayoutInflater()
  {
    return (LayoutInflater)this.mContext.getSystemService("layout_inflater");
  }
  
  public int onGetWindowAnimations()
  {
    return this.qc;
  }
  
  public boolean onHasView()
  {
    return true;
  }
  
  public boolean onHasWindowAnimations()
  {
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
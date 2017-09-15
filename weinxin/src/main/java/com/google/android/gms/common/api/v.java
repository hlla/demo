package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.l;
import android.support.v4.app.p;
import android.support.v4.app.s;
import android.support.v4.app.s.a;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public final class v
  extends Fragment
  implements DialogInterface.OnCancelListener, s.a<ConnectionResult>
{
  private boolean aok;
  private int aol = -1;
  private ConnectionResult aom;
  private final Handler aon = new Handler(Looper.getMainLooper());
  public final SparseArray<b> aoo = new SparseArray();
  
  public static v c(FragmentActivity paramFragmentActivity)
  {
    w.V("Must be called from main thread of process");
    l locall = paramFragmentActivity.aR();
    try
    {
      v localv = (v)locall.k("GmsSupportLoaderLifecycleFragment");
      if (localv != null)
      {
        paramFragmentActivity = localv;
        if (!localv.pb) {}
      }
      else
      {
        paramFragmentActivity = new v();
        locall.aV().a(paramFragmentActivity, "GmsSupportLoaderLifecycleFragment").commit();
        locall.executePendingTransactions();
      }
      return paramFragmentActivity;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", paramFragmentActivity);
    }
  }
  
  public final android.support.v4.content.c<ConnectionResult> K(int paramInt)
  {
    return new a(aG(), ((b)this.aoo.get(paramInt)).aoq);
  }
  
  public final void a(int paramInt, ConnectionResult paramConnectionResult)
  {
    Object localObject = (b)this.aoo.get(paramInt);
    if (localObject != null)
    {
      this.aoo.remove(paramInt);
      aI().destroyLoader(paramInt);
      localObject = ((b)localObject).aor;
      if (localObject != null) {
        ((c.c)localObject).a(paramConnectionResult);
      }
    }
    jL();
  }
  
  public final a bU(int paramInt)
  {
    try
    {
      a locala = (a)aI().J(paramInt);
      return locala;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", localClassCastException);
    }
  }
  
  public final void jL()
  {
    int i = 0;
    this.aok = false;
    this.aol = -1;
    this.aom = null;
    s locals = aI();
    while (i < this.aoo.size())
    {
      int j = this.aoo.keyAt(i);
      a locala = bU(j);
      if ((locala != null) && (locala.aov))
      {
        locals.destroyLoader(j);
        locals.a(j, this);
      }
      i += 1;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label66;
      }
      jL();
      return;
      if (e.w(aG()) != 0) {
        break;
      }
      paramInt1 = i;
      continue;
      if (paramInt2 != -1) {
        break;
      }
      paramInt1 = i;
    }
    label66:
    a(this.aol, this.aom);
  }
  
  public final void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    int i = 0;
    if (i < this.aoo.size())
    {
      int j = this.aoo.keyAt(i);
      paramActivity = bU(j);
      if ((paramActivity != null) && (((b)this.aoo.valueAt(i)).aoq != paramActivity.aoq)) {
        aI().b(j, this);
      }
      for (;;)
      {
        i += 1;
        break;
        aI().a(j, this);
      }
    }
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    a(this.aol, new ConnectionResult(13, null));
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.aok = paramBundle.getBoolean("resolving_error", false);
      this.aol = paramBundle.getInt("failed_client_id", -1);
      if (this.aol >= 0) {
        this.aom = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.aok);
    if (this.aol >= 0)
    {
      paramBundle.putInt("failed_client_id", this.aol);
      paramBundle.putInt("failed_status", this.aom.alZ);
      paramBundle.putParcelable("failed_resolution", this.aom.ama);
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    if (!this.aok)
    {
      int i = 0;
      while (i < this.aoo.size())
      {
        aI().a(this.aoo.keyAt(i), this);
        i += 1;
      }
    }
  }
  
  public static final class a
    extends android.support.v4.content.c<ConnectionResult>
    implements c.b, c.c
  {
    public final c aoq;
    boolean aov;
    private ConnectionResult aow;
    
    public a(Context paramContext, c paramc)
    {
      super();
      this.aoq = paramc;
    }
    
    private void g(ConnectionResult paramConnectionResult)
    {
      this.aow = paramConnectionResult;
      if ((this.ny) && (!this.tu)) {
        deliverResult(paramConnectionResult);
      }
    }
    
    public final void a(ConnectionResult paramConnectionResult)
    {
      this.aov = true;
      g(paramConnectionResult);
    }
    
    public final void bR(int paramInt) {}
    
    public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      this.aoq.a(paramString, paramPrintWriter);
    }
    
    public final void g(Bundle paramBundle)
    {
      this.aov = false;
      g(ConnectionResult.alY);
    }
    
    protected final void onReset()
    {
      this.aow = null;
      this.aov = false;
      this.aoq.b(this);
      this.aoq.b(this);
      this.aoq.disconnect();
    }
    
    protected final void onStartLoading()
    {
      super.onStartLoading();
      this.aoq.a(this);
      this.aoq.a(this);
      if (this.aow != null) {
        deliverResult(this.aow);
      }
      if ((!this.aoq.isConnected()) && (!this.aoq.isConnecting()) && (!this.aov)) {
        this.aoq.connect();
      }
    }
    
    protected final void onStopLoading()
    {
      this.aoq.disconnect();
    }
  }
  
  private static final class b
  {
    public final c aoq;
    public final c.c aor;
    
    public b(c paramc, c.c paramc1)
    {
      this.aoq = paramc;
      this.aor = paramc1;
    }
  }
  
  private final class c
    implements Runnable
  {
    private final int aot;
    private final ConnectionResult aou;
    
    public c(int paramInt, ConnectionResult paramConnectionResult)
    {
      this.aot = paramInt;
      this.aou = paramConnectionResult;
    }
    
    public final void run()
    {
      if (this.aou.jf()) {
        try
        {
          int i = v.this.aG().aR().aW().indexOf(v.this);
          this.aou.a(v.this.aG(), (i + 1 << 16) + 1);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          v.this.jL();
          return;
        }
      }
      if (e.bP(this.aou.alZ))
      {
        e.a(this.aou.alZ, v.this.aG(), v.this, v.this);
        return;
      }
      v.this.a(this.aot, this.aou);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/api/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
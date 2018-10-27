package com.google.android.finsky.cz;

import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.CreateNdefMessageCallback;
import android.nfc.NfcEvent;
import android.support.v4.app.Fragment;
import com.google.android.finsky.pagesystem.b;
import com.google.common.base.l;
import com.google.common.base.u;

public final class a
  implements CreateNdefMessageCallback
{
  private final b a;
  private boolean b;
  private final u c;
  private final String d;
  
  public a(b paramb, String paramString)
  {
    this.a = paramb;
    this.d = paramString;
    this.b = true;
    this.c = u.c(NfcAdapter.getDefaultAdapter(this.a.j()));
    if (this.c.a()) {
      ((NfcAdapter)this.c.b()).setNdefPushMessageCallback(this, this.a.j(), new Activity[0]);
    }
  }
  
  /* Error */
  private final boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/google/android/finsky/cz/a:b	Z
    //   6: ifeq +41 -> 47
    //   9: aload_0
    //   10: getfield 21	com/google/android/finsky/cz/a:a	Lcom/google/android/finsky/pagesystem/b;
    //   13: invokevirtual 62	com/google/android/finsky/pagesystem/b:at	()Z
    //   16: ifeq +31 -> 47
    //   19: aload_0
    //   20: getfield 44	com/google/android/finsky/cz/a:c	Lcom/google/common/base/u;
    //   23: invokevirtual 47	com/google/common/base/u:a	()Z
    //   26: ifeq +21 -> 47
    //   29: aload_0
    //   30: getfield 23	com/google/android/finsky/cz/a:d	Ljava/lang/String;
    //   33: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: istore_1
    //   37: iload_1
    //   38: ifne +9 -> 47
    //   41: iconst_1
    //   42: istore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_1
    //   46: ireturn
    //   47: iconst_0
    //   48: istore_1
    //   49: goto -6 -> 43
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	a
    //   36	13	1	bool	boolean
    //   52	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	52	finally
  }
  
  public final void a()
  {
    try
    {
      this.b = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b()
  {
    try
    {
      this.b = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void c()
  {
    try
    {
      this.b = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final NdefMessage createNdefMessage(NfcEvent paramNfcEvent)
  {
    if (d())
    {
      paramNfcEvent = this.d.getBytes(l.c);
      int i = paramNfcEvent.length;
      byte[] arrayOfByte = new byte[i + 1];
      System.arraycopy(paramNfcEvent, 0, arrayOfByte, 1, i);
      return new NdefMessage(new NdefRecord[] { new NdefRecord(1, new byte[] { 85 }, new byte[0], arrayOfByte) });
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cz/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
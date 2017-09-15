package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;
import java.util.List;

public final class ao
{
  public static boolean fYA;
  private TelephonyManager usX;
  private PhoneStateListener usY;
  public List<a> usZ;
  
  public ao()
  {
    GMTrace.i(13940792754176L, 103867);
    this.usZ = new LinkedList();
    GMTrace.o(13940792754176L, 103867);
  }
  
  public static boolean oS()
  {
    GMTrace.i(18799206072320L, 140065);
    v.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", new Object[] { Boolean.valueOf(fYA) });
    boolean bool = fYA;
    GMTrace.o(18799206072320L, 140065);
    return bool;
  }
  
  public final void a(a parama)
  {
    GMTrace.i(13940926971904L, 103868);
    this.usZ.add(parama);
    GMTrace.o(13940926971904L, 103868);
  }
  
  public final void ek(Context paramContext)
  {
    GMTrace.i(13941061189632L, 103869);
    v.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
    if (this.usX == null) {
      this.usX = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
    if (this.usY == null) {
      this.usY = new PhoneStateListener()
      {
        public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
        {
          GMTrace.i(13926565675008L, 103761);
          v.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (ao.this.usZ.size() > 0)
          {
            ao.a[] arrayOfa = new ao.a[ao.this.usZ.size()];
            arrayOfa = (ao.a[])ao.this.usZ.toArray(arrayOfa);
            int j = arrayOfa.length;
            int i = 0;
            while (i < j)
            {
              arrayOfa[i].dL(paramAnonymousInt);
              i += 1;
            }
          }
          super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            GMTrace.o(13926565675008L, 103761);
            return;
            ao.fYA = false;
            GMTrace.o(13926565675008L, 103761);
            return;
            ao.fYA = true;
          }
        }
      };
    }
    this.usX.listen(this.usY, 32);
    GMTrace.o(13941061189632L, 103869);
  }
  
  public static abstract interface a
  {
    public abstract void dL(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
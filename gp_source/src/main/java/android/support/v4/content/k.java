package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class k
{
  private static k d;
  private static final Object e = new Object();
  private final HashMap a = new HashMap();
  private final Context b;
  private final Handler c;
  private final ArrayList f = new ArrayList();
  private final HashMap g = new HashMap();
  
  private k(Context paramContext)
  {
    this.b = paramContext;
    this.c = new l(this, paramContext.getMainLooper());
  }
  
  public static k a(Context paramContext)
  {
    synchronized (e)
    {
      if (d != null)
      {
        paramContext = d;
        return paramContext;
      }
      d = new k(paramContext.getApplicationContext());
    }
  }
  
  public final void a()
  {
    synchronized (this.g)
    {
      int i = this.f.size();
      if (i > 0)
      {
        m[] arrayOfm = new m[i];
        this.f.toArray(arrayOfm);
        this.f.clear();
        i = 0;
        while (i < arrayOfm.length)
        {
          ??? = arrayOfm[i];
          int k = ???.b.size();
          int j = 0;
          while (j < k)
          {
            n localn = (n)???.b.get(j);
            if (!localn.b) {
              localn.d.onReceive(this.b, ???.a);
            }
            j += 1;
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public final void a(BroadcastReceiver paramBroadcastReceiver)
  {
    for (;;)
    {
      int j;
      ArrayList localArrayList2;
      int k;
      synchronized (this.g)
      {
        ArrayList localArrayList1 = (ArrayList)this.g.remove(paramBroadcastReceiver);
        if (localArrayList1 == null) {
          break label196;
        }
        int i = localArrayList1.size() - 1;
        if (i < 0) {
          break label192;
        }
        n localn1 = (n)localArrayList1.get(i);
        localn1.b = true;
        j = 0;
        if (j >= localn1.c.countActions())
        {
          i -= 1;
          continue;
        }
        String str = localn1.c.getAction(j);
        localArrayList2 = (ArrayList)this.a.get(str);
        if (localArrayList2 == null) {
          break label200;
        }
        k = localArrayList2.size() - 1;
        if (k < 0)
        {
          if (localArrayList2.size() > 0) {
            break label200;
          }
          this.a.remove(str);
        }
      }
      n localn2 = (n)localArrayList2.get(k);
      if (localn2.d == paramBroadcastReceiver)
      {
        localn2.b = true;
        localArrayList2.remove(k);
        break label207;
        label192:
        return;
        label196:
        return;
        label200:
        j += 1;
        continue;
      }
      label207:
      k -= 1;
    }
  }
  
  public final void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    synchronized (this.g)
    {
      n localn = new n(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.g.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList(1);
        this.g.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(localn);
      int i = 0;
      while (i < paramIntentFilter.countActions())
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.a.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new ArrayList(1);
          this.a.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localn);
        i += 1;
      }
      return;
    }
  }
  
  public final boolean a(Intent paramIntent)
  {
    for (;;)
    {
      String str2;
      String str3;
      int j;
      label79:
      Object localObject2;
      int k;
      StringBuilder localStringBuilder;
      synchronized (this.g)
      {
        String str1 = paramIntent.getAction();
        str2 = paramIntent.resolveTypeIfNeeded(this.b.getContentResolver());
        Uri localUri = paramIntent.getData();
        str3 = paramIntent.getScheme();
        Set localSet = paramIntent.getCategories();
        j = paramIntent.getFlags() & 0x8;
        if (j != 0) {
          break label446;
        }
        ArrayList localArrayList = (ArrayList)this.a.get(paramIntent.getAction());
        if (localArrayList == null) {
          return false;
        }
        if (j == 0) {
          break label604;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Action list: ");
        ((StringBuilder)localObject1).append(localArrayList);
        Log.v("LocalBroadcastManager", ((StringBuilder)localObject1).toString());
        localObject1 = null;
        i = 0;
        if (i >= localArrayList.size()) {
          break label594;
        }
        localObject2 = (n)localArrayList.get(i);
        if (j != 0) {
          break label332;
        }
        if (((n)localObject2).a) {
          break label317;
        }
        k = ((n)localObject2).c.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
        if (k < 0)
        {
          if (j != 0) {
            break label523;
          }
          break label516;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("  Filter did not match: ");
          localStringBuilder.append((String)localObject2);
          Log.v("LocalBroadcastManager", localStringBuilder.toString());
        }
        else
        {
          if (j != 0)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("  Filter matched!  match=0x");
            localStringBuilder.append(Integer.toHexString(k));
            Log.v("LocalBroadcastManager", localStringBuilder.toString());
          }
          if (localObject1 == null)
          {
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(localObject2);
            ((n)localObject2).a = true;
          }
        }
      }
      continue;
      label317:
      if (j != 0)
      {
        Log.v("LocalBroadcastManager", "  Filter's target already added");
        break label516;
        label332:
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Matching against filter ");
        localStringBuilder.append(((n)localObject2).c);
        Log.v("LocalBroadcastManager", localStringBuilder.toString());
        continue;
      }
      for (;;)
      {
        if (i >= ((ArrayList)localObject1).size())
        {
          this.f.add(new m(paramIntent, (ArrayList)localObject1));
          if (!this.c.hasMessages(1)) {
            this.c.sendEmptyMessage(1);
          }
          return true;
        }
        ((n)((ArrayList)localObject1).get(i)).a = false;
        i += 1;
        continue;
        label446:
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Resolving type ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(" scheme ");
        ((StringBuilder)localObject1).append(str3);
        ((StringBuilder)localObject1).append(" of intent ");
        ((StringBuilder)localObject1).append(paramIntent);
        Log.v("LocalBroadcastManager", ((StringBuilder)localObject1).toString());
        break;
        for (;;)
        {
          label516:
          i += 1;
          break;
          switch (k)
          {
          default: 
            localObject2 = "unknown reason";
            break;
          case -1: 
            localObject2 = "type";
            break;
          case -2: 
            localObject2 = "data";
            break;
          case -3: 
            localObject2 = "action";
            break;
          case -4: 
            label523:
            localObject2 = "category";
            break;
          }
        }
        label594:
        if (localObject1 == null) {
          break label79;
        }
        i = 0;
      }
      label604:
      Object localObject1 = null;
      int i = 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
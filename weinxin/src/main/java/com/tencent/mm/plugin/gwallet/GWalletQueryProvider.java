package com.tencent.mm.plugin.gwallet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.b.c;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class GWalletQueryProvider
  extends ContentProvider
{
  public static final String[] tl;
  private final String TAG;
  private Context mContext;
  private b mIK;
  private boolean mIL;
  private boolean mIM;
  private ArrayList<String> mIN;
  private ArrayList<String> mIO;
  private int mIP;
  
  static
  {
    GMTrace.i(8970978721792L, 66839);
    tl = new String[] { "_id", "product_id", "full_price", "product_state", "price_currency", "price_amount" };
    GMTrace.o(8970978721792L, 66839);
  }
  
  public GWalletQueryProvider()
  {
    GMTrace.i(8969099673600L, 66825);
    this.TAG = "MicroMsg.GWalletQueryProvider";
    this.mIK = null;
    this.mContext = null;
    GMTrace.o(8969099673600L, 66825);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(8969233891328L, 66826);
    GMTrace.o(8969233891328L, 66826);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    GMTrace.i(8969368109056L, 66827);
    GMTrace.o(8969368109056L, 66827);
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    GMTrace.i(8969502326784L, 66828);
    GMTrace.o(8969502326784L, 66828);
    return null;
  }
  
  public boolean onCreate()
  {
    GMTrace.i(8969636544512L, 66829);
    v.d("MicroMsg.GWalletQueryProvider", "successfully loaded");
    GMTrace.o(8969636544512L, 66829);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    GMTrace.i(8969770762240L, 66830);
    try
    {
      v.d("MicroMsg.GWalletQueryProvider", "Creating IAB helper.");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
      {
        v.d("MicroMsg.GWalletQueryProvider", "no product id selected or size is 0");
        throw new IllegalArgumentException("no product id selected or size is 0");
      }
    }
    finally {}
    this.mContext = getContext();
    this.mIK = new b(this.mContext);
    this.mIL = true;
    this.mIM = false;
    this.mIO = new ArrayList();
    int j = paramArrayOfString2.length;
    int i = 0;
    while (i < j)
    {
      paramUri = paramArrayOfString2[i];
      this.mIO.add(paramUri);
      i += 1;
    }
    v.d("MicroMsg.GWalletQueryProvider", "Starting setup.");
    this.mIK.a(new b.a()
    {
      public final void a(c paramAnonymousc)
      {
        GMTrace.i(8968965455872L, 66824);
        v.d("MicroMsg.GWalletQueryProvider", "Setup finished.");
        if (!paramAnonymousc.isSuccess())
        {
          v.e("MicroMsg.GWalletQueryProvider", "Problem setting up in-app billing: " + paramAnonymousc);
          GWalletQueryProvider.a(GWalletQueryProvider.this);
          if (GWalletQueryProvider.b(GWalletQueryProvider.this) != null) {
            GWalletQueryProvider.b(GWalletQueryProvider.this).dispose();
          }
          GWalletQueryProvider.c(GWalletQueryProvider.this);
          GMTrace.o(8968965455872L, 66824);
          return;
        }
        ap.vL().a(new ae.a()
        {
          public final boolean Bn()
          {
            GMTrace.i(8967891714048L, 66816);
            GWalletQueryProvider.d(GWalletQueryProvider.this);
            GMTrace.o(8967891714048L, 66816);
            return true;
          }
          
          public final boolean Bo()
          {
            GMTrace.i(8968025931776L, 66817);
            if (GWalletQueryProvider.b(GWalletQueryProvider.this) != null) {
              GWalletQueryProvider.b(GWalletQueryProvider.this).dispose();
            }
            GWalletQueryProvider.c(GWalletQueryProvider.this);
            GMTrace.o(8968025931776L, 66817);
            return true;
          }
          
          public final String toString()
          {
            GMTrace.i(8968160149504L, 66818);
            String str = super.toString() + "|onIabSetupFinished";
            GMTrace.o(8968160149504L, 66818);
            return str;
          }
        });
        GMTrace.o(8968965455872L, 66824);
      }
    });
    long l = 0L;
    boolean bool;
    while ((l <= 30000L) && (this.mIL))
    {
      bool = this.mIM;
      if (bool) {
        break;
      }
      try
      {
        Thread.sleep(100L);
        l += 100L;
      }
      catch (InterruptedException paramUri)
      {
        v.e("MicroMsg.GWalletQueryProvider", paramUri.toString());
      }
    }
    if (!this.mIL)
    {
      v.d("MicroMsg.GWalletQueryProvider", "unable to setup");
      paramUri = new MatrixCursor(tl);
      paramArrayOfString1 = this.mIO.iterator();
      while (paramArrayOfString1.hasNext()) {
        paramUri.addRow(new Object[] { Integer.valueOf(0), (String)paramArrayOfString1.next(), "", Integer.valueOf(10234), "", "" });
      }
      GMTrace.o(8969770762240L, 66830);
      return paramUri;
    }
    if (l > 30000L)
    {
      v.d("MicroMsg.GWalletQueryProvider", "time's out");
      paramUri = new MatrixCursor(tl);
      paramArrayOfString1 = this.mIO.iterator();
      while (paramArrayOfString1.hasNext()) {
        paramUri.addRow(new Object[] { Integer.valueOf(0), (String)paramArrayOfString1.next(), "", Integer.valueOf(10235), "", "" });
      }
      GMTrace.o(8969770762240L, 66830);
      return paramUri;
    }
    v.d("MicroMsg.GWalletQueryProvider", "successfully queried!");
    paramArrayOfString1 = new MatrixCursor(tl);
    if (this.mIP == 0)
    {
      i = 0;
      if (this.mIN != null)
      {
        paramString1 = this.mIN.iterator();
        i = 0;
        for (;;)
        {
          if (!paramString1.hasNext()) {
            break label818;
          }
          paramUri = (String)paramString1.next();
          bool = bf.mA(paramUri);
          if (bool) {
            break label815;
          }
          try
          {
            localObject = new JSONObject(paramUri);
            paramUri = ((JSONObject)localObject).getString("productId");
            paramArrayOfString2 = ((JSONObject)localObject).getString("price");
            paramString2 = ((JSONObject)localObject).getString("price_currency_code");
            localObject = ((JSONObject)localObject).getString("price_amount_micros");
            j = i + 1;
          }
          catch (JSONException paramUri)
          {
            try
            {
              Object localObject;
              paramArrayOfString1.addRow(new Object[] { Integer.valueOf(i), paramUri, paramArrayOfString2, Integer.valueOf(10232), paramString2, localObject });
              this.mIO.remove(paramUri);
              i = j;
            }
            catch (JSONException paramUri)
            {
              for (;;)
              {
                i = j;
              }
            }
            paramUri = paramUri;
          }
        }
        v.d("MicroMsg.GWalletQueryProvider", paramUri.toString());
        break label815;
      }
    }
    label815:
    label818:
    for (;;)
    {
      paramUri = this.mIO.iterator();
      while (paramUri.hasNext())
      {
        paramArrayOfString1.addRow(new Object[] { Integer.valueOf(i), (String)paramUri.next(), "", Integer.valueOf(10233), "", "" });
        i += 1;
        continue;
        paramUri = this.mIO.iterator();
        while (paramUri.hasNext()) {
          paramArrayOfString1.addRow(new Object[] { Integer.valueOf(0), (String)paramUri.next(), "", Integer.valueOf(10236), "", "" });
        }
      }
      GMTrace.o(8969770762240L, 66830);
      return paramArrayOfString1;
      break;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(8969904979968L, 66831);
    GMTrace.o(8969904979968L, 66831);
    return 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/gwallet/GWalletQueryProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.f.a;

public class CdnImageView
  extends MMImageView
  implements a
{
  private ad handler;
  private int lIv;
  private int ndh;
  private String sKx;
  public boolean sKy;
  private String url;
  
  public CdnImageView(Context paramContext)
  {
    this(paramContext, null);
    GMTrace.i(943282192384L, 7028);
    GMTrace.o(943282192384L, 7028);
  }
  
  public CdnImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(943416410112L, 7029);
    GMTrace.o(943416410112L, 7029);
  }
  
  public CdnImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(943550627840L, 7030);
    this.url = null;
    this.handler = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(941537361920L, 7015);
        Object localObject = bf.ap(paramAnonymousMessage.getData().getString("k_url"), "");
        CdnImageView.a(CdnImageView.this, bf.ap(CdnImageView.a(CdnImageView.this), ""));
        if ((bf.mA(CdnImageView.a(CdnImageView.this))) && (bf.mA((String)localObject)))
        {
          CdnImageView.this.setImageBitmap(null);
          CdnImageView.this.u(null);
          GMTrace.o(941537361920L, 7015);
          return;
        }
        if (!CdnImageView.a(CdnImageView.this).equals(localObject))
        {
          v.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
          GMTrace.o(941537361920L, 7015);
          return;
        }
        paramAnonymousMessage = paramAnonymousMessage.getData().getByteArray("k_data");
        if ((paramAnonymousMessage == null) || (paramAnonymousMessage.length == 0))
        {
          v.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
          GMTrace.o(941537361920L, 7015);
          return;
        }
        localObject = d.bd(paramAnonymousMessage);
        n.GS();
        b.f(CdnImageView.a(CdnImageView.this), (Bitmap)localObject);
        paramAnonymousMessage = (Message)localObject;
        if (localObject != null)
        {
          paramAnonymousMessage = (Message)localObject;
          if (CdnImageView.b(CdnImageView.this) > 0)
          {
            paramAnonymousMessage = (Message)localObject;
            if (CdnImageView.c(CdnImageView.this) > 0) {
              paramAnonymousMessage = d.a((Bitmap)localObject, CdnImageView.c(CdnImageView.this), CdnImageView.b(CdnImageView.this), true, false);
            }
          }
        }
        if ((paramAnonymousMessage != null) && (!bf.mA(CdnImageView.d(CdnImageView.this)))) {}
        try
        {
          d.a(paramAnonymousMessage, 100, Bitmap.CompressFormat.JPEG, CdnImageView.d(CdnImageView.this), false);
          localObject = paramAnonymousMessage;
          if (CdnImageView.e(CdnImageView.this))
          {
            localObject = paramAnonymousMessage;
            if (paramAnonymousMessage != null) {
              localObject = d.a(paramAnonymousMessage, false, paramAnonymousMessage.getWidth() * 0.5F);
            }
          }
          CdnImageView.this.setImageBitmap((Bitmap)localObject);
          CdnImageView.this.u((Bitmap)localObject);
          GMTrace.o(941537361920L, 7015);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.e("MicroMsg.CdnImageView", "save image failed, %s", new Object[] { localException.getMessage() });
          }
        }
      }
    };
    GMTrace.o(943550627840L, 7030);
  }
  
  public final void K(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(14460081143808L, 107736);
    L(paramString, paramInt1, paramInt2);
    GMTrace.o(14460081143808L, 107736);
  }
  
  public void L(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(943819063296L, 7032);
    this.url = paramString;
    this.ndh = paramInt1;
    this.lIv = paramInt2;
    this.sKx = null;
    Bitmap localBitmap;
    if (!bf.mA(this.sKx))
    {
      localBitmap = d.Pf(this.sKx);
      if ((localBitmap != null) && (localBitmap.getWidth() > 0) && (localBitmap.getHeight() > 0))
      {
        setImageBitmap(localBitmap);
        u(localBitmap);
        GMTrace.o(943819063296L, 7032);
        return;
      }
    }
    if ((paramString == null) || (paramString.length() == 0))
    {
      setVisibility(8);
      GMTrace.o(943819063296L, 7032);
      return;
    }
    if (paramString.startsWith("http"))
    {
      n.GS();
      localBitmap = b.gS(paramString);
      if (localBitmap != null)
      {
        paramString = localBitmap;
        if (this.ndh > 0)
        {
          paramString = localBitmap;
          if (this.lIv > 0) {
            paramString = d.a(localBitmap, this.ndh, this.lIv, true, false);
          }
        }
        setImageBitmap(paramString);
        u(paramString);
        GMTrace.o(943819063296L, 7032);
        return;
      }
      com.tencent.mm.sdk.f.e.post(new a(paramString, this.handler), "CdnImageView_download");
      GMTrace.o(943819063296L, 7032);
      return;
    }
    if (!com.tencent.mm.a.e.aO(paramString))
    {
      setVisibility(8);
      GMTrace.o(943819063296L, 7032);
      return;
    }
    if ((this.ndh <= 0) || (this.lIv <= 0)) {}
    for (paramString = d.Pf(paramString); paramString == null; paramString = d.d(paramString, this.ndh, this.lIv, true))
    {
      setVisibility(8);
      GMTrace.o(943819063296L, 7032);
      return;
    }
    setImageBitmap(paramString);
    u(paramString);
    GMTrace.o(943819063296L, 7032);
  }
  
  public void u(Bitmap paramBitmap)
  {
    GMTrace.i(943684845568L, 7031);
    GMTrace.o(943684845568L, 7031);
  }
  
  static final class a
    implements Runnable
  {
    private ad handler;
    private String url;
    
    a(String paramString, ad paramad)
    {
      GMTrace.i(965428117504L, 7193);
      this.url = paramString;
      this.handler = paramad;
      GMTrace.o(965428117504L, 7193);
    }
    
    public final void run()
    {
      GMTrace.i(965562335232L, 7194);
      byte[] arrayOfByte = bf.Qb(this.url);
      Message localMessage = Message.obtain();
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("k_data", arrayOfByte);
      localBundle.putString("k_url", this.url);
      localMessage.setData(localBundle);
      this.handler.sendMessage(localMessage);
      GMTrace.o(965562335232L, 7194);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/CdnImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
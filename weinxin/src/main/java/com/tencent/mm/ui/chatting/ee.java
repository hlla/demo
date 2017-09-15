package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.e.a.nd.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.b;

public final class ee
  extends com.tencent.mm.sdk.b.c<nd>
{
  public Activity activity;
  private a vMi;
  
  public ee(a parama, Activity paramActivity)
  {
    super(0);
    GMTrace.i(2291767705600L, 17075);
    this.vMi = null;
    this.activity = null;
    this.vMi = parama;
    this.activity = paramActivity;
    this.uqt = nd.class.getName().hashCode();
    GMTrace.o(2291767705600L, 17075);
  }
  
  private boolean a(nd paramnd)
  {
    GMTrace.i(2291901923328L, 17076);
    long l;
    String str;
    Object localObject;
    if ((this.vMi != null) && (paramnd != null) && ((paramnd instanceof nd)))
    {
      l = paramnd.fUc.fGD;
      str = paramnd.fUc.fUd;
      localObject = paramnd.fUc.fUe;
      if ((localObject != null) && (((ce)localObject).field_msgId > 0L)) {
        break label586;
      }
    }
    label409:
    label586:
    for (paramnd = paramnd.fUc.fUe;; paramnd = (nd)localObject)
    {
      if (paramnd == null)
      {
        v.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        GMTrace.o(2291901923328L, 17076);
        return false;
      }
      switch (paramnd.field_type)
      {
      }
      for (;;)
      {
        GMTrace.o(2291901923328L, 17076);
        return false;
        switch (3.vMk[this.vMi.ordinal()])
        {
        default: 
          break;
        case 1: 
          if ((paramnd != null) && (paramnd.field_msgId > 0L)) {
            localObject = com.tencent.mm.modelcdntran.d.a("downimg", paramnd.field_createTime, paramnd.field_talker, paramnd.field_msgId);
          }
          try
          {
            com.tencent.mm.modelcdntran.g.Em().iQ((String)localObject);
            v.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", new Object[] { Boolean.valueOf(true) });
            ap.vd().cancel(109);
            paramnd = com.tencent.mm.ui.chatting.gallery.d.bg(paramnd);
            com.tencent.mm.ah.n.GU().e(paramnd.hEG, l);
            if ((this.activity == null) || (!(this.activity instanceof ImageGalleryUI))) {
              continue;
            }
            paramnd = (ImageGalleryUI)this.activity;
            v.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramnd.fGD) });
            if (l != paramnd.fGD) {
              continue;
            }
            com.tencent.mm.ui.base.g.a(this.activity, str, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(2109231595520L, 15715);
                paramAnonymousDialogInterface.dismiss();
                ee.this.activity.finish();
                GMTrace.o(2109231595520L, 15715);
              }
            });
          }
          catch (Exception paramnd)
          {
            for (;;)
            {
              v.printErrStackTrace("MicroMsg.RevokeMsgListener", paramnd, "[oneliang][revokeMsgImage] cancel failure:%s", new Object[] { paramnd.getMessage() });
            }
          }
          localObject = this.vMi;
          boolean bool;
          if (Looper.myLooper() == ap.vL().nIe.getLooper())
          {
            bool = true;
            v.v("MicroMsg.RevokeMsgListener", "ashutest::revoke msg, type %s, isWorkerThread %B", new Object[] { localObject, Boolean.valueOf(bool) });
          }
          switch (3.vMk[this.vMi.ordinal()])
          {
          default: 
            break;
          case 2: 
            aQ(paramnd);
            if ((this.activity instanceof ImageGalleryUI))
            {
              localObject = (ImageGalleryUI)this.activity;
              if ((((ImageGalleryUI)localObject).vNV != null) && (b.aS(paramnd)) && (paramnd.field_msgId == ((ImageGalleryUI)localObject).vNV.bWA().field_msgId)) {}
              for (int i = 1; i != 0; i = 0)
              {
                ((ImageGalleryUI)localObject).Bz(((ImageGalleryUI)localObject).bWV());
                com.tencent.mm.ui.base.g.a(this.activity, str, "", false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    GMTrace.i(2145336164352L, 15984);
                    paramAnonymousDialogInterface.dismiss();
                    ee.this.activity.finish();
                    GMTrace.o(2145336164352L, 15984);
                  }
                });
                break;
                bool = false;
                break label409;
              }
            }
            break;
          case 3: 
            aQ(paramnd);
          }
          break;
        }
      }
    }
  }
  
  private static void aQ(au paramau)
  {
    GMTrace.i(2292036141056L, 17077);
    paramau = t.lI(paramau.field_imgPath);
    if (paramau != null)
    {
      Object localObject = com.tencent.mm.modelcdntran.d.a("downvideo", paramau.hZS, paramau.Lf(), paramau.getFileName());
      try
      {
        com.tencent.mm.modelcdntran.g.Em().iQ((String)localObject);
        v.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", new Object[] { Boolean.valueOf(true) });
        localObject = o.Lb();
        h.vd().c(((x.a)localObject).iaF);
        ((x.a)localObject).pr();
        o.KW().lu(paramau.getFileName());
        GMTrace.o(2292036141056L, 17077);
        return;
      }
      catch (Exception paramau)
      {
        v.printErrStackTrace("MicroMsg.RevokeMsgListener", paramau, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", new Object[] { paramau.getMessage() });
      }
    }
    GMTrace.o(2292036141056L, 17077);
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(2269084909568L, 16906);
      vMl = new a("CHATTING_ITEM_VIDEO", 0);
      vMm = new a("IMAGE_GALLERY_UI", 1);
      vMn = new a("VIDEO_GALLERY", 2);
      vMo = new a[] { vMl, vMm, vMn };
      GMTrace.o(2269084909568L, 16906);
    }
    
    private a()
    {
      GMTrace.i(2268950691840L, 16905);
      GMTrace.o(2268950691840L, 16905);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
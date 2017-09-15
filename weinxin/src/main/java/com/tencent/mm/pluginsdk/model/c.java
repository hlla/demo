package com.tencent.mm.pluginsdk.model;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cb.a;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.i.b;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rq;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.ry;
import com.tencent.mm.protocal.c.sc;
import com.tencent.mm.protocal.c.se;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.mm.ui.snackbar.b.c;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  public static boolean sAx;
  private static x<String, Bitmap> sAy;
  private static Map<String, Integer> ssz;
  
  static
  {
    GMTrace.i(17442130624512L, 129954);
    sAx = true;
    sAy = new x(20);
    ssz = new HashMap();
    HashMap localHashMap = new HashMap();
    ssz = localHashMap;
    localHashMap.put("avi", Integer.valueOf(R.k.dth));
    ssz.put("m4v", Integer.valueOf(R.k.dth));
    ssz.put("vob", Integer.valueOf(R.k.dth));
    ssz.put("mpeg", Integer.valueOf(R.k.dth));
    ssz.put("mpe", Integer.valueOf(R.k.dth));
    ssz.put("asx", Integer.valueOf(R.k.dth));
    ssz.put("asf", Integer.valueOf(R.k.dth));
    ssz.put("f4v", Integer.valueOf(R.k.dth));
    ssz.put("flv", Integer.valueOf(R.k.dth));
    ssz.put("mkv", Integer.valueOf(R.k.dth));
    ssz.put("wmv", Integer.valueOf(R.k.dth));
    ssz.put("wm", Integer.valueOf(R.k.dth));
    ssz.put("3gp", Integer.valueOf(R.k.dth));
    ssz.put("mp4", Integer.valueOf(R.k.dth));
    ssz.put("rmvb", Integer.valueOf(R.k.dth));
    ssz.put("rm", Integer.valueOf(R.k.dth));
    ssz.put("ra", Integer.valueOf(R.k.dth));
    ssz.put("ram", Integer.valueOf(R.k.dth));
    ssz.put("mp3pro", Integer.valueOf(R.k.dsW));
    ssz.put("vqf", Integer.valueOf(R.k.dsW));
    ssz.put("cd", Integer.valueOf(R.k.dsW));
    ssz.put("md", Integer.valueOf(R.k.dsW));
    ssz.put("mod", Integer.valueOf(R.k.dsW));
    ssz.put("vorbis", Integer.valueOf(R.k.dsW));
    ssz.put("au", Integer.valueOf(R.k.dsW));
    ssz.put("amr", Integer.valueOf(R.k.dsW));
    ssz.put("silk", Integer.valueOf(R.k.dsW));
    ssz.put("wma", Integer.valueOf(R.k.dsW));
    ssz.put("mmf", Integer.valueOf(R.k.dsW));
    ssz.put("mid", Integer.valueOf(R.k.dsW));
    ssz.put("midi", Integer.valueOf(R.k.dsW));
    ssz.put("mp3", Integer.valueOf(R.k.dsW));
    ssz.put("aac", Integer.valueOf(R.k.dsW));
    ssz.put("ape", Integer.valueOf(R.k.dsW));
    ssz.put("aiff", Integer.valueOf(R.k.dsW));
    ssz.put("aif", Integer.valueOf(R.k.dsW));
    ssz.put("jfif", Integer.valueOf(R.g.bbX));
    ssz.put("tiff", Integer.valueOf(R.g.bbX));
    ssz.put("tif", Integer.valueOf(R.g.bbX));
    ssz.put("jpe", Integer.valueOf(R.g.bbX));
    ssz.put("dib", Integer.valueOf(R.g.bbX));
    ssz.put("jpeg", Integer.valueOf(R.g.bbX));
    ssz.put("jpg", Integer.valueOf(R.g.bbX));
    ssz.put("png", Integer.valueOf(R.g.bbX));
    ssz.put("bmp", Integer.valueOf(R.g.bbX));
    ssz.put("gif", Integer.valueOf(R.g.bbX));
    ssz.put("rar", Integer.valueOf(R.k.dwL));
    ssz.put("zip", Integer.valueOf(R.k.dwL));
    ssz.put("7z", Integer.valueOf(R.k.dwL));
    ssz.put("iso", Integer.valueOf(R.k.dwL));
    ssz.put("cab", Integer.valueOf(R.k.dwL));
    ssz.put("doc", Integer.valueOf(R.k.dwJ));
    ssz.put("docx", Integer.valueOf(R.k.dwJ));
    ssz.put("ppt", Integer.valueOf(R.k.dwE));
    ssz.put("pptx", Integer.valueOf(R.k.dwE));
    ssz.put("xls", Integer.valueOf(R.k.dwK));
    ssz.put("xlsx", Integer.valueOf(R.k.dwK));
    ssz.put("txt", Integer.valueOf(R.k.dwG));
    ssz.put("rtf", Integer.valueOf(R.k.dwG));
    ssz.put("pdf", Integer.valueOf(R.k.dwD));
    ssz.put("unknown", Integer.valueOf(R.k.dwH));
    GMTrace.o(17442130624512L, 129954);
  }
  
  public static int LN(String paramString)
  {
    GMTrace.i(17441727971328L, 129951);
    paramString = (Integer)ssz.get(paramString);
    if (paramString == null)
    {
      i = ((Integer)ssz.get("unknown")).intValue();
      GMTrace.o(17441727971328L, 129951);
      return i;
    }
    int i = paramString.intValue();
    GMTrace.o(17441727971328L, 129951);
    return i;
  }
  
  @TargetApi(8)
  public static Bitmap LO(String paramString)
  {
    GMTrace.i(17441862189056L, 129952);
    Bitmap localBitmap = null;
    if (com.tencent.mm.compatible.util.d.eo(8)) {
      localBitmap = ThumbnailUtils.createVideoThumbnail(paramString, 1);
    }
    GMTrace.o(17441862189056L, 129952);
    return localBitmap;
  }
  
  private static int a(cb paramcb, int paramInt)
  {
    int i = 1;
    int n = 0;
    GMTrace.i(764101525504L, 5693);
    rl localrl;
    if ((paramcb.fFr.fFt.txF != null) && (paramcb.fFr.fFt.txF.size() > 0))
    {
      localrl = (rl)paramcb.fFr.fFt.txF.getLast();
      if (paramInt > 0) {}
    }
    switch (paramInt)
    {
    default: 
      localrl.xY(0);
      if ((paramcb.fFr.fFt.txF == null) || (paramcb.fFr.fFt.txF.size() == 0)) {
        paramcb.fFr.fFx = paramInt;
      }
      break;
    }
    while (paramcb.fFr.fFx == -9)
    {
      GMTrace.o(764101525504L, 5693);
      return paramInt;
      localrl.xY(1);
      localrl.NY(null);
      break;
      localrl.xY(2);
      localrl.NY(null);
      break;
    }
    int m = i;
    if (paramInt <= 0) {
      if (paramcb.fFr.fFx <= 0) {
        break label483;
      }
    }
    label483:
    for (m = i;; m = 0)
    {
      int k = 0;
      int j = 0;
      i = 0;
      if (n < paramcb.fFr.fFt.txF.size())
      {
        int i1;
        switch (((rl)paramcb.fFr.fFt.txF.get(n)).twI)
        {
        default: 
          i1 = k;
          k = i;
          i = i1;
        }
        for (;;)
        {
          n += 1;
          i1 = k;
          k = i;
          i = i1;
          break;
          i1 = k + 1;
          k = i;
          i = i1;
          continue;
          j += 1;
          i1 = i;
          i = k;
          k = i1;
          continue;
          i1 = i + 1;
          i = k;
          k = i1;
        }
      }
      if (m > 0)
      {
        if ((j > 0) || (k > 0))
        {
          paramcb.fFr.fFx = -9;
          break;
        }
        paramcb.fFr.fFx = paramInt;
        break;
      }
      if (j > 0)
      {
        if (k > 0)
        {
          paramcb.fFr.fFx = -8;
          break;
        }
        if (i == 0)
        {
          paramcb.fFr.fFx = -5;
          break;
        }
        if (i <= 0) {
          break;
        }
        paramcb.fFr.fFx = -7;
        break;
      }
      if (k <= 0) {
        break;
      }
      if (i == 0)
      {
        paramcb.fFr.fFx = -4;
        break;
      }
      if (i <= 0) {
        break;
      }
      paramcb.fFr.fFx = -6;
      break;
    }
  }
  
  public static int a(au paramau, cb paramcb, boolean paramBoolean)
  {
    GMTrace.i(763967307776L, 5692);
    v.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[] { Integer.valueOf(paramau.field_type) });
    int i;
    if ((!paramBoolean) && (paramcb.fFr.fFx > 0))
    {
      v.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
      i = a(paramcb, paramcb.fFr.fFx);
      GMTrace.o(763967307776L, 5692);
      return i;
    }
    if ((paramcb.fFr.type == 4) || (paramcb.fFr.type == 8) || (paramcb.fFr.type == 16) || (paramcb.fFr.type == 2)) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      boolean bool = paramBoolean;
      Object localObject;
      if (paramcb.fFr.type == 14)
      {
        bool = paramBoolean;
        if (paramcb.fFr.fFt.txF.size() > 0)
        {
          localObject = (rl)paramcb.fFr.fFt.txF.getLast();
          if ((((rl)localObject).aMw != 4) && (((rl)localObject).aMw != 8) && (((rl)localObject).aMw != 15))
          {
            bool = paramBoolean;
            if (((rl)localObject).aMw != 2) {}
          }
          else
          {
            bool = false;
          }
        }
      }
      v.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        i = a(paramcb, 0);
        GMTrace.o(763967307776L, 5692);
        return i;
      }
      if (paramcb.fFr.fFt == null)
      {
        i = a(paramcb, -1);
        GMTrace.o(763967307776L, 5692);
        return i;
      }
      if (paramcb.fFr.fFt.txF == null)
      {
        i = a(paramcb, -1);
        GMTrace.o(763967307776L, 5692);
        return i;
      }
      if (System.currentTimeMillis() - paramau.field_createTime > 259200000L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        v.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[] { Boolean.valueOf(paramBoolean) });
        if (1 <= paramcb.fFr.fFt.txF.size()) {}
        for (localObject = ((rl)paramcb.fFr.fFt.txF.getLast()).tvY;; localObject = "")
        {
          if (paramBoolean)
          {
            if ((!bf.mA((String)localObject)) && (e.aO((String)localObject))) {
              break label633;
            }
            if ((paramau != null) && ((paramau.field_type == 43) || (paramau.field_type == 44) || (paramau.field_type == 62)))
            {
              localObject = t.lI(paramau.field_imgPath);
              if ((localObject != null) && (((r)localObject).iac == -1))
              {
                localObject = ((r)localObject).Lh();
                if (!e.aO((String)localObject)) {}
              }
            }
            while (bf.mA((String)localObject))
            {
              i = a(paramcb, -4);
              GMTrace.o(763967307776L, 5692);
              return i;
              localObject = null;
            }
            ((rl)paramcb.fFr.fFt.txF.getLast()).NY((String)localObject);
          }
          label633:
          for (;;)
          {
            if (a(paramau, paramcb, (String)localObject, true))
            {
              i = a(paramcb, -5);
              GMTrace.o(763967307776L, 5692);
              return i;
            }
            v.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            do
            {
              v.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
              i = a(paramcb, 0);
              GMTrace.o(763967307776L, 5692);
              return i;
            } while (!a(paramau, paramcb, (String)localObject, false));
            i = a(paramcb, -5);
            GMTrace.o(763967307776L, 5692);
            return i;
          }
        }
      }
    }
  }
  
  public static rq a(int paramInt, ru paramru, sc paramsc)
  {
    GMTrace.i(763430436864L, 5688);
    if (paramru == null)
    {
      v.w("MicroMsg.FavExportLogic", "proto item is null");
      GMTrace.o(763430436864L, 5688);
      return null;
    }
    rq localrq = new rq();
    rv localrv = paramru.txD;
    if (localrv != null)
    {
      localrq.fOl = localrv.fOl;
      localrq.txt = localrv.txi;
      localrq.appId = localrv.appId;
      localrq.fCA = localrv.fCA;
    }
    if (paramsc != null)
    {
      if (paramsc.txO != null) {
        localrq.txu.addAll(paramsc.txO);
      }
      if (paramsc.txP != null) {
        localrq.txu.addAll(paramsc.txP);
      }
    }
    localrq.fSY = paramru;
    localrq.type = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 9: 
    case 13: 
    case 16: 
    case 17: 
    default: 
      v.w("MicroMsg.FavExportLogic", "unknown type %d", new Object[] { Integer.valueOf(paramInt) });
      GMTrace.o(763430436864L, 5688);
      return localrq;
    case 1: 
      localrq.title = "";
      localrq.desc = paramru.desc;
      GMTrace.o(763430436864L, 5688);
      return localrq;
    case 4: 
      if ((paramru.txF != null) && (!paramru.txF.isEmpty())) {
        localrq.title = ((rl)paramru.txF.get(0)).title;
      }
      GMTrace.o(763430436864L, 5688);
      return localrq;
    case 5: 
      if (paramru.twQ != null)
      {
        localrq.title = paramru.twQ.title;
        localrq.desc = paramru.twQ.tyf;
      }
      if ((bf.mA(localrq.title)) && (paramru.txF != null) && (!paramru.txF.isEmpty())) {
        localrq.title = ((rl)paramru.txF.get(0)).title;
      }
      if ((bf.mA(localrq.desc)) && (localrv != null)) {
        localrq.desc = localrv.hSD;
      }
      GMTrace.o(763430436864L, 5688);
      return localrq;
    case 6: 
      localrq.title = paramru.iAN;
      if (bf.mA(localrq.title)) {
        if (paramru.twO != null)
        {
          localrq.title = paramru.twO.fRN;
          localrq.desc = paramru.twO.label;
        }
      }
      for (;;)
      {
        GMTrace.o(763430436864L, 5688);
        return localrq;
        if (paramru.twO != null) {
          localrq.desc = paramru.twO.fRN;
        }
      }
    case 2: 
      if ((paramru.txF != null) && (paramru.txF.size() > 0)) {
        localrq.title = ((rl)paramru.txF.get(0)).title;
      }
      GMTrace.o(763430436864L, 5688);
      return localrq;
    case 7: 
      if ((paramru.txF != null) && (!paramru.txF.isEmpty()))
      {
        localrq.title = ((rl)paramru.txF.get(0)).title;
        localrq.desc = ((rl)paramru.txF.get(0)).desc;
      }
      GMTrace.o(763430436864L, 5688);
      return localrq;
    case 8: 
      localrq.title = paramru.title;
      if ((bf.mA(localrq.title)) && (paramru.txF != null) && (!paramru.txF.isEmpty())) {
        localrq.title = ((rl)paramru.txF.get(0)).title;
      }
      GMTrace.o(763430436864L, 5688);
      return localrq;
    case 10: 
    case 11: 
      if (paramru.twS != null)
      {
        localrq.title = paramru.twS.title;
        localrq.desc = paramru.twS.desc;
      }
      GMTrace.o(763430436864L, 5688);
      return localrq;
    case 12: 
    case 15: 
      if (paramru.twU != null)
      {
        localrq.title = paramru.twU.title;
        localrq.desc = paramru.twU.desc;
      }
      GMTrace.o(763430436864L, 5688);
      return localrq;
    }
    paramru = paramru.txF;
    if (paramru == null)
    {
      GMTrace.o(763430436864L, 5688);
      return null;
    }
    paramru = paramru.iterator();
    while (paramru.hasNext())
    {
      paramsc = (rl)paramru.next();
      if (1 == paramsc.aMw) {
        localrq.title = paramsc.desc;
      }
    }
    GMTrace.o(763430436864L, 5688);
    return localrq;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, Activity paramActivity, final Fragment paramFragment, final b.c paramc, final DialogInterface.OnClickListener paramOnClickListener, final b.b paramb)
  {
    GMTrace.i(763833090048L, 5691);
    if ((paramActivity == null) && (paramFragment == null))
    {
      v.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
      GMTrace.o(763833090048L, 5691);
      return;
    }
    if (paramb == null) {}
    for (final Object localObject1 = new b.b()
        {
          public final void aAm()
          {
            GMTrace.i(17440788447232L, 129944);
            fp localfp = new fp();
            localfp.fKg.type = 35;
            com.tencent.mm.sdk.b.a.uql.m(localfp);
            GMTrace.o(17440788447232L, 129944);
          }
        };; localObject1 = paramb)
    {
      if (paramInt2 == 0)
      {
        if (paramFragment != null)
        {
          com.tencent.mm.ui.snackbar.a.a(paramInt3, paramFragment, paramFragment.getString(R.l.eiG), paramFragment.getString(R.l.ehr), (b.b)localObject1, paramc);
          GMTrace.o(763833090048L, 5691);
          return;
        }
        if (paramActivity != null)
        {
          com.tencent.mm.ui.snackbar.a.a(paramInt3, paramActivity, paramActivity.getString(R.l.eiG), paramActivity.getString(R.l.ehr), (b.b)localObject1, paramc);
          GMTrace.o(763833090048L, 5691);
        }
      }
      else
      {
        if (paramActivity != null) {
          break label668;
        }
      }
      label483:
      label668:
      for (paramb = paramFragment.aG();; paramb = paramActivity)
      {
        switch (paramInt2)
        {
        case -3: 
        default: 
          g.a(paramb, paramInt2, 0, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(16686350598144L, 124323);
              if (this.sAz != null) {
                this.sAz.onClick(paramAnonymousDialogInterface, -1);
              }
              GMTrace.o(16686350598144L, 124323);
            }
          });
          GMTrace.o(763833090048L, 5691);
          return;
        case -2: 
          g.a(paramb, paramb.getString(R.l.ehV), paramb.getString(R.l.ehW), paramb.getString(R.l.ehY), paramb.getString(R.l.dXa), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(16686082162688L, 124321);
              Intent localIntent = new Intent();
              localIntent.putExtra("key_enter_fav_cleanui_from", 3);
              com.tencent.mm.bb.d.b(this.val$context, "favorite", ".ui.FavCleanUI", localIntent);
              paramAnonymousDialogInterface.dismiss();
              if (paramOnClickListener != null) {
                paramOnClickListener.onClick(paramAnonymousDialogInterface, -2);
              }
              GMTrace.o(16686082162688L, 124321);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(16686887469056L, 124327);
              paramAnonymousDialogInterface.dismiss();
              if (this.sAA != null) {
                this.sAA.onClick(paramAnonymousDialogInterface, -1);
              }
              GMTrace.o(16686887469056L, 124327);
            }
          }, R.e.aWt);
          GMTrace.o(763833090048L, 5691);
          return;
        }
        Object localObject2;
        if (paramFragment == null)
        {
          localObject2 = paramb;
          if (paramInt2 != -4) {
            break label483;
          }
          switch (paramInt1)
          {
          default: 
            paramActivity = "";
          }
        }
        for (;;)
        {
          g.a((Context)localObject2, paramActivity, "", ((Context)localObject2).getString(R.l.eFS), ((Context)localObject2).getString(R.l.dXa), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(16686619033600L, 124325);
              paramAnonymousDialogInterface.dismiss();
              if (this.sAA != null) {
                this.sAA.onClick(paramAnonymousDialogInterface, -2);
              }
              if (paramFragment != null)
              {
                com.tencent.mm.ui.snackbar.a.a(0, paramFragment, paramFragment.aG().getString(R.l.eiG), paramFragment.aG().getString(R.l.ehr), localObject1, paramc);
                GMTrace.o(16686619033600L, 124325);
                return;
              }
              com.tencent.mm.ui.snackbar.a.a(0, paramb, paramb.getString(R.l.eiG), paramb.getString(R.l.ehr), localObject1, paramc);
              GMTrace.o(16686619033600L, 124325);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(17441056882688L, 129946);
              paramAnonymousDialogInterface.dismiss();
              if (this.sAA != null) {
                this.sAA.onClick(paramAnonymousDialogInterface, -1);
              }
              GMTrace.o(17441056882688L, 129946);
            }
          }, R.e.aWt);
          GMTrace.o(763833090048L, 5691);
          return;
          localObject2 = paramFragment.aG();
          break;
          paramActivity = ((Context)localObject2).getString(R.l.ehQ);
          continue;
          paramActivity = ((Context)localObject2).getString(R.l.ehP);
          continue;
          paramActivity = ((Context)localObject2).getString(R.l.ehR);
          continue;
          paramActivity = ((Context)localObject2).getString(R.l.eie);
          continue;
          if (paramInt2 == -5)
          {
            if (paramInt1 != 14) {
              paramActivity = ((Context)localObject2).getString(R.l.ehs);
            } else {
              paramActivity = ((Context)localObject2).getString(R.l.eid);
            }
          }
          else if (paramInt2 == -6)
          {
            paramActivity = ((Context)localObject2).getString(R.l.eie);
          }
          else if (paramInt2 == -7)
          {
            paramActivity = ((Context)localObject2).getString(R.l.eid);
          }
          else if (paramInt2 == -8)
          {
            paramActivity = ((Context)localObject2).getString(R.l.eif);
          }
          else
          {
            if (paramInt2 == -9)
            {
              if (paramFragment != null)
              {
                com.tencent.mm.ui.snackbar.a.a(0, paramFragment, ((Context)localObject2).getString(R.l.eiG), ((Context)localObject2).getString(R.l.ehr), (b.b)localObject1, paramc);
                GMTrace.o(763833090048L, 5691);
                return;
              }
              com.tencent.mm.ui.snackbar.a.a(0, paramb, ((Context)localObject2).getString(R.l.eiG), ((Context)localObject2).getString(R.l.ehr), (b.b)localObject1, paramc);
              GMTrace.o(763833090048L, 5691);
              return;
            }
            paramActivity = ((Context)localObject2).getString(R.l.ehT);
          }
        }
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, Activity paramActivity, b.b paramb)
  {
    GMTrace.i(763698872320L, 5690);
    a(-1, paramInt1, paramInt2, paramActivity, null, null, null, paramb);
    GMTrace.o(763698872320L, 5690);
  }
  
  private static boolean a(au paramau, cb paramcb, String paramString, boolean paramBoolean)
  {
    GMTrace.i(764235743232L, 5694);
    Object localObject;
    if (!bf.mA(paramString))
    {
      localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        if (((File)localObject).length() > b.sD())
        {
          v.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          GMTrace.o(764235743232L, 5694);
          return true;
        }
        v.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
      }
    }
    else
    {
      localObject = paramau.field_content;
      if (localObject == null) {
        break label270;
      }
    }
    label270:
    for (paramau = f.a.B((String)localObject, paramau.field_reserved);; paramau = null)
    {
      if (paramau != null)
      {
        if ((paramau.hhk != 0) || (paramau.hhg > b.sD()))
        {
          v.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
          GMTrace.o(764235743232L, 5694);
          return true;
          if (paramBoolean) {
            break;
          }
          v.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
          ((rl)paramcb.fFr.fFt.txF.getLast()).NY(null);
          break;
        }
        if ((!bf.mA(paramString)) && (e.aO(paramString)) && (!paramBoolean))
        {
          long l = e.aN(paramString);
          if (paramau.hhg > l)
          {
            v.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
            ((rl)paramcb.fFr.fFt.txF.getLast()).NY(null);
          }
        }
      }
      if ((localObject == null) || (paramau == null)) {
        v.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
      }
      GMTrace.o(764235743232L, 5694);
      return false;
    }
  }
  
  public static Bitmap aI(String paramString, boolean paramBoolean)
  {
    GMTrace.i(17441593753600L, 129950);
    if (bf.mA(paramString))
    {
      GMTrace.o(17441593753600L, 129950);
      return null;
    }
    Object localObject = (Bitmap)sAy.get(paramString);
    if (localObject != null)
    {
      v.d("MicroMsg.FavExportLogic", "get bm from cache %s", new Object[] { paramString });
      GMTrace.o(17441593753600L, 129950);
      return (Bitmap)localObject;
    }
    if (paramBoolean)
    {
      GMTrace.o(17441593753600L, 129950);
      return null;
    }
    if (!e.aO(paramString))
    {
      GMTrace.o(17441593753600L, 129950);
      return null;
    }
    v.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      v.i("MicroMsg.FavExportLogic", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    int i;
    int j;
    if ((com.tencent.mm.sdk.platformtools.d.bh(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
    {
      i = 1;
      if ((!com.tencent.mm.sdk.platformtools.d.bg(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outHeight <= 480)) {
        break label269;
      }
      j = 1;
    }
    label224:
    label269:
    int k;
    for (;;)
    {
      if ((i != 0) || (j != 0))
      {
        i = ((BitmapFactory.Options)localObject).outHeight;
        j = ((BitmapFactory.Options)localObject).outWidth;
        for (;;)
        {
          if (j * i > 2764800)
          {
            j >>= 1;
            i >>= 1;
            continue;
            i = 0;
            break;
            j = 0;
            break label224;
          }
        }
        j = Math.max(1, j);
        k = Math.max(1, i);
        v.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(j), Integer.valueOf(k) });
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      int n = BackwardSupportUtil.ExifHelper.Pb(paramString);
      int m;
      if (n != 90)
      {
        m = j;
        k = i;
        if (n != 270) {}
      }
      else
      {
        k = j;
        m = i;
      }
      if ((MMNativeJpeg.IsJpegFile(paramString)) && (MMNativeJpeg.isProgressive(paramString)))
      {
        localObject = MMNativeJpeg.decodeAsBitmap(paramString);
        if (localObject == null)
        {
          paramBoolean = true;
          v.i("MicroMsg.FavExportLogic", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(paramBoolean) });
        }
      }
      for (;;)
      {
        if (localObject != null) {
          break label480;
        }
        v.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = " + paramString);
        GMTrace.o(17441593753600L, 129950);
        return null;
        paramBoolean = false;
        break;
        localObject = com.tencent.mm.sdk.platformtools.d.d(paramString, m, k, false);
      }
      label480:
      localObject = com.tencent.mm.sdk.platformtools.d.b((Bitmap)localObject, n);
      sAy.put(paramString, localObject);
      GMTrace.o(17441593753600L, 129950);
      return (Bitmap)localObject;
      j = 960;
      i = 960;
    }
  }
  
  public static void bCu()
  {
    GMTrace.i(17441996406784L, 129953);
    GMTrace.o(17441996406784L, 129953);
  }
  
  private static String eh(String paramString1, String paramString2)
  {
    GMTrace.i(763564654592L, 5689);
    if (bf.mA(paramString1))
    {
      GMTrace.o(763564654592L, 5689);
      return paramString2;
    }
    if (bf.mA(paramString2))
    {
      GMTrace.o(763564654592L, 5689);
      return paramString1;
    }
    paramString1 = paramString1 + "​" + paramString2;
    GMTrace.o(763564654592L, 5689);
    return paramString1;
  }
  
  public static String p(rl paramrl)
  {
    GMTrace.i(17441459535872L, 129949);
    rm localrm = paramrl.twu;
    String str = "";
    switch (paramrl.aMw)
    {
    case 2: 
    case 3: 
    case 7: 
    case 9: 
    default: 
      paramrl = eh(eh("", localrm.title), localrm.desc);
    }
    for (;;)
    {
      GMTrace.o(17441459535872L, 129949);
      return paramrl;
      paramrl = eh("", paramrl.desc);
      continue;
      paramrl = str;
      if (localrm.twU != null)
      {
        paramrl = eh("", localrm.twU.title);
        continue;
        paramrl = str;
        if (localrm.twQ != null)
        {
          paramrl = eh("", localrm.twQ.title);
          continue;
          str = eh("", localrm.iAN);
          paramrl = str;
          if (localrm.twO != null)
          {
            paramrl = eh(eh(str, localrm.twO.fRN), localrm.twO.label);
            continue;
            paramrl = str;
            if (localrm.twS != null)
            {
              paramrl = eh(eh("", localrm.twS.title), localrm.twS.desc);
              continue;
              paramrl = eh("", localrm.title);
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
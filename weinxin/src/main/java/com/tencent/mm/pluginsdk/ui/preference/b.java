package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.av.f;
import com.tencent.mm.av.g;
import com.tencent.mm.av.h;
import com.tencent.mm.av.i;
import com.tencent.mm.av.j;
import com.tencent.mm.av.k;
import com.tencent.mm.av.l;
import com.tencent.mm.e.a.fh;
import com.tencent.mm.e.a.fh.b;
import com.tencent.mm.e.b.bz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import junit.framework.Assert;

public final class b
{
  public String fER;
  public boolean fZA;
  public String hkk;
  public long id;
  public String otA;
  public int pqa;
  public String sQA;
  public String username;
  
  public b()
  {
    GMTrace.i(1044616577024L, 7783);
    GMTrace.o(1044616577024L, 7783);
  }
  
  public static b a(Context paramContext, long paramLong, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2)
  {
    GMTrace.i(1044885012480L, 7785);
    b localb = new b();
    localb.id = paramLong;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localb.fZA = bool;
      v.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2) });
      if (paramInt1 != 0) {
        break label378;
      }
      if (paramString2 != null) {
        break;
      }
      v.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = " + paramString1);
      GMTrace.o(1044885012480L, 7785);
      return null;
    }
    localb.username = paramString3;
    localb.fER = paramString4;
    switch (paramInt2)
    {
    default: 
      localb.hkk = paramContext.getString(R.l.dTr);
    }
    for (;;)
    {
      GMTrace.o(1044885012480L, 7785);
      return localb;
      localb.hkk = paramContext.getString(R.l.dTm);
      continue;
      paramString1 = new fh();
      paramString1.fJI.fJF = paramString5;
      paramString1.fJI.fJG = paramString6;
      a.uql.m(paramString1);
      localb.hkk = paramContext.getString(R.l.dTp, new Object[] { bf.ap(paramString1.fJJ.fJK, "") });
      continue;
      localb.hkk = paramContext.getString(R.l.dTy);
      continue;
      localb.hkk = paramContext.getString(R.l.dTs);
      continue;
      localb.otA = au.a.RE(paramString2).otA;
      localb.hkk = paramContext.getString(R.l.dTn);
      continue;
      label378:
      if (!paramBoolean)
      {
        localb.username = paramString1;
        localb.hkk = paramString2;
      }
      else
      {
        localb.username = paramString3;
        localb.fER = paramString4;
        if ((paramString7 != null) && (!paramString7.trim().equals(""))) {
          localb.hkk = paramString7;
        } else {
          localb.hkk = paramContext.getString(R.l.ekR);
        }
      }
    }
  }
  
  public static b a(Context paramContext, f paramf)
  {
    GMTrace.i(1044750794752L, 7784);
    long l = paramf.uvp;
    boolean bool = paramf.Kq();
    String str4 = paramf.field_talker;
    String str5 = paramf.field_msgContent;
    int k = paramf.field_type;
    paramf = null;
    Object localObject1 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject4 = null;
    Object localObject6 = null;
    int j = 0;
    Object localObject2;
    Object localObject5;
    Object localObject3;
    int i;
    if (k == 0)
    {
      localObject2 = au.a.RE(str5);
      paramf = ((au.a)localObject2).rTh;
      localObject1 = ((au.a)localObject2).fER;
      localObject5 = ((au.a)localObject2).uIi;
      localObject3 = ((au.a)localObject2).uIj;
      i = ((au.a)localObject2).scene;
      localObject2 = localObject6;
    }
    for (;;)
    {
      paramContext = a(paramContext, l, bool, str4, str5, k, paramf, (String)localObject1, (String)localObject5, (String)localObject3, (String)localObject4, i);
      paramContext.sQA = ((String)localObject2);
      GMTrace.o(1044750794752L, 7784);
      return paramContext;
      localObject2 = localObject6;
      localObject5 = localObject7;
      localObject3 = localObject8;
      i = j;
      if (bool)
      {
        au.d locald = au.d.RH(str5);
        String str1 = locald.rTh;
        String str2 = locald.fER;
        String str3 = locald.content;
        localObject2 = localObject6;
        paramf = str1;
        localObject1 = str2;
        localObject5 = localObject7;
        localObject3 = localObject8;
        localObject4 = str3;
        i = j;
        if (locald.uIv == 1)
        {
          localObject2 = locald.uIx;
          paramf = str1;
          localObject1 = str2;
          localObject5 = localObject7;
          localObject3 = localObject8;
          localObject4 = str3;
          i = j;
        }
      }
    }
  }
  
  public static b a(Context paramContext, j paramj)
  {
    GMTrace.i(1045153447936L, 7787);
    v.d("MicroMsg.FMessageProvider", "build shake, talker = " + paramj.field_talker + ", scene = " + paramj.field_scene);
    b localb = new b();
    localb.id = paramj.uvp;
    if (paramj.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.fZA = bool;
      localb.username = paramj.field_sayhiuser;
      localb.pqa = paramj.field_scene;
      if (paramj.field_isSend != 1) {
        break;
      }
      localb.hkk = paramj.field_content;
      GMTrace.o(1045153447936L, 7787);
      return localb;
    }
    paramj = au.d.RH(paramj.field_content);
    if ((paramj.content != null) && (!paramj.content.trim().equals(""))) {}
    for (localb.hkk = paramj.content;; localb.hkk = paramContext.getString(R.l.dTA))
    {
      localb.fER = paramj.fER;
      break;
    }
  }
  
  public static b a(Context paramContext, bz parambz)
  {
    GMTrace.i(1045019230208L, 7786);
    v.d("MicroMsg.FMessageProvider", "build lbs, talker = " + parambz.field_sayhiuser + ", scene = " + parambz.field_scene);
    b localb = new b();
    localb.id = parambz.uvp;
    if (parambz.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.fZA = bool;
      localb.username = parambz.field_sayhiuser;
      localb.pqa = parambz.field_scene;
      if (parambz.field_isSend != 1) {
        break;
      }
      localb.hkk = parambz.field_content;
      GMTrace.o(1045019230208L, 7786);
      return localb;
    }
    parambz = au.d.RH(parambz.field_content);
    if ((parambz.content != null) && (!parambz.content.trim().equals(""))) {}
    for (localb.hkk = parambz.content;; localb.hkk = paramContext.getString(R.l.dTA))
    {
      localb.fER = parambz.fER;
      break;
    }
  }
  
  public static b[] a(Context paramContext, f[] paramArrayOff)
  {
    GMTrace.i(1045287665664L, 7788);
    StringBuilder localStringBuilder = new StringBuilder("convert fmsgList, talker = ");
    if ((paramArrayOff == null) || (paramArrayOff.length == 0) || (paramArrayOff[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOff[0].field_talker)
    {
      v.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOff != null) && (paramArrayOff.length != 0)) {
        break;
      }
      v.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
      GMTrace.o(1045287665664L, 7788);
      return null;
    }
    localObject = new b[paramArrayOff.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = a(paramContext, paramArrayOff[i]);
      i += 1;
    }
    GMTrace.o(1045287665664L, 7788);
    return (b[])localObject;
  }
  
  public static b[] a(Context paramContext, j[] paramArrayOfj)
  {
    GMTrace.i(1045556101120L, 7790);
    StringBuilder localStringBuilder = new StringBuilder("convert shakeList, talker = ");
    if ((paramArrayOfj == null) || (paramArrayOfj.length == 0) || (paramArrayOfj[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfj[0].field_sayhiuser)
    {
      v.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfj != null) && (paramArrayOfj.length != 0)) {
        break;
      }
      v.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
      GMTrace.o(1045556101120L, 7790);
      return null;
    }
    localObject = new b[paramArrayOfj.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = a(paramContext, paramArrayOfj[i]);
      i += 1;
    }
    GMTrace.o(1045556101120L, 7790);
    return (b[])localObject;
  }
  
  public static b[] a(Context paramContext, bz[] paramArrayOfbz)
  {
    GMTrace.i(1045421883392L, 7789);
    StringBuilder localStringBuilder = new StringBuilder("convert lbsList, talker = ");
    if ((paramArrayOfbz == null) || (paramArrayOfbz.length == 0) || (paramArrayOfbz[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfbz[0].field_sayhiuser)
    {
      v.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfbz != null) && (paramArrayOfbz.length != 0)) {
        break;
      }
      v.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
      GMTrace.o(1045421883392L, 7789);
      return null;
    }
    localObject = new b[paramArrayOfbz.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = a(paramContext, paramArrayOfbz[i]);
      i += 1;
    }
    GMTrace.o(1045421883392L, 7789);
    return (b[])localObject;
  }
  
  public static void ay(String paramString, int paramInt)
  {
    GMTrace.i(1045690318848L, 7791);
    j[] arrayOfj;
    Object localObject1;
    f[] arrayOff;
    h[] arrayOfh;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      v.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
      arrayOfj = l.KB().lk(paramString);
      localObject1 = a(aa.getContext(), arrayOfj);
      arrayOff = null;
      arrayOfh = null;
    }
    while (localObject1 == null)
    {
      GMTrace.o(1045690318848L, 7791);
      return;
      if (paramInt == 18)
      {
        v.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
        arrayOfh = l.KA().lf(paramString);
        localObject1 = a(aa.getContext(), arrayOfh);
        arrayOfj = null;
        arrayOff = null;
      }
      else
      {
        arrayOff = l.Ky().la(paramString);
        localObject1 = a(aa.getContext(), arrayOff);
        arrayOfj = null;
        arrayOfh = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    au localau;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localau = new au();
      localau.setContent(((b)localObject2).hkk);
      m = o.fG(((b)localObject2).username);
      if (arrayOff != null)
      {
        j = paramInt + 1;
        localau.z(arrayOff[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label224:
    label261:
    label400:
    label588:
    for (;;)
    {
      localau.cH(((b)localObject2).username);
      localau.setType(m);
      long l;
      if (((b)localObject2).fZA)
      {
        localau.dv(2);
        localau.dw(1);
        ap.yY();
        l = com.tencent.mm.u.c.wT().L(localau);
        if (l == -1L) {
          break label400;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        v.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + l);
        i += 1;
        break;
        if (arrayOfh != null)
        {
          j = paramInt + 1;
          localau.z(arrayOfh[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label224;
        }
        if (arrayOfj == null) {
          break label588;
        }
        j = paramInt + 1;
        localau.z(arrayOfj[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label224;
        localau.dv(6);
        localau.dw(0);
        break label261;
      }
      localObject1 = new au();
      if (arrayOff != null) {
        ((au)localObject1).z(arrayOff[(arrayOff.length - 1)].field_createTime + 1L);
      }
      for (;;)
      {
        ((au)localObject1).cH(paramString);
        ((au)localObject1).setContent(aa.getContext().getString(R.l.eYq));
        ((au)localObject1).setType(10000);
        ((au)localObject1).dv(6);
        ((au)localObject1).dw(0);
        ap.yY();
        l = com.tencent.mm.u.c.wT().L((au)localObject1);
        v.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + l);
        GMTrace.o(1045690318848L, 7791);
        return;
        if (arrayOfh != null) {
          ((au)localObject1).z(arrayOfh[(arrayOfh.length - 1)].field_createtime * 1000L + 1L);
        } else if (arrayOfj != null) {
          ((au)localObject1).z(arrayOfj[(arrayOfj.length - 1)].field_createtime * 1000L + 1L);
        }
      }
    }
  }
  
  public static x b(f paramf)
  {
    GMTrace.i(1045824536576L, 7792);
    x localx = new x();
    if (paramf == null)
    {
      GMTrace.o(1045824536576L, 7792);
      return localx;
    }
    if (paramf.field_type == 0)
    {
      paramf = au.a.RE(paramf.field_msgContent);
      localx = new x();
      localx.setUsername(paramf.rTh);
      localx.bO(paramf.gtH);
      localx.bR(paramf.getDisplayName());
      localx.bS(paramf.hBM);
      localx.bT(paramf.hBN);
      localx.di(paramf.gkh);
      localx.cf(paramf.getProvince());
      localx.cg(paramf.getCity());
      localx.ce(paramf.signature);
      localx.de(paramf.rUD);
      localx.cj(paramf.gkw);
      GMTrace.o(1045824536576L, 7792);
      return localx;
    }
    paramf = au.d.RH(paramf.field_msgContent);
    localx = new x();
    localx.setUsername(paramf.rTh);
    localx.bO(paramf.gtH);
    localx.bR(paramf.fER);
    localx.bS(paramf.hBM);
    localx.bT(paramf.hBN);
    localx.di(paramf.gkh);
    localx.ce(paramf.signature);
    localx.cf(paramf.getProvince());
    localx.cg(paramf.getCity());
    GMTrace.o(1045824536576L, 7792);
    return localx;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/preference/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
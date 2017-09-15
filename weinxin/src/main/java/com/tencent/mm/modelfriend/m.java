package com.tencent.mm.modelfriend;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.av.e;
import com.tencent.mm.av.f;
import com.tencent.mm.av.l;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class m
{
  private static Map<String, String> hAX;
  
  static
  {
    GMTrace.i(4454149521408L, 33186);
    hAX = null;
    GMTrace.o(4454149521408L, 33186);
  }
  
  public static void C(List<String> paramList)
  {
    GMTrace.i(4453209997312L, 33179);
    if (paramList.size() == 0)
    {
      GMTrace.o(4453209997312L, 33179);
      return;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = l.Ky().Kr().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      ap.yY();
      au.a locala = com.tencent.mm.u.c.wT().At(localf.field_msgContent);
      if (locala != null)
      {
        String str1 = locala.uIj;
        String str2 = locala.uIi;
        if (((locala.scene == 10) || (locala.scene == 11)) && ((paramList.contains(str1)) || (paramList.contains(str2)))) {
          localHashSet.add(localf.field_talker);
        }
      }
    }
    v.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + localHashSet.size());
    paramList = localHashSet.iterator();
    while (paramList.hasNext()) {
      e.d(0L, (String)paramList.next());
    }
    GMTrace.o(4453209997312L, 33179);
  }
  
  public static void D(List<b> paramList)
  {
    GMTrace.i(4453478432768L, 33181);
    if (paramList == null)
    {
      v.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
      GMTrace.o(4453478432768L, 33181);
      return;
    }
    af.FZ().z(paramList);
    GMTrace.o(4453478432768L, 33181);
  }
  
  public static void E(List<String> paramList)
  {
    GMTrace.i(4453612650496L, 33182);
    if (paramList == null)
    {
      v.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
      GMTrace.o(4453612650496L, 33182);
      return;
    }
    af.FZ().B(paramList);
    GMTrace.o(4453612650496L, 33182);
  }
  
  public static void Fj()
  {
    GMTrace.i(4451733602304L, 33168);
    ap.yY();
    com.tencent.mm.u.c.vr().set(12322, Boolean.valueOf(true));
    GMTrace.o(4451733602304L, 33168);
  }
  
  public static boolean Fk()
  {
    GMTrace.i(4451867820032L, 33169);
    if (ap.yY() != null)
    {
      ap.yY();
      if (com.tencent.mm.u.c.vr() != null)
      {
        ap.yY();
        boolean bool = bf.b((Boolean)com.tencent.mm.u.c.vr().get(12322, Boolean.valueOf(true)), true);
        GMTrace.o(4451867820032L, 33169);
        return bool;
      }
    }
    v.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMCore.getAccStg() is null!!!");
    GMTrace.o(4451867820032L, 33169);
    return false;
  }
  
  public static boolean Fl()
  {
    GMTrace.i(4452002037760L, 33170);
    a locala = Fm();
    v.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", new Object[] { locala.toString() });
    if (locala == a.hBa)
    {
      ap.yY();
      boolean bool = bf.b((Boolean)com.tencent.mm.u.c.vr().get(12322, Boolean.valueOf(false)), false);
      v.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        GMTrace.o(4452002037760L, 33170);
        return true;
      }
      GMTrace.o(4452002037760L, 33170);
      return false;
    }
    GMTrace.o(4452002037760L, 33170);
    return false;
  }
  
  public static a Fm()
  {
    GMTrace.i(4452136255488L, 33171);
    for (;;)
    {
      try
      {
        ap.yY();
        localObject2 = (String)com.tencent.mm.u.c.vr().get(4097, "");
        ap.yY();
        String str = (String)com.tencent.mm.u.c.vr().get(6, "");
        boolean bool = com.tencent.mm.u.m.yo();
        v.i("MicroMsg.FriendLogic", "isUpload " + bool + " stat " + com.tencent.mm.u.m.xP());
        if (localObject2 != null)
        {
          Object localObject1 = localObject2;
          if (((String)localObject2).length() > 0)
          {
            if (str == null) {
              break label210;
            }
            localObject2 = str;
            if (str.length() <= 0) {
              break label210;
            }
            if ((localObject1 == null) && (localObject2 == null))
            {
              localObject1 = a.hAY;
              GMTrace.o(4452136255488L, 33171);
              return (a)localObject1;
            }
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject1 = a.hAZ;
              GMTrace.o(4452136255488L, 33171);
              return (a)localObject1;
            }
            if (bool)
            {
              localObject1 = a.hBa;
              GMTrace.o(4452136255488L, 33171);
              return (a)localObject1;
            }
            localObject1 = a.hBb;
            GMTrace.o(4452136255488L, 33171);
            return (a)localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        locala = a.hAY;
        GMTrace.o(4452136255488L, 33171);
        return locala;
      }
      a locala = null;
      continue;
      label210:
      Object localObject2 = null;
    }
  }
  
  public static void Fn()
  {
    GMTrace.i(4452270473216L, 33172);
    ap.yY();
    com.tencent.mm.u.c.vr().set(4097, "");
    ap.yY();
    com.tencent.mm.u.c.vr().set(6, "");
    GMTrace.o(4452270473216L, 33172);
  }
  
  public static String Fo()
  {
    GMTrace.i(4452404690944L, 33173);
    ap.yY();
    String str = (String)com.tencent.mm.u.c.vr().get(6, "");
    GMTrace.o(4452404690944L, 33173);
    return str;
  }
  
  public static boolean Fp()
  {
    GMTrace.i(4452538908672L, 33174);
    boolean bool = ap.zb();
    if (!bool)
    {
      v.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(4452538908672L, 33174);
      return false;
    }
    if (Fm() == a.hBa) {}
    for (int i = 1; i == 0; i = 0)
    {
      v.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", new Object[] { Boolean.valueOf(false) });
      GMTrace.o(4452538908672L, 33174);
      return false;
    }
    bool = Fk();
    if (!bool)
    {
      v.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(4452538908672L, 33174);
      return false;
    }
    GMTrace.o(4452538908672L, 33174);
    return true;
  }
  
  public static void Fq()
  {
    GMTrace.i(4452941561856L, 33177);
    c localc = af.FZ();
    int i = localc.hnp.delete("addr_upload2", null, null);
    v.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
    if (i > 0) {
      localc.b(5, localc, null);
    }
    GMTrace.o(4452941561856L, 33177);
  }
  
  public static void Fr()
  {
    GMTrace.i(4453075779584L, 33178);
    Object localObject = new HashSet();
    Iterator localIterator = l.Ky().Kr().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      ap.yY();
      au.a locala = com.tencent.mm.u.c.wT().At(localf.field_msgContent);
      if ((locala != null) && ((locala.scene == 10) || (locala.scene == 11))) {
        ((HashSet)localObject).add(localf.field_talker);
      }
    }
    v.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + ((HashSet)localObject).size());
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      e.d(0L, (String)((Iterator)localObject).next());
    }
    GMTrace.o(4453075779584L, 33178);
  }
  
  public static List<String> Fs()
  {
    GMTrace.i(4453746868224L, 33183);
    Cursor localCursor = af.FZ().hnp.a("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(localCursor.getString(0));
    }
    localCursor.close();
    GMTrace.o(4453746868224L, 33183);
    return localArrayList;
  }
  
  public static List<String> Ft()
  {
    GMTrace.i(4453881085952L, 33184);
    Cursor localCursor = af.FZ().hnp.a("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = a.Dg(localCursor.getString(0));
      if (a.Lz(str)) {
        localArrayList.add(str);
      }
    }
    localCursor.close();
    GMTrace.o(4453881085952L, 33184);
    return localArrayList;
  }
  
  public static Bitmap a(String paramString, Context paramContext)
  {
    GMTrace.i(4452673126400L, 33175);
    paramString = a.a(paramString, paramContext, false);
    GMTrace.o(4452673126400L, 33175);
    return paramString;
  }
  
  public static boolean a(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    GMTrace.i(4452807344128L, 33176);
    boolean bool = a.b(paramString, paramContext, paramArrayOfByte);
    GMTrace.o(4452807344128L, 33176);
    return bool;
  }
  
  public static boolean fF(int paramInt)
  {
    GMTrace.i(4454015303680L, 33185);
    ab localab = af.Gc().fI(paramInt);
    boolean bool = af.Ge().fJ(paramInt);
    if (localab == null)
    {
      GMTrace.o(4454015303680L, 33185);
      return false;
    }
    if ((localab.hBG == 1) || (bool))
    {
      GMTrace.o(4454015303680L, 33185);
      return true;
    }
    GMTrace.o(4454015303680L, 33185);
    return false;
  }
  
  public static String ji(String paramString)
  {
    GMTrace.i(4453344215040L, 33180);
    if ((paramString == null) || (paramString.equals("")))
    {
      GMTrace.o(4453344215040L, 33180);
      return "";
    }
    Object localObject = af.FZ();
    paramString = "select addr_upload2.realname from addr_upload2 where addr_upload2.id = \"" + b.iY(paramString) + "\"";
    localObject = ((c)localObject).hnp.a(paramString, null, 2);
    if (localObject == null)
    {
      GMTrace.o(4453344215040L, 33180);
      return "";
    }
    paramString = "";
    if (((Cursor)localObject).moveToFirst()) {
      paramString = ((Cursor)localObject).getString(0);
    }
    ((Cursor)localObject).close();
    GMTrace.o(4453344215040L, 33180);
    return paramString;
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(4441533054976L, 33092);
      hAY = new a("NO_INIT", 0);
      hAZ = new a("SET_MOBILE", 1);
      hBa = new a("SUCC", 2);
      hBb = new a("SUCC_UNLOAD", 3);
      hBc = new a[] { hAY, hAZ, hBa, hBb };
      GMTrace.o(4441533054976L, 33092);
    }
    
    private a()
    {
      GMTrace.i(4441398837248L, 33091);
      GMTrace.o(4441398837248L, 33091);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
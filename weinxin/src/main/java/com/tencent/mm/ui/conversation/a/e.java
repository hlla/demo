package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aw;
import com.tencent.mm.u.ax;
import com.tencent.mm.u.ax.a;
import com.tencent.mm.u.b.b.b;
import com.tencent.mm.u.b.d;
import com.tencent.mm.ui.e.b;

public final class e
{
  public static com.tencent.mm.pluginsdk.ui.b.a a(Context paramContext, int paramInt, Object[] paramArrayOfObject)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    GMTrace.i(14509607485440L, 108105);
    Object localObject1;
    String str1;
    label127:
    label222:
    label259:
    String str2;
    switch (1.wcM[(paramInt - 1)])
    {
    default: 
      localObject1 = localObject2;
    case 1: 
    case 2: 
      do
      {
        do
        {
          do
          {
            do
            {
              GMTrace.o(14509607485440L, 108105);
              return (com.tencent.mm.pluginsdk.ui.b.a)localObject1;
              localObject1 = localObject2;
            } while (paramArrayOfObject == null);
            localObject1 = localObject2;
          } while (paramArrayOfObject.length != 2);
          if (paramArrayOfObject[0] != null)
          {
            str1 = paramArrayOfObject[0].toString();
            if (paramArrayOfObject[1] == null) {
              break label222;
            }
          }
          for (paramArrayOfObject = paramArrayOfObject[1].toString();; paramArrayOfObject = null)
          {
            if (ap.yY().xy() == null) {
              v.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
            }
            localObject1 = localObject2;
            if (ap.yY().xy() == null) {
              break;
            }
            if (!ap.yY().xy().gA(str1))
            {
              localObject1 = localObject2;
              if (!ap.yY().xy().gA(paramArrayOfObject)) {
                break;
              }
            }
            localObject1 = new f(paramContext, str1, paramArrayOfObject);
            break;
            str1 = null;
            break label127;
          }
          localObject1 = localObject2;
        } while (paramArrayOfObject == null);
        localObject1 = localObject2;
      } while (paramArrayOfObject.length != 3);
      if (paramArrayOfObject[0] != null)
      {
        str1 = paramArrayOfObject[0].toString();
        if (paramArrayOfObject[1] == null) {
          break label369;
        }
        str2 = paramArrayOfObject[1].toString();
        label273:
        if ((paramArrayOfObject[2] == null) || (!(paramArrayOfObject[2] instanceof Boolean))) {
          break label833;
        }
      }
      break;
    }
    label369:
    label819:
    label833:
    for (bool1 = ((Boolean)paramArrayOfObject[2]).booleanValue();; bool1 = false)
    {
      if ((!ap.zb()) || (ap.yY().xz() == null) || (!ap.yY().xz().gA(str1)))
      {
        localObject1 = localObject2;
        if (!ap.yY().xz().gA(str2)) {
          break;
        }
      }
      localObject1 = new g(paramContext, str1, str2, bool1);
      break;
      str1 = null;
      break label259;
      str2 = null;
      break label273;
      localObject1 = new m(paramContext);
      break;
      localObject1 = new h(paramContext);
      break;
      localObject1 = new a(paramContext);
      break;
      ax.zj();
      paramArrayOfObject = ax.zk();
      localObject1 = localObject2;
      if (paramArrayOfObject == null) {
        break;
      }
      localObject1 = new k(paramContext, paramArrayOfObject);
      break;
      paramArrayOfObject = com.tencent.mm.u.a.g.Ae().gu("4");
      localObject1 = localObject2;
      if (paramArrayOfObject == null) {
        break;
      }
      paramArrayOfObject = paramArrayOfObject.value;
      localObject1 = localObject2;
      if (bf.mA(paramArrayOfObject)) {
        break;
      }
      localObject1 = localObject2;
      if (paramArrayOfObject.equals("0")) {
        break;
      }
      if (paramArrayOfObject.equals("1"))
      {
        ap.yY();
        paramArrayOfObject = com.tencent.mm.u.c.vr().get(328195, Boolean.valueOf(false));
        if ((paramArrayOfObject instanceof Boolean)) {
          bool1 = ((Boolean)paramArrayOfObject).booleanValue();
        }
        if (!bool1)
        {
          ax.zj();
          paramInt = ax.zl();
          if ((paramInt == ax.a.hml) || (paramInt == ax.a.hmm))
          {
            v.i("MicroMsg.BannerFactory", "already Bind the Mobile");
            localObject1 = localObject2;
            break;
          }
          localObject1 = new k(paramContext, new aw(1, 1, ""));
          com.tencent.mm.u.a.f.gy("4");
          break;
        }
        v.i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
        localObject1 = localObject2;
        break;
      }
      localObject1 = localObject2;
      if (!paramArrayOfObject.equals("2")) {
        break;
      }
      ap.yY();
      paramArrayOfObject = com.tencent.mm.u.c.vr().get(328196, Boolean.valueOf(false));
      bool1 = bool2;
      if ((paramArrayOfObject instanceof Boolean)) {
        bool1 = ((Boolean)paramArrayOfObject).booleanValue();
      }
      if (!bool1)
      {
        ax.zj();
        if (ax.zl() == ax.a.hml)
        {
          v.i("MicroMsg.BannerFactory", "already upload the Mobile");
          localObject1 = localObject2;
          break;
        }
        localObject1 = new k(paramContext, new aw(2, 1, ""));
        com.tencent.mm.u.a.f.gy("4");
        break;
      }
      v.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
      localObject1 = localObject2;
      break;
      localObject1 = new l(paramContext);
      break;
      localObject1 = new n(paramContext);
      break;
      localObject1 = new j(paramContext);
      break;
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {}
      for (paramArrayOfObject = (b.b)paramArrayOfObject[0];; paramArrayOfObject = b.b.hos)
      {
        if (paramArrayOfObject != b.b.hos) {
          break label819;
        }
        localObject1 = new com.tencent.mm.ui.e.a(paramContext, paramArrayOfObject);
        break;
      }
      localObject1 = new b(paramContext, paramArrayOfObject);
      break;
    }
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(14509473267712L, 108104);
      wcN = 1;
      wcO = 2;
      wcP = 3;
      wcQ = 4;
      wcR = 5;
      wcS = 6;
      wcT = 7;
      wcU = 8;
      wcV = 9;
      wcW = 10;
      wcX = 11;
      wcY = new int[] { wcN, wcO, wcP, wcQ, wcR, wcS, wcT, wcU, wcV, wcW, wcX };
      GMTrace.o(14509473267712L, 108104);
    }
    
    public static int[] bYG()
    {
      GMTrace.i(14509339049984L, 108103);
      int[] arrayOfInt = (int[])wcY.clone();
      GMTrace.o(14509339049984L, 108103);
      return arrayOfInt;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
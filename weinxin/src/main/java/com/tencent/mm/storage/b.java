package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class b
  extends i<a>
{
  public static final String[] gUn;
  private e gUp;
  
  static
  {
    GMTrace.i(1585514020864L, 11813);
    gUn = new String[] { i.a(a.gTF, "ABTestInfo") };
    GMTrace.o(1585514020864L, 11813);
  }
  
  public b(e parame)
  {
    super(parame, a.gTF, "ABTestInfo", null);
    GMTrace.i(1584574496768L, 11806);
    this.gUp = parame;
    GMTrace.o(1584574496768L, 11806);
  }
  
  public final a QB(String paramString)
  {
    GMTrace.i(1584977149952L, 11809);
    a locala = new a();
    locala.field_abtestkey = paramString;
    boolean bool = super.b(locala, new String[0]);
    if ((bool) && (locala.field_endTime == 0L)) {
      locala.field_endTime = Long.MAX_VALUE;
    }
    v.i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", new Object[] { paramString, Boolean.valueOf(bool) });
    GMTrace.o(1584977149952L, 11809);
    return locala;
  }
  
  public final LinkedList<qc> bKy()
  {
    GMTrace.i(1584842932224L, 11808);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = Kl();
    if (localCursor == null)
    {
      GMTrace.o(1584842932224L, 11808);
      return localLinkedList;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      GMTrace.o(1584842932224L, 11808);
      return localLinkedList;
    }
    a locala = new a();
    for (;;)
    {
      locala.b(localCursor);
      qc localqc = new qc();
      try
      {
        localqc.trS = bf.getInt(locala.field_expId, 0);
        localqc.priority = locala.field_prioritylevel;
        localLinkedList.add(localqc);
        if (localCursor.moveToNext()) {
          continue;
        }
        localCursor.close();
        GMTrace.o(1584842932224L, 11808);
        return localLinkedList;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", new Object[] { locala.field_expId });
        }
      }
    }
  }
  
  public final String bKz()
  {
    GMTrace.i(1585379803136L, 11812);
    Object localObject = Kl();
    if (localObject == null)
    {
      GMTrace.o(1585379803136L, 11812);
      return "null cursor!!";
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      GMTrace.o(1585379803136L, 11812);
      return "cursor empty!!";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = new a();
    do
    {
      localStringBuilder.append("============\n");
      locala.b((Cursor)localObject);
      localStringBuilder.append("abtestkey = ").append(locala.field_abtestkey).append("\n");
      localStringBuilder.append("sequence = ").append(locala.field_sequence).append("\n");
      localStringBuilder.append("priorityLV = ").append(locala.field_prioritylevel).append("\n");
      localStringBuilder.append("expId = ").append(locala.field_expId).append("\n");
    } while (((Cursor)localObject).moveToNext());
    ((Cursor)localObject).close();
    localObject = localStringBuilder.toString();
    GMTrace.o(1585379803136L, 11812);
    return (String)localObject;
  }
  
  public final int cF(String paramString, int paramInt)
  {
    GMTrace.i(15300418338816L, 113997);
    paramString = QB(paramString);
    if (paramString.isValid())
    {
      paramInt = bf.getInt(paramString.field_value, paramInt);
      GMTrace.o(15300418338816L, 113997);
      return paramInt;
    }
    GMTrace.o(15300418338816L, 113997);
    return paramInt;
  }
  
  public final String getExpIdByKey(String paramString)
  {
    GMTrace.i(1585245585408L, 11811);
    paramString = QB(paramString);
    if (paramString.isValid())
    {
      if (paramString.field_expId == null)
      {
        GMTrace.o(1585245585408L, 11811);
        return "";
      }
      paramString = paramString.field_expId;
      GMTrace.o(1585245585408L, 11811);
      return paramString;
    }
    GMTrace.o(1585245585408L, 11811);
    return "";
  }
  
  public final void i(List<a> paramList, int paramInt)
  {
    GMTrace.i(1584708714496L, 11807);
    int i = 0;
    long l = bf.Nz();
    this.gUp.delete("ABTestInfo", String.format(Locale.US, "%s<>0 and %s<%d", new Object[] { "endTime", "endTime", Long.valueOf(l) }), null);
    a locala1;
    if (1 == paramInt)
    {
      locala1 = new a();
      locala1.field_prioritylevel = 1;
      b(locala1, false, new String[] { "prioritylevel" });
    }
    paramList = paramList.iterator();
    paramInt = i;
    boolean bool;
    if (paramList.hasNext())
    {
      locala1 = (a)paramList.next();
      if ((locala1 == null) || (bf.mA(locala1.field_abtestkey)))
      {
        v.e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
        bool = false;
        label152:
        if (!bool) {
          break label454;
        }
        paramInt = 1;
      }
    }
    label454:
    for (;;)
    {
      break;
      a locala2 = new a();
      locala2.field_abtestkey = locala1.field_abtestkey;
      if (!super.b(locala2, new String[0]))
      {
        bool = super.a(locala1, false);
        v.i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", new Object[] { locala1.field_abtestkey, Boolean.valueOf(bool) });
        break label152;
      }
      if (((locala1.field_sequence > locala2.field_sequence) && (locala1.field_prioritylevel == locala2.field_prioritylevel)) || (locala1.field_prioritylevel > locala2.field_prioritylevel))
      {
        bool = super.a(locala1, false, new String[0]);
        v.i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { locala1.field_abtestkey, Boolean.valueOf(bool), Long.valueOf(locala2.field_sequence), Long.valueOf(locala1.field_sequence), Integer.valueOf(locala2.field_prioritylevel), Integer.valueOf(locala1.field_prioritylevel) });
        break label152;
      }
      v.i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { locala1.field_abtestkey, Long.valueOf(locala2.field_sequence), Long.valueOf(locala1.field_sequence), Integer.valueOf(locala2.field_prioritylevel), Integer.valueOf(locala1.field_prioritylevel) });
      bool = false;
      break label152;
      if (paramInt != 0) {
        Qq("event_updated");
      }
      GMTrace.o(1584708714496L, 11807);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
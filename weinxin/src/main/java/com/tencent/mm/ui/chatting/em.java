package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class em
{
  private static LinkedList<View> vMI;
  private static LinkedList<View> vMJ;
  
  static
  {
    GMTrace.i(2302907777024L, 17158);
    vMI = new LinkedList();
    vMJ = new LinkedList();
    GMTrace.o(2302907777024L, 17158);
  }
  
  public static View AZ(int paramInt)
  {
    GMTrace.i(2302505123840L, 17155);
    if (paramInt == 1) {}
    for (Object localObject = vMI; ((LinkedList)localObject).size() != 0; localObject = vMJ)
    {
      localObject = (View)((LinkedList)localObject).removeFirst();
      GMTrace.o(2302505123840L, 17155);
      return (View)localObject;
    }
    GMTrace.o(2302505123840L, 17155);
    return null;
  }
  
  public static void J(View paramView, int paramInt)
  {
    GMTrace.i(2302639341568L, 17156);
    if (paramInt == 1) {}
    for (LinkedList localLinkedList = vMI;; localLinkedList = vMJ)
    {
      if (localLinkedList.size() >= 35) {
        localLinkedList.removeFirst();
      }
      localLinkedList.addLast(paramView);
      GMTrace.o(2302639341568L, 17156);
      return;
    }
  }
  
  public static void clear()
  {
    GMTrace.i(2302773559296L, 17157);
    vMI.clear();
    vMJ.clear();
    GMTrace.o(2302773559296L, 17157);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
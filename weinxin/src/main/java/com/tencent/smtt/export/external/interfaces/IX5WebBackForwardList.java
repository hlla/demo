package com.tencent.smtt.export.external.interfaces;

public abstract interface IX5WebBackForwardList
{
  public abstract int getCurrentIndex();
  
  public abstract IX5WebHistoryItem getCurrentItem();
  
  public abstract IX5WebHistoryItem getItemAtIndex(int paramInt);
  
  public abstract int getSize();
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/export/external/interfaces/IX5WebBackForwardList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
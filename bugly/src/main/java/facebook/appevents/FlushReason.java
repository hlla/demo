package com.facebook.appevents;

 enum FlushReason
{
  EXPLICIT,  TIMER,  SESSION_CHANGE,  PERSISTED_EVENTS,  EVENT_THRESHOLD,  EAGER_FLUSHING_EVENT;
  
  private FlushReason() {}
}


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/appevents/FlushReason.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
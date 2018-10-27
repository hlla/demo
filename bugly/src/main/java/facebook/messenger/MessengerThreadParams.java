/*    */ package com.facebook.messenger;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MessengerThreadParams
/*    */ {
/*    */   public final Origin origin;
/*    */   public final String threadToken;
/*    */   public final String metadata;
/*    */   public final List<String> participants;
/*    */   
/*    */   public static enum Origin
/*    */   {
/* 38 */     REPLY_FLOW, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 43 */     COMPOSE_FLOW, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 48 */     UNKNOWN;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     private Origin() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public MessengerThreadParams(Origin origin, String threadToken, String metadata, List<String> participants)
/*    */   {
/* 81 */     this.threadToken = threadToken;
/* 82 */     this.metadata = metadata;
/* 83 */     this.participants = participants;
/* 84 */     this.origin = origin;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/messenger/MessengerThreadParams.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
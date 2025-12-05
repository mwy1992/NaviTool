package com.ecarx.xui.adaptapi.navigation.ehp.v2;

public interface IHznEdgeMessage extends IV2Message {
  int getComplexIntersection();
  
  int getFormOfWay();
  
  int getFunctionalRoadClass();
  
  int getNumberOfLanesInDrivingDirection();
  
  int getNumberOfLanesInOppositeDirection();
  
  int getOffset();
  
  int getPartOfCalculatedRoute();
  
  int getPathIndex();
  
  int getRelativeProbability();
  
  int getRightofWay();
  
  int getSubPathIndex();
  
  int getTurnAngle();
  
  int isLastStubAtOffset();
  
  int isRetransmission();
  
  int isUpdate();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\v2\IHznEdgeMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
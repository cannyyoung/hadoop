package org.apache.hadoop.yarn.server.nodemanager.containermanager.monitor;

import org.apache.hadoop.yarn.api.records.ContainerId;
import org.apache.hadoop.yarn.server.nodemanager.containermanager.container.ContainerEvent;
import org.apache.hadoop.yarn.server.nodemanager.containermanager.container.ContainerState;

public class ContainerStateEvent extends ContainersMonitorEvent {

  private ContainerEvent event;
  private ContainerState preState;
  private ContainerState postState;
  private long timestamp;
  private String classname;
  private Boolean success;

  public ContainerStateEvent(ContainerId containerId,
      ContainersMonitorEventType eventType, String classname,
      ContainerEvent event, ContainerState preState, ContainerState postState,
      Boolean success) {
    super(containerId, eventType);
    this.event = event;
    this.preState = preState;
    this.postState = postState;
    this.timestamp = System.currentTimeMillis();
    this.classname = classname;
    this.success = success;
  }

  @Override
  public String toString() {
    StringBuilder strBuild = new StringBuilder();
    strBuild.append(this.timestamp).append(", ")
    .append(this.getContainerId()).append(", ")
    .append(this.classname).append(", ")
    .append(event).append(", ")
    .append(preState).append(", ")
    .append(postState);
    if (this.success != null) {
      String state = this.success ? "SUCCESS" : "FAILURE";
      strBuild.append(", ").append(state);
    }
    return strBuild.toString();
  }

}
package com.turan.po;

import java.io.Serializable;
import java.util.Date;

/**
 * active_alarm_0x66
 * @author 
 */
public class ActiveAlarm0x66 implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 记录唯一编号(平台)
     */
    private Long alarmNo;

    /**
     * 车辆id
     */
    private Long vehicleNo;

    /**
     * 报警id
     */
    private Integer alarmId;

    /**
     * 标志状态(0-不可用,1-开始标志,2-结束标志)
     */
    private Integer markStatus;

    /**
     * 车速
     */
    private Integer speed;

    /**
     * 高程
     */
    private Integer height;

    /**
     * 纬度
     */
    private Integer latitude;

    /**
     * 经度
     */
    private Integer longitude;

    /**
     * 时间
     */
    private Date time;

    /**
     * 状态位
     */
    private Integer statusBit;

    /**
     * 终端id
     */
    private String devId;

    /**
     * 报警标志号中的时间
     */
    private Date markTime;

    /**
     * 报警标志号中的序号
     */
    private Integer markSequence;

    /**
     * 附件数量
     */
    private Integer attachmentNum;

    /**
     * 预留
     */
    private Integer reserve;

    /**
     * 报警时间列表总数
     */
    private Integer eventNum;

    /**
     * 事件列表(json list)
     */
    private String eventList;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlarmNo() {
        return alarmNo;
    }

    public void setAlarmNo(Long alarmNo) {
        this.alarmNo = alarmNo;
    }

    public Long getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(Long vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public Integer getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Integer alarmId) {
        this.alarmId = alarmId;
    }

    public Integer getMarkStatus() {
        return markStatus;
    }

    public void setMarkStatus(Integer markStatus) {
        this.markStatus = markStatus;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatusBit() {
        return statusBit;
    }

    public void setStatusBit(Integer statusBit) {
        this.statusBit = statusBit;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public Date getMarkTime() {
        return markTime;
    }

    public void setMarkTime(Date markTime) {
        this.markTime = markTime;
    }

    public Integer getMarkSequence() {
        return markSequence;
    }

    public void setMarkSequence(Integer markSequence) {
        this.markSequence = markSequence;
    }

    public Integer getAttachmentNum() {
        return attachmentNum;
    }

    public void setAttachmentNum(Integer attachmentNum) {
        this.attachmentNum = attachmentNum;
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    public Integer getEventNum() {
        return eventNum;
    }

    public void setEventNum(Integer eventNum) {
        this.eventNum = eventNum;
    }

    public String getEventList() {
        return eventList;
    }

    public void setEventList(String eventList) {
        this.eventList = eventList;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ActiveAlarm0x66 other = (ActiveAlarm0x66) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAlarmNo() == null ? other.getAlarmNo() == null : this.getAlarmNo().equals(other.getAlarmNo()))
            && (this.getVehicleNo() == null ? other.getVehicleNo() == null : this.getVehicleNo().equals(other.getVehicleNo()))
            && (this.getAlarmId() == null ? other.getAlarmId() == null : this.getAlarmId().equals(other.getAlarmId()))
            && (this.getMarkStatus() == null ? other.getMarkStatus() == null : this.getMarkStatus().equals(other.getMarkStatus()))
            && (this.getSpeed() == null ? other.getSpeed() == null : this.getSpeed().equals(other.getSpeed()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getStatusBit() == null ? other.getStatusBit() == null : this.getStatusBit().equals(other.getStatusBit()))
            && (this.getDevId() == null ? other.getDevId() == null : this.getDevId().equals(other.getDevId()))
            && (this.getMarkTime() == null ? other.getMarkTime() == null : this.getMarkTime().equals(other.getMarkTime()))
            && (this.getMarkSequence() == null ? other.getMarkSequence() == null : this.getMarkSequence().equals(other.getMarkSequence()))
            && (this.getAttachmentNum() == null ? other.getAttachmentNum() == null : this.getAttachmentNum().equals(other.getAttachmentNum()))
            && (this.getReserve() == null ? other.getReserve() == null : this.getReserve().equals(other.getReserve()))
            && (this.getEventNum() == null ? other.getEventNum() == null : this.getEventNum().equals(other.getEventNum()))
            && (this.getEventList() == null ? other.getEventList() == null : this.getEventList().equals(other.getEventList()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAlarmNo() == null) ? 0 : getAlarmNo().hashCode());
        result = prime * result + ((getVehicleNo() == null) ? 0 : getVehicleNo().hashCode());
        result = prime * result + ((getAlarmId() == null) ? 0 : getAlarmId().hashCode());
        result = prime * result + ((getMarkStatus() == null) ? 0 : getMarkStatus().hashCode());
        result = prime * result + ((getSpeed() == null) ? 0 : getSpeed().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getStatusBit() == null) ? 0 : getStatusBit().hashCode());
        result = prime * result + ((getDevId() == null) ? 0 : getDevId().hashCode());
        result = prime * result + ((getMarkTime() == null) ? 0 : getMarkTime().hashCode());
        result = prime * result + ((getMarkSequence() == null) ? 0 : getMarkSequence().hashCode());
        result = prime * result + ((getAttachmentNum() == null) ? 0 : getAttachmentNum().hashCode());
        result = prime * result + ((getReserve() == null) ? 0 : getReserve().hashCode());
        result = prime * result + ((getEventNum() == null) ? 0 : getEventNum().hashCode());
        result = prime * result + ((getEventList() == null) ? 0 : getEventList().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", alarmNo=").append(alarmNo);
        sb.append(", vehicleNo=").append(vehicleNo);
        sb.append(", alarmId=").append(alarmId);
        sb.append(", markStatus=").append(markStatus);
        sb.append(", speed=").append(speed);
        sb.append(", height=").append(height);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", time=").append(time);
        sb.append(", statusBit=").append(statusBit);
        sb.append(", devId=").append(devId);
        sb.append(", markTime=").append(markTime);
        sb.append(", markSequence=").append(markSequence);
        sb.append(", attachmentNum=").append(attachmentNum);
        sb.append(", reserve=").append(reserve);
        sb.append(", eventNum=").append(eventNum);
        sb.append(", eventList=").append(eventList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
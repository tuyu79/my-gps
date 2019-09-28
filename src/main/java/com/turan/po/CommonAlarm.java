package com.turan.po;

import java.io.Serializable;
import java.util.Date;

/**
 * common_alarm
 * @author 
 */
public class CommonAlarm implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 记录唯一编号
     */
    private Long alarmNo;

    /**
     * 车辆id
     */
    private Long vehicleNo;

    /**
     * 报警类型
     */
    private Integer alarmType;

    /**
     * 状态位
     */
    private Integer statusBit;

    /**
     * 时间
     */
    private Date time;

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

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public Integer getStatusBit() {
        return statusBit;
    }

    public void setStatusBit(Integer statusBit) {
        this.statusBit = statusBit;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
        CommonAlarm other = (CommonAlarm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAlarmNo() == null ? other.getAlarmNo() == null : this.getAlarmNo().equals(other.getAlarmNo()))
            && (this.getVehicleNo() == null ? other.getVehicleNo() == null : this.getVehicleNo().equals(other.getVehicleNo()))
            && (this.getAlarmType() == null ? other.getAlarmType() == null : this.getAlarmType().equals(other.getAlarmType()))
            && (this.getStatusBit() == null ? other.getStatusBit() == null : this.getStatusBit().equals(other.getStatusBit()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAlarmNo() == null) ? 0 : getAlarmNo().hashCode());
        result = prime * result + ((getVehicleNo() == null) ? 0 : getVehicleNo().hashCode());
        result = prime * result + ((getAlarmType() == null) ? 0 : getAlarmType().hashCode());
        result = prime * result + ((getStatusBit() == null) ? 0 : getStatusBit().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
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
        sb.append(", alarmType=").append(alarmType);
        sb.append(", statusBit=").append(statusBit);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
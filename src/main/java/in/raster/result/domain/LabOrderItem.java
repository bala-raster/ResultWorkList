package in.raster.result.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Component
@Entity
@Table(name = "LAB_ORDER_ITEM")
public class LabOrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "lab_order_id")
	private Long labOrderId;

	@Column(name = "sample_no")
	private String sampleNumber;

	@Column(name = "test_code")
	private String testCode;

	@Column(name = "test_name")
	private String testName;

	@Column(name = "request_time")
	private String requestTime;

	@Column(name = "specimen_action_code")
	private String specimenActionCode;

	@Column(name = "specimen_type")
	private String specimenType;

	@Column(name = "ordering_doctor_code")
	private String orderingDoctorCode;

	@Column(name = "ordering_doctor_name")
	private String orderingDoctorName;

	@Column(name = "ordering_location")
	private String orderingLocation;

	@Column(name = "lab_code")
	private String labCode;

	@Column(name = "processed")
	private Boolean processed;

	@Column(name = "processed_time")
	private Date processedTime;

	@Column(name = "machine_name")
	private String machineName;

	@Column(name = "result")
	private String result;

	@Column(name = "unit")
	private String unit;

	@Column(name = "reference_range")
	private String referenceRange;

	@Column(name = "abnormal_flag")
	private String abnormalFlag;

	@Column(name = "observation_status")
	private String observationStatus;

	@Column(name = "observation_method")
	private String observationMethod;

	@Column(name = "approved")
	private String approved;

	@Column(name = "approved_time")
	private Date approvedTime;

	@Column(name = "approved_user_id")
	private Long approvedUserId;

	@Column(name = "sent")
	private Boolean sent;

	@Column(name = "sent_time")
	private Date sentTime;

	@Column(name = "remote_reply")
	private String remoteReply;

	@Column(name = "observation_time")
	private Date observationTime;

	@Column(name = "result_type")
	private String resultType;

	@Column(name = "test_group_code")
	private String testGroupCode;

	@Column(name = "ward_name")
	private String wardName;

	@Column(name = "lab_ref_no")
	private String labRefNo;

	@Column(name = "lab_id")
	private String labId;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "requisition_id")
	private String requisitionId;

	@Column(name = "requisition_year")
	private String requisitionYear;

	@Transient
	private String strSendTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getLabOrderId() {
		return labOrderId;
	}

	public void setLabOrderId(Long labOrderId) {
		this.labOrderId = labOrderId;
	}

	public String getSampleNumber() {
		return sampleNumber;
	}

	public void setSampleNumber(String sampleNumber) {
		this.sampleNumber = sampleNumber;
	}

	public String getTestCode() {
		return testCode;
	}

	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getSpecimenActionCode() {
		return specimenActionCode;
	}

	public void setSpecimenActionCode(String specimenActionCode) {
		this.specimenActionCode = specimenActionCode;
	}

	public String getSpecimenType() {
		return specimenType;
	}

	public void setSpecimenType(String specimenType) {
		this.specimenType = specimenType;
	}

	public String getOrderingDoctorCode() {
		return orderingDoctorCode;
	}

	public void setOrderingDoctorCode(String orderingDoctorCode) {
		this.orderingDoctorCode = orderingDoctorCode;
	}

	public String getOrderingDoctorName() {
		return orderingDoctorName;
	}

	public void setOrderingDoctorName(String orderingDoctorName) {
		this.orderingDoctorName = orderingDoctorName;
	}

	public String getOrderingLocation() {
		return orderingLocation;
	}

	public void setOrderingLocation(String orderingLocation) {
		this.orderingLocation = orderingLocation;
	}

	public String getLabCode() {
		return labCode;
	}

	public void setLabCode(String labCode) {
		this.labCode = labCode;
	}

	public Boolean getProcessed() {
		return processed;
	}

	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}

	public Date getProcessedTime() {
		return processedTime;
	}

	public void setProcessedTime(Date processedTime) {
		this.processedTime = processedTime;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getReferenceRange() {
		return referenceRange;
	}

	public void setReferenceRange(String referenceRange) {
		this.referenceRange = referenceRange;
	}

	public String getAbnormalFlag() {
		return abnormalFlag;
	}

	public void setAbnormalFlag(String abnormalFlag) {
		this.abnormalFlag = abnormalFlag;
	}

	public String getObservationStatus() {
		return observationStatus;
	}

	public void setObservationStatus(String observationStatus) {
		this.observationStatus = observationStatus;
	}

	public String getObservationMethod() {
		return observationMethod;
	}

	public void setObservationMethod(String observationMethod) {
		this.observationMethod = observationMethod;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public Date getApprovedTime() {
		return approvedTime;
	}

	public void setApprovedTime(Date approvedTime) {
		this.approvedTime = approvedTime;
	}

	public Long getApprovedUserId() {
		return approvedUserId;
	}

	public void setApprovedUserId(Long approvedUserId) {
		this.approvedUserId = approvedUserId;
	}

	public Boolean getSent() {
		return sent;
	}

	public void setSent(Boolean sent) {
		this.sent = sent;
	}

	public Date getSentTime() {
		return sentTime;
	}

	public void setSentTime(Date sentTime) {
		this.sentTime = sentTime;
	}

	public String getRemoteReply() {
		return remoteReply;
	}

	public void setRemoteReply(String remoteReply) {
		this.remoteReply = remoteReply;
	}

	public Date getObservationTime() {
		return observationTime;
	}

	public void setObservationTime(Date observationTime) {
		this.observationTime = observationTime;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getTestGroupCode() {
		return testGroupCode;
	}

	public void setTestGroupCode(String testGroupCode) {
		this.testGroupCode = testGroupCode;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public String getLabRefNo() {
		return labRefNo;
	}

	public void setLabRefNo(String labRefNo) {
		this.labRefNo = labRefNo;
	}

	public String getLabId() {
		return labId;
	}

	public void setLabId(String labId) {
		this.labId = labId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getRequisitionYear() {
		return requisitionYear;
	}

	public void setRequisitionYear(String requisitionYear) {
		this.requisitionYear = requisitionYear;
	}

	public String getStrSendTime() {
		return strSendTime;
	}

	public void setStrSendTime(String strSendTime) {
		this.strSendTime = new SimpleDateFormat("yyyy-MM-dd").format(sentTime);
	}
	
	
}

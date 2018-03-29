package in.raster.result.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Order;
import com.mysema.query.types.OrderSpecifier;

import in.raster.result.domain.LabOrderItem;
import in.raster.result.domain.QLabOrderItem;
import in.raster.result.repository.LabOrderItemRepository;


@RestController
public class LablinkController {

	private static final Logger logger = Logger.getLogger(LablinkController.class);

	private static QLabOrderItem qLabOrderItem = QLabOrderItem.labOrderItem;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	LabOrderItem labOrderItem;

	@Autowired
	LabOrderItemRepository labOrderItemRepository;

	@GetMapping("/patientDetails")
	public List<LabOrderItem> getPatientList() {
		JPAQuery query = new JPAQuery(entityManager);
		return query.from(qLabOrderItem).limit(100)
				.orderBy(new OrderSpecifier<>(Order.DESC, QLabOrderItem.labOrderItem.id)).list(qLabOrderItem);

	}

	@GetMapping("/machineList")
	public List<String> getMachineList(HttpServletRequest request) {
		List<String> machineList = new ArrayList<>();
		machineList.add("All");
		machineList.addAll(labOrderItemRepository.findByAllMachineList());
		return machineList;
	}

	@GetMapping("/lablink")
	public List<LabOrderItem> searchPatientList(
			@RequestParam(value = "sampleNumber", required = false) String sampleNumber,
			@RequestParam(value = "machineName", required = false) String machineName,
			@RequestParam(value = "selectedDate", required = false) String selectedDate,
			@RequestParam(value = "selectedSentDate", required = false) String selectedSentDate) {

		return getPatientList(sampleNumber, machineName, selectedDate, selectedSentDate);
	}

	@Transactional
	public List<LabOrderItem> getPatientList(String sampleNumber, String machineName, String selectedDate,
			String selectedSentDate) {
		LabOrderItem labOrderItemData = new LabOrderItem();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date javaUtilDateFormat = null;
		if (!isNullorEmpty(sampleNumber)) {
			labOrderItemData.setSampleNumber(sampleNumber);
		}
		if (!isNullorEmpty(machineName)) {
			labOrderItemData.setMachineName(machineName);
		}
		if (!selectedDate.isEmpty()) {

			try {
				javaUtilDateFormat = dateFormat.parse(selectedDate);
				java.sql.Date javaSqlDateFormat = new java.sql.Date(javaUtilDateFormat.getTime());
				labOrderItemData.setCreateTime(javaSqlDateFormat);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (!selectedSentDate.isEmpty()) {
			try {
				javaUtilDateFormat = dateFormat.parse(selectedSentDate);
				java.sql.Date javaSqlDateFormat = new java.sql.Date(javaUtilDateFormat.getTime());
				labOrderItemData.setSentTime(javaSqlDateFormat);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return searchPatientDetailList(labOrderItemData);
	}

	public Boolean isNullorEmpty(String receivedValue) {
		return ((receivedValue == null) ? true : (receivedValue.trim().isEmpty()));
	}

	private List<LabOrderItem> searchPatientDetailList(LabOrderItem receivedLabOrderItem) {
		JPAQuery query = new JPAQuery(entityManager);
		Date selectedDate = new Date();
		Date selectedDateAddedOneDay = new Date();
		int no_of_day_to_add = 1;
		if (receivedLabOrderItem != null) {
			boolean addWheresampleNumber = false;
			boolean addWheremachineName = false;
			boolean addWhereCreatedDate = false;
			boolean addWheresentTime = false;

			if (!isNullorEmpty(receivedLabOrderItem.getSampleNumber())) {
				logger.info("sampleNumber  is not empty or null" + receivedLabOrderItem.getSampleNumber());
				addWheresampleNumber = true;
			}
			if (!isNullorEmpty(receivedLabOrderItem.getMachineName())) {
				logger.info("Lab Name  is not empty or null " + receivedLabOrderItem.getMachineName());
				addWheremachineName = true;
			}
			if (receivedLabOrderItem.getCreateTime() != null) {
				logger.info("Create Time  is not empty or null " + receivedLabOrderItem.getCreateTime());

				addWhereCreatedDate = true;
				selectedDate = receivedLabOrderItem.getCreateTime();
				selectedDateAddedOneDay = new Date(selectedDate.getYear(), selectedDate.getMonth(),
						selectedDate.getDate() + no_of_day_to_add);
			}

			if (receivedLabOrderItem.getSentTime() != null) {
				logger.info("Sent Time  is not empty or null " + receivedLabOrderItem.getSentTime());

				addWheresentTime = true;
				selectedDate = receivedLabOrderItem.getSentTime();
				selectedDateAddedOneDay = new Date(selectedDate.getYear(), selectedDate.getMonth(),
						selectedDate.getDate() + no_of_day_to_add);
			}


			List<LabOrderItem> results = query.from(qLabOrderItem)
					.orderBy(new OrderSpecifier<>(Order.DESC, qLabOrderItem.labOrderItem.id))
					.where(addWheresampleNumber
							? qLabOrderItem.sampleNumber.like(receivedLabOrderItem.getSampleNumber().toUpperCase())
							: null)
					.where(addWheremachineName
							? qLabOrderItem.machineName.equalsIgnoreCase(receivedLabOrderItem.getMachineName())
							: null)
					.where(addWhereCreatedDate
							? qLabOrderItem.createTime.between(receivedLabOrderItem.getCreateTime(),
									selectedDateAddedOneDay)
							: null)
					.where(addWheresentTime
							? qLabOrderItem.sentTime.between(receivedLabOrderItem.getSentTime(),
									selectedDateAddedOneDay)
							: null)
					.list(qLabOrderItem);
			// System.out.println(results.size());
			return results;

		} else {
			return getPatientList();
		}

	}

}

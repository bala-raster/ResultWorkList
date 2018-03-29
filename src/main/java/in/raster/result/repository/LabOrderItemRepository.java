package in.raster.result.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.raster.result.domain.LabOrderItem;



@Repository
public interface LabOrderItemRepository
		extends JpaRepository<LabOrderItem, Long>, JpaSpecificationExecutor<LabOrderItem> {

	@Query(value = "select distinct(machine_name) from lab_order_item where machine_name is not null", nativeQuery = true)
	List<String> findByAllMachineList();

}

package in.raster.result.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QLabOrderItem is a Querydsl query type for LabOrderItem
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QLabOrderItem extends EntityPathBase<LabOrderItem> {

    private static final long serialVersionUID = -235697483;

    public static final QLabOrderItem labOrderItem = new QLabOrderItem("labOrderItem");

    public final StringPath abnormalFlag = createString("abnormalFlag");

    public final StringPath approved = createString("approved");

    public final DateTimePath<java.util.Date> approvedTime = createDateTime("approvedTime", java.util.Date.class);

    public final NumberPath<Long> approvedUserId = createNumber("approvedUserId", Long.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath labCode = createString("labCode");

    public final StringPath labId = createString("labId");

    public final NumberPath<Long> labOrderId = createNumber("labOrderId", Long.class);

    public final StringPath labRefNo = createString("labRefNo");

    public final StringPath machineName = createString("machineName");

    public final StringPath observationMethod = createString("observationMethod");

    public final StringPath observationStatus = createString("observationStatus");

    public final DateTimePath<java.util.Date> observationTime = createDateTime("observationTime", java.util.Date.class);

    public final StringPath orderingDoctorCode = createString("orderingDoctorCode");

    public final StringPath orderingDoctorName = createString("orderingDoctorName");

    public final StringPath orderingLocation = createString("orderingLocation");

    public final BooleanPath processed = createBoolean("processed");

    public final DateTimePath<java.util.Date> processedTime = createDateTime("processedTime", java.util.Date.class);

    public final StringPath referenceRange = createString("referenceRange");

    public final StringPath remarks = createString("remarks");

    public final StringPath remoteReply = createString("remoteReply");

    public final StringPath requestTime = createString("requestTime");

    public final StringPath requisitionId = createString("requisitionId");

    public final StringPath requisitionYear = createString("requisitionYear");

    public final StringPath result = createString("result");

    public final StringPath resultType = createString("resultType");

    public final StringPath sampleNumber = createString("sampleNumber");

    public final BooleanPath sent = createBoolean("sent");

    public final DateTimePath<java.util.Date> sentTime = createDateTime("sentTime", java.util.Date.class);

    public final StringPath specimenActionCode = createString("specimenActionCode");

    public final StringPath specimenType = createString("specimenType");

    public final StringPath testCode = createString("testCode");

    public final StringPath testGroupCode = createString("testGroupCode");

    public final StringPath testName = createString("testName");

    public final StringPath unit = createString("unit");

    public final StringPath wardName = createString("wardName");

    public QLabOrderItem(String variable) {
        super(LabOrderItem.class, forVariable(variable));
    }

    public QLabOrderItem(Path<? extends LabOrderItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLabOrderItem(PathMetadata<?> metadata) {
        super(LabOrderItem.class, metadata);
    }

}


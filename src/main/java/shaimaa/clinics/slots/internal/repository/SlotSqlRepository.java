package shaimaa.clinics.slots.internal.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class SlotSqlRepository {
    private final EntityManager entityManager;

    SlotSqlRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<SlotEntity> getSlots(UUID doctorId) {
        String sql = "%s %s".formatted(
                "SELECT *",
                "FROM slot"
//                "WHERE doctor_id :doctor_id"
        );

        Query query = this.entityManager.createNativeQuery(sql);
//        query.setParameter("doctor_id", doctorId);
        List<Object[]> results = query.getResultList();

        List<SlotEntity> slotEntities = new ArrayList<>();
        for(Object[] row: results) {
            SlotEntity slotEntity = (SlotEntity) row[0];
            slotEntities.add(slotEntity);
        }

        return slotEntities;
    }

    public List<SlotEntity> getAvailableSlots(UUID doctorId) {
        return null;
    }

    public void createSlot(SlotEntity slotEntity) {
        this.entityManager.persist(slotEntity);
    }
}

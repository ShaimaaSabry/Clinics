package shaimaa.clinics.slots.internal.business;

import shaimaa.clinics.slots.internal.repository.SlotEntity;
import shaimaa.clinics.slots.internal.repository.SlotSqlRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SlotService {
    private static final UUID DOCTOR_ID = null;

    private final SlotSqlRepository slotSqlRepository;

    SlotService(final SlotSqlRepository slotSqlRepository) {
        this.slotSqlRepository = slotSqlRepository;
    }

    public List<SlotEntity> getSlots() {
        return this.slotSqlRepository.getSlots(DOCTOR_ID);
    }

    public List<SlotEntity> getAvailableSlots() {
        return this.slotSqlRepository.getAvailableSlots(DOCTOR_ID);
    }

    public SlotEntity createSlot(SlotEntity slotEntity) {
        slotEntity.setReserved(false);
        this.slotSqlRepository.createSlot(slotEntity);
        return slotEntity;
    }
}

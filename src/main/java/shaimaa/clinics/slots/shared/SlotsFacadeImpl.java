package shaimaa.clinics.slots.shared;

import shaimaa.clinics.slots.internal.business.SlotService;
import shaimaa.clinics.slots.internal.repository.SlotEntity;

import java.util.List;
import java.util.UUID;

class SlotsFacadeImpl implements SlotsFacade {
    private final SlotService slotService;

    SlotsFacadeImpl(final SlotService slotService) {
        this.slotService = slotService;
    }

    @Override
    public List<SlotResponse> getAvailableSlots() {
        List<SlotEntity> slots = this.slotService.getAvailableSlots();

        return slots
                .stream()
                .map(SlotResponse::from)
                .toList();
    }

    @Override
    public SlotResponse getSlotById(UUID slotId) {
        return null;
    }
}

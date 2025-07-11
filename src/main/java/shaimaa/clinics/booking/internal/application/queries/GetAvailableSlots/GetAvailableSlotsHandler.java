package shaimaa.clinics.booking.internal.application.queries.GetAvailableSlots;

import shaimaa.clinics.booking.internal.domain.contracts.SlotsGateway;
import shaimaa.clinics.booking.internal.domain.model.Slot;

import java.util.List;
import java.util.UUID;

public class GetAvailableSlotsHandler {
    private static final UUID DOCTOR_ID = null;

    private final SlotsGateway slotsGateway;

    GetAvailableSlotsHandler(final SlotsGateway slotsGateway) {
        this.slotsGateway = slotsGateway;
    }

    public List<Slot> handle() {
        return this.slotsGateway.getAvailableSlots(DOCTOR_ID);
    }
}

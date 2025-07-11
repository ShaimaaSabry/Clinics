package shaimaa.clinics.booking.internal.infrastructure.gateways;

import shaimaa.clinics.slots.shared.SlotsFacade;

public class SlotsClient {
    private final SlotsFacade slotsFacade;

    SlotsClient(final SlotsFacade slotsFacade) {
        this.slotsFacade = slotsFacade;
    }
}

package shaimaa.clinics.appointments.internal.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Patient {
    private UUID id;

    private String name;
}

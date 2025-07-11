package shaimaa.clinics.booking.internal.presentation.api.GetAvailbleSlots;

import io.swagger.v3.oas.annotations.media.Schema;
import shaimaa.clinics.booking.internal.domain.model.Doctor;

@Schema(hidden = true)
public record DoctorDto(
        String name
) {
    public static DoctorDto of(Doctor doctor) {
        return new DoctorDto(doctor.getName());
    }
}

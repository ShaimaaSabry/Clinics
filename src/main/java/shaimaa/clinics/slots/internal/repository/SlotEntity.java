package shaimaa.clinics.slots.internal.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "slot")
public class SlotEntity {
        @Id
    private UUID id;

    private LocalDateTime startsAt;

//    DoctorEntity doctor,

    private boolean isReserved;

    private float cost;
}

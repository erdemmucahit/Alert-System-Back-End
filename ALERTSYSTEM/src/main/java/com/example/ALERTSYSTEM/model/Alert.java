package com.example.ALERTSYSTEM.model;
import lombok.*;
import org.springframework.http.HttpMethod;
import javax.persistence.*;
import java.util.Set;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
//parametresiz yapı olulturmaya izin verir
@AllArgsConstructor
//classın her alanı için 1 paramatre oluşturur.
public class Alert {
    @Id
    @GeneratedValue
    //id sütununu artırmaya yarar.
    private Long id;
    private String alertName;
    private String url;
    private HttpMethod method;
    private Long period;
    private Long periodLeft;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "alertStatus_id")
    private Set<AlertStatus> alertStatuses;
}

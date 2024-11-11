package org.example.boundaryback.friend;

import jakarta.persistence.*;
import lombok.*;
import org.example.boundaryback.user.User;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FriendRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "sender_id", nullable = false)
  private User sender;

  @ManyToOne
  @JoinColumn(name = "receiver_id", nullable = false)
  private User receiver;

  @Enumerated(EnumType.STRING)
  private RequestStatus status = RequestStatus.PENDING;

  @Temporal(TemporalType.TIMESTAMP)
  private Date sentAt = new Date();

  public enum RequestStatus {
    PENDING, ACCEPTED, REJECTED
  }
}
package com.project.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_users")
public class UserModels {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  @Column(nullable = false)
  String username;

  @Column(nullable = false)
  String avatar;
}

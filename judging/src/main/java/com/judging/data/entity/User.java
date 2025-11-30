package com.judging.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Entity
@Table(name="users")
@Data
@ToString
public class User {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;

  @Column(name="name")
  private String name;

  @Column(name="created_at", updatable = false)
  private Instant createdAt;
}

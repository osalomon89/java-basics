package com.mercadolibre.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "code", unique = true, nullable = false)
	private String code;

	private String description;
	private String type;
	private double price;

	@Column(name = "provider_id", nullable = false)
	private int providerId;

	private int stock;

	@Column(name = "created_at", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(name = "updated_at")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
		updatedAt = createdAt;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}
}




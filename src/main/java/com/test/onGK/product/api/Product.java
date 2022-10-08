package com.test.onGK.product.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "products")
public class Product {
	  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	     
	    @Column(nullable = false, length = 128)
	    @NotNull @Length(min = 5, max = 128)
	    private String name;
	     
	    private float price;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public Product(Integer id, @NotNull @Length(min = 5, max = 128) String name, float price) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
		}

		public Product() {
			super();
		}
	 
	    // getters and setters are not shown for brevity
	    
}

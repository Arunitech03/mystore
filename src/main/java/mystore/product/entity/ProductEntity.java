/*package mystore.product.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products_list")

public class ProductEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="product_id")
    private int productId; 
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Column(name="name")
    private String name;
	
	@Column(name="price")	
	private float price;
	
	@Column(name="description")	
	private String description;
	
	   
		   public void setproductId(int productId) {
		      this.productId = productId;
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
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}

}
*/
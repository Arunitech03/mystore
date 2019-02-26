package mystore.product.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dummy")
public class dummyentity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="dum1")
    private int dum1; 
	
	@Column(name="dum2")
    private int dum2;
	
	public int getDum1() {
		return dum1;
	}

	public void setDum1(int dum1) {
		this.dum1 = dum1;
	}

	public int getDum2() {
		return dum2;
	}

	public void setDum2(int dum2) {
		this.dum2 = dum2;
	}

	
}
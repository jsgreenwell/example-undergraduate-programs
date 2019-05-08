package productDB;

import java.util.HashMap;
import java.util.Map;

public class JsonTemplate {
	
	private Map<String,String> _id = new HashMap<>(Map.of(
			"$oid", ""
			));
	private String product_name;
	private String supplier;
	private int quantity;
	private double unit_cost;
	
	public String get_id() {
		return _id.get("$oid");
	}
	
	public void set_id(Map<String,String> _id) {
		this._id = _id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnit_cost() {
		return unit_cost;
	}

	public void setUnit_cost(double unit_cost) {
		this.unit_cost = unit_cost;
	}
	
}

package company;

public class Manager extends Employee {
	private double incentive;

	public Manager() {

	}

	public Manager(double incentive) {
		this.incentive = incentive;
	}

	public Manager(String id, String name, double salary, String depy, double incentive) {
		super(id, name, salary, depy); // ���� Ŭ���� �� Employee �� Constructor �̿�.
		this.incentive = incentive;
		this.salary += this.incentive;
	}
	// ������ Override

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", salary=" + salary + ", depy=" + depy + ", incentive="
				+ incentive + "]";
	}

	@Override
	public double salaryM() {
		double money = 0;
		money = super.salaryM() + this.incentive;
		return money;
	}

}

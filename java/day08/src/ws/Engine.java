package ws;

public class Engine {
//1. ����
//�Ӽ�:��ⷮ, �������(4����, 6����)
//���: ���� ���
	private int displacement;
	private int type;

	public Engine(int cc, int egSize) {
		this.displacement = cc;
		this.type = egSize;
	}

	@Override
	public String toString() {
		return "Engine [cc=" + displacement + ", egSize=" + type + "]";
	}

	public int getCc() {
		return displacement;
	}


	public int getEgSize() {
		return type;
	}

}

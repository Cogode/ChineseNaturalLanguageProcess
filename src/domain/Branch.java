package domain;

import java.util.Arrays;

import love.cq.util.AnsjArrays;

public class Branch implements WoodInterface {
	/**
	 * status ���ֵ�״̬1������ 2���Ǹ����ﵫ�ǻ����Լ��� ,3ȷ�� nature ��������
	 */
	WoodInterface[] branches = null;
	private char c;
	// ״̬
	private byte status = 1;
	// ����
	private short index = -1;
	// �������ҳ����Ķ���
	WoodInterface branch = null;
	// �ʵ��Ĳ���
	private String[] param = null;

	public WoodInterface add(WoodInterface branch) {
		if (branches == null) {
			branches = new WoodInterface[0];
		}
		if ((this.branch = get(branch.getC())) != null) {
			switch (branch.getStatus()) {
			case -1:
				this.branch.setStatus(1);
				break;
			case 1:
				if (this.branch.getStatus() == 3) {
					this.branch.setStatus(2);
				}
				break;
			case 3:
				if (this.branch.getStatus() != 3) {
					this.branch.setStatus(2);
				}
				this.branch.setParam(branch.getParams());
			}
			return this.branch;
		}
		this.index = (short) (this.index + 1);
		if (this.index + 1 > this.branches.length) {
			this.branches = ((WoodInterface[]) Arrays.copyOf(this.branches, this.index + 1));
		}
		this.branches[this.index] = branch;
		AnsjArrays.sort(this.branches);
		return branch;
	}

	public Branch(char c, int status, String[] param) {
		this.c = c;
		this.status = (byte) status;
		this.param = param;
	}

	public WoodInterface get(char c) {
		if(this.branches==null){
			return null ;
		}
		int i = AnsjArrays.binarySearch(this.branches, c);
		if (i > -1) {
			return this.branches[i];
		}
		return null;
	}

	public boolean contains(char c) {
		if(this.branches==null){
			return false ;
		}
		return AnsjArrays.binarySearch(this.branches, c) > -1;
	}

	public int compareTo(char c) {
		if (this.c > c)
			return 1;
		if (this.c < c) {
			return -1;
		}
		return 0;
	}

	public boolean equals(char c) {
		return this.c == c;
	}

	public int hashCode() {
		return this.c;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = (byte) status;
	}

	public char getC() {
		return this.c;
	}

	public String[] getParams() {
		return this.param;
	}

	public void setParam(String[] param) {
		this.param = param;
	}
}

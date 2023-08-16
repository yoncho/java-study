package prob03;

import java.util.Objects;

public class Money {
	private int amount;
	public Money(int amount) {
		this.amount = amount;
	}
	/* 코드 작성 */
	public Money add(Money m) {
		
		return new Money(this.amount + m.amount);
	}
	
	public Money minus(Money m) {
		
		return new Money(this.amount - m.amount);
	}
	public Money multiply(Money m) {
		
		return new Money(this.amount * m.amount);
	}
	public Money devide(Money m) {
		
		return new Money(this.amount / m.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}
	
	
}

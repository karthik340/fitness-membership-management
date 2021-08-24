package fitness;

public interface Calculator<T extends Number> {
	double calculateFees(T clubId);
}

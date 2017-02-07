import java.util.Arrays;

public final class ArrayStack<T> implements StackInterface<T> {
	private T[] stack;
	private int topIndex;
	private static final int DEFAULTINICAP = 10;

	public ArrayStack() {
		this(DEFAULTINICAP);
	}

	public ArrayStack(int arrayElements) {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[arrayElements];
		stack = tempStack;
		topIndex = -1;
	}

	public void push(T newEntry) {
		ensureCapacity();
		topIndex++;
		stack[topIndex] = newEntry;
	}

	private void ensureCapacity() {
		if (topIndex == stack.length - 1) {
			stack = Arrays.copyOf(stack, 2 * stack.length);
		}
	}

	public T pop() {
		T top = null;
		if (!isEmpty())
			top = stack[topIndex];
		return top;
	}

	public T peek() {
		T top = null;
		if (!isEmpty())
			top = stack[topIndex];
		return top;
	}

	public boolean isEmpty() {
		return topIndex < 0;
	}

	public void clear() {
		for (int i = 0; i < stack.length; i++)
			stack[i] = null;
	}

}
